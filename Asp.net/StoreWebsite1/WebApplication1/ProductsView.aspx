<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="ProductsView.aspx.cs" Inherits="WebApplication1.ProductsView" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <style type="text/css">
        h1{
            position: relative;
            padding: 0 0 0;
            margin-top:3%;
            margin-left:40%;
            width: 30%;
        }    
        .button {
                background: DodgerBlue;
                border: none;
                color: white;
                padding: 10px 32px;
                text-decoration: none;
                display: inline-block;
                margin-left: 40%;
                font-size: 16px;
        }
        .button:hover{
                background-color: RoyalBlue;
        }
        .gvbutton input {
                width: 150px;
        }
        
        </style>
    <div>
        <h1>Products List</h1>
    </div>
    <asp:GridView ID="GridProductsView" runat="server" class="table table-dark" CellPadding="4" GridLines="None" AutoGenerateColumns="False" DataKeyNames="ProductID" DataSourceID="SqlDataSource1" ForeColor="#333333" OnRowCommand="GridProductsView_RowCommand">
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
        <Columns>
            <asp:BoundField DataField="ProductID" HeaderText="ProductID" InsertVisible="False" ReadOnly="True" SortExpression="ProductID" />
            <asp:BoundField DataField="Name" HeaderText="Name" SortExpression="Name" />
            <asp:BoundField DataField="StockQuantity" HeaderText="StockQuantity" SortExpression="StockQuantity" />
            <asp:BoundField DataField="Price" HeaderText="Price" SortExpression="Price" />
            <asp:CommandField ShowEditButton="True"/>
            <asp:TemplateField>
			<ItemTemplate>
                <asp:LinkButton ID="DeleteBtn" runat="server" CommandName="Delete"
				OnClientClick="if (!confirm('Are you sure you want delete?')) return false;" ><i class="fa fa-trash"></i>
                </asp:LinkButton>
			</ItemTemplate>
		</asp:TemplateField>
            <asp:ButtonField ButtonType="Button" ItemStyle-CssClass="gvbutton" Text="Edit on New Screen" CommandName="EditNewScreen" />
        </Columns>
        <EditRowStyle BackColor="#999999" />
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
        <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
        <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
        <SortedAscendingCellStyle BackColor="#E9E7E2" />
        <SortedAscendingHeaderStyle BackColor="#506C8C" />
        <SortedDescendingCellStyle BackColor="#FFFDF8" />
        <SortedDescendingHeaderStyle BackColor="#6F8DAE" />
    </asp:GridView>
    <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:DefaultConnection %>"
        SelectCommand="SELECT * FROM [Products]"
        UpdateCommand="UPDATE [Products] SET [Name] = @Name ,[StockQuantity] = @StockQuantity, [Price] = @Price
        WHERE [ProductID] = @ProductID"
        DeleteCommand="DELETE From [Products] WHERE [ProductID] = @ProductID">
        <UpdateParameters>
	    <asp:Parameter Type="String" Name="Name"></asp:Parameter>
	    <asp:Parameter Type="String" Name="StockQuantity"></asp:Parameter>
	    <asp:Parameter Type="String" Name="price"></asp:Parameter>
	    </UpdateParameters>
        <DeleteParameters>
		<asp:Parameter Name="ProductID" Type="String" />
	    </DeleteParameters>
	</asp:SqlDataSource>
    <br />
    <asp:Button ID="btnAddNewProducts" runat="server" Text="Add New Products" Width="200px" class="button" OnClick="btnAddNewProduct"/>
    
</asp:Content>
