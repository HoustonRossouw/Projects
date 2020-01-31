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
    public partial class CustomerView : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            
        }
        
        protected void btnAddNewCustomer(object sender, EventArgs e)
        {
            Response.Redirect("Customers.aspx");
        }
        
        protected void GridCustomerView_RowCommand(object sender, GridViewCommandEventArgs e)
        {
           if (e.CommandName == "EditNewScreen")
            {
                int index = Convert.ToInt32(e.CommandArgument);
                GridViewRow selectedRow = GridCustomerView.Rows[index];
                if(selectedRow != null)
                {
                    int customerID = int.Parse(selectedRow.Cells[0].Text);
                    Response.Redirect(string.Format("Customers.aspx?CustomerID={0}", customerID));
                }
            }
        }
    }
}
