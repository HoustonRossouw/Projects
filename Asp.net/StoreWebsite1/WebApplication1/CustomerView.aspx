<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="CustomerView.aspx.cs" Inherits="WebApplication1.CustomerView" %>

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
        <h1>Customer List</h1>
    </div>
    <asp:GridView ID="GridCustomerView" runat="server" class="table table-dark" CellPadding="4" GridLines="None" AutoGenerateColumns="False" DataKeyNames="CustomerID" DataSourceID="SqlDataSource1"  OnRowCommand="GridCustomerView_RowCommand">
        <Columns>
            <asp:BoundField DataField="CustomerID" HeaderText="CustomerID" InsertVisible="False" ReadOnly="True" SortExpression="CustomerID" />
            <asp:BoundField DataField="Name" HeaderText="Name" SortExpression="Name" />
            <asp:BoundField DataField="Address1" HeaderText="Address1" SortExpression="Address1" />
            <asp:BoundField DataField="Address2" HeaderText="Address2" SortExpression="Address2" />
            <asp:BoundField DataField="Address3" HeaderText="Address3" SortExpression="Address3" />
            <asp:BoundField DataField="City" HeaderText="City" SortExpression="City" />
            <asp:BoundField DataField="PostCode" HeaderText="PostCode" SortExpression="PostCode" />
            <asp:BoundField DataField="Phone" HeaderText="Phone" SortExpression="Phone" />
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
        SelectCommand="SELECT * FROM [Customers]"
        UpdateCommand="UPDATE [Customers] SET [Name] = @Name ,[Address1] = @Address1, [Address2] = @Address2, [Address3] = @Address3, [City] = @City, [PostCode] = @PostCode, [Phone] = @phone
        WHERE [CustomerID] = @CustomerID"
        DeleteCommand="DELETE From [Customers] WHERE [CustomerID] = @CustomerID">
        <UpdateParameters>
	    <asp:Parameter Type="String" Name="Name"></asp:Parameter>
	    <asp:Parameter Type="String" Name="Address1"></asp:Parameter>
	    <asp:Parameter Type="String" Name="Address2"></asp:Parameter>
	    <asp:Parameter Type="String" Name="Address3"></asp:Parameter>
	    <asp:Parameter Type="String" Name="City"></asp:Parameter>
	    <asp:Parameter Type="String" Name="PostCode"></asp:Parameter>
	    <asp:Parameter Type="String" Name="Phone"></asp:Parameter>
	    </UpdateParameters>
        <DeleteParameters>
		<asp:Parameter Name="CustomerID" Type="String" />
	    </DeleteParameters>
	</asp:SqlDataSource>
    <br />
    <asp:Button ID="btnAddNewCustomers" runat="server" Text="Add New Customer" Width="200px" class="button" OnClick="btnAddNewCustomer"/>
    
</asp:Content>
