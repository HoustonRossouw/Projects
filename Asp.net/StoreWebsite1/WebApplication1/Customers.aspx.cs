using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Configuration;
using System.Data;
using Serenity.Data;

namespace WebApplication1
{
    public partial class Customers : System.Web.UI.Page
    {
        private int CustomerID = -1;
        private bool EditMode = false;

        protected void Page_Load(object sender, EventArgs e)
        {

            if (Request.QueryString["CustomerID"] != null && !Page.IsPostBack)
            {
                this.CustomerID = int.Parse(Request.QueryString["CustomerID"]);
                if (CustomerID <= 0)
                    throw new ArgumentOutOfRangeException("Customer ID is invalid");

                SqlCommand cmd = new SqlCommand();
                string con = ConfigurationManager.ConnectionStrings["DefaultConnection"].ConnectionString;
                SqlConnection db = new SqlConnection(con);
                cmd.Parameters.Add("@CustomerID", SqlDbType.Int).Value = this.CustomerID;
                cmd.CommandText = "GetCustomer";
                cmd.Connection = db;
                cmd.CommandType = CommandType.StoredProcedure;
                db.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                try
                {
                    while (reader.Read())
                    {
                        txtFname.Text = reader["Name"].ToString();
                        txtAddress1.Text = reader["Address1"].ToString();
                        txtAddress2.Text = reader["Address2"].ToString();
                        txtAddress3.Text = reader["Address3"].ToString();
                        txtCustomerID.Text = this.CustomerID.ToString();
                        txtCity.Text = reader["City"].ToString();
                        txtPostCode.Text = reader["PostCode"].ToString();
                        txtPhone.Text = reader["Phone"].ToString();
                        this.EditMode = true;
                        lblTitle.Text = "Edit Customer [" + reader["Name"].ToString() + "]";
                        btnAddCustomers.Text = "Save Edit";
                    }
                }
                finally
                {
                    reader.Close();
                    db.Close();
                }
            }
            else
            {
                if (Page.IsPostBack)
                {
                    var tmpStr = txtFormMode.Text;

                    if (tmpStr == "edit")
                    {
                        this.EditMode = true;
                        this.CustomerID = int.Parse(txtCustomerID.Text);
                        if (CustomerID <= 0 && CustomerID > 100000)
                        {
                            throw new ArgumentOutOfRangeException("Customer ID is invalid");
                        }
                    }
                    else if (tmpStr == "add" || string.IsNullOrEmpty(tmpStr))
                    {
                        this.EditMode = false;
                    }
                    else
                    {
                        throw new InvalidProgramException("Invalid Mode");
                    }
                }
            }


            txtFormMode.Text = this.EditMode ? "edit" : "add";
        }

        protected void btnAddCustomers_Click(object sender, EventArgs e)
        {
            SqlCommand cmd = new SqlCommand();
            string con = ConfigurationManager.ConnectionStrings["DefaultConnection"].ConnectionString;
            SqlConnection db = new SqlConnection(con);
            cmd.Parameters.Add("@Name", SqlDbType.VarChar).Value = txtFname.Text;
            cmd.Parameters.Add("@Address1", SqlDbType.VarChar).Value = txtAddress1.Text;
            cmd.Parameters.Add("@Address2", SqlDbType.VarChar).Value = txtAddress2.Text;
            cmd.Parameters.Add("@Address3", SqlDbType.VarChar).Value = txtAddress3.Text;
            cmd.Parameters.Add("@City", SqlDbType.VarChar).Value = txtCity.Text;
            cmd.Parameters.Add("@PostCode", SqlDbType.Char).Value = txtPostCode.Text;
            cmd.Parameters.Add("@Phone", SqlDbType.VarChar).Value = txtPhone.Text;

            if (this.EditMode)
            {
                cmd.CommandText = "UpdCustomer";
                cmd.Parameters.Add("@CustomerID", SqlDbType.Int).Value = this.CustomerID;
            }
            else
            {
                cmd.CommandText = "InsCustomer";
            }

            cmd.Connection = db;
            cmd.CommandType = CommandType.StoredProcedure;
            db.Open();
            cmd.ExecuteNonQuery();
            db.Close();
            Response.Redirect("CustomerView.aspx");

        }

        protected void btnViewCustomersClick(object sender, EventArgs e)
        {
            Response.Redirect("CustomerView.aspx");
        }
    }
}