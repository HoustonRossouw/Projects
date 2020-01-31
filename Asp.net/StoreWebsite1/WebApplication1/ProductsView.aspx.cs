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
    public partial class ProductsView : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void GridProductsView_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "EditNewScreen")
            {
                int index = Convert.ToInt32(e.CommandArgument);
                GridViewRow selectedRow = GridProductsView.Rows[index];
                if (selectedRow != null)
                {
                    int productID = int.Parse(selectedRow.Cells[0].Text);
                    Response.Redirect(string.Format("Products.aspx?ProductID={0}", productID));
                }
            }
        }
        protected void btnAddNewProduct(object sender, EventArgs e)
        {
            Response.Redirect("Products.aspx");
        }
    }
}