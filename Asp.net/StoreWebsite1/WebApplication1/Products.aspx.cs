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
    public partial class Products : System.Web.UI.Page
    {

        private int ProductID = -1;
        private bool EditMode = false;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Request.QueryString["ProductID"] != null && !Page.IsPostBack)
            {
                this.ProductID = int.Parse(Request.QueryString["ProductID"]);
                if (ProductID < 0)
                    throw new ArgumentOutOfRangeException("Product ID is invalid");

                SqlCommand cmd = new SqlCommand();
                string con = ConfigurationManager.ConnectionStrings["DefaultConnection"].ConnectionString;
                SqlConnection db = new SqlConnection(con);
                cmd.Parameters.Add("@ProductID", SqlDbType.Int).Value = this.ProductID;
                cmd.CommandText = "GetProducts";
                cmd.Connection = db;
                cmd.CommandType = CommandType.StoredProcedure;
                db.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                try
                {
                    while (reader.Read())
                    {                        
                        txtProdName.Text = reader["Name"].ToString();
                        txtStockQnt.Text = reader["StockQuantity"].ToString();
                        txtPrice.Text = reader["Price"].ToString();
                        txtProductsID.Text = this.ProductID.ToString();
                        this.EditMode = true;
                        lblTitle.Text = "Edit Product [" + reader["Name"].ToString() + "]";
                        btnProducts.Text = "Save Edit";
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
                        this.ProductID = int.Parse(txtProductsID.Text);
                        if (ProductID <= 0 && ProductID > 100000)
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

        protected void btnProducts_Click(object sender, EventArgs e)
        {
           
            
            SqlCommand cmd = new SqlCommand();
            string con = ConfigurationManager.ConnectionStrings["DefaultConnection"].ConnectionString;
            SqlConnection db = new SqlConnection(con);
            cmd.Parameters.Add("@Name", SqlDbType.VarChar).Value = txtProdName.Text;
            cmd.Parameters.Add("@StockQuantity", SqlDbType.Int).Value = txtStockQnt.Text;
            cmd.Parameters.Add("@Price", SqlDbType.Decimal).Value = txtPrice.Text;
            
            if (this.EditMode)
            {
                cmd.CommandText = "UpdProduct";
                cmd.Parameters.Add("@ProductID", SqlDbType.Int).Value = this.ProductID;
                
            }
            else
            {
                cmd.CommandText = "InsProduct";
                               
            }
            cmd.Connection = db;
            cmd.CommandType = CommandType.StoredProcedure;
            db.Open();
            cmd.ExecuteNonQuery();
            db.Close();

            Response.Redirect("ProductsView.aspx");
        }
    }
}