﻿<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Customers.aspx.cs" CodeFile="~/Customers.aspx.cs" Inherits="WebApplication1.Customers" %>


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
            background: linear-gradient(90deg, rgba(17,153,142,1) 0%, rgba(56,239,125,1) 100%, rgba(0,212,255,1) 100%);
            border: none;
            color: white;
            padding: 10px 32px;
            text-decoration: none;
            display: inline-block;
            margin-left:25%;
            font-size: 16px;
        }

        .form_group {
            position: relative;
            padding: 15px 0 0;
            margin-left:40%;
            width: 30%;
        }
        
        .form_field {
            font-family: inherit;
            border-bottom: 2px solid #424242;
            outline: 0;
            font-size: 1.3rem;
            color: #212121;
            padding: 7px 0;
            background: transparent;
            transition: border-color 0.2s;
        
        &::placeholder {
            color:transparent;

        }
        &:placeholder-shown ~ .form_label {
            font-size: 1.3rem;
            cursor:text;
            top: 20px;

        }
      ;
            border-left-style: none;
            border-left-color: inherit;
            border-left-width: 0;
            border-right-style: none;
            border-right-color: inherit;
            border-right-width: 0;
            border-top-style: none;
            border-top-color: inherit;
            border-top-width: 0;
        }
        .form_label {
            position:absolute;
            top: 0;
            display: block;
            transition: 0.2s;
            font-size: 1rem;
            color:#424242;
        }

        .form_field:focus { 
            ~ .form_label {
            position: absolute;
            top: 0;
            display: block;
            transition: 0.2s;
            font-size: 1rem;
            color: #11998e;
            font-weight:700;    
            }
            padding-bottom: 6px;
            font-weight: 700;
            border-width: 3px;
            border-image: linear-gradient(to right, #11998e,#38ef7d);
            border-image-slice: 1;
           
         }
        .form_field{
            &:required,&:invalid { box-shadow:none; }
        }
        
    </style>
    <div>
        <h1>Customers</h1>       
        
    </div>
    <asp:Label ID="lblTitle" runat="server" Text="Add New Customer"></asp:Label>
    <div class="form_group field" >
        <br />   
        <asp:TextBox ID="txtFname" runat="server" type="text" class="form_field" placeholder="Name" name="name" required Width="100%" ></asp:TextBox>
        <br />
        <br /> 
        <asp:TextBox ID="txtAddress1" runat="server" type="text" class="form_field" placeholder="Address" name="name" required Width="100%" ></asp:TextBox>
        <br />
        <br />        
        <asp:TextBox ID="txtAddress2" runat="server" type="text" class="form_field" placeholder="Address2" name="name" Width="100%"></asp:TextBox>
        <br />
        <br />
        <asp:TextBox ID="txtAddress3" runat="server" type="text" class="form_field" placeholder="Address3" name="name" Width="100%"></asp:TextBox>
        <br />
        <br />
        <asp:TextBox ID="txtCity" runat="server" type="text" class="form_field" placeholder="City" name="name" Width="100%" required></asp:TextBox>
        <br />
        <br />
        <asp:TextBox ID="txtPostCode" runat="server" type="text" class="form_field" placeholder="ZipCode" name="name" Width="100%" required></asp:TextBox>
        <br />
        <br />        
        <asp:TextBox ID="txtPhone" runat="server" type="text" class="form_field" placeholder="Phone" name="name" Width="100%"></asp:TextBox>
        <br />
        <br />
        <asp:Label ID="labDataEnt" runat="server"></asp:Label>
        <br />      
        <asp:TextBox ID="txtFormMode" runat="server" Visible="False"></asp:TextBox>
        <asp:TextBox ID="txtCustomerID" runat="server" Visible="False"></asp:TextBox>
        <asp:Button ID="btnAddCustomers" runat="server" Text="Add" Width="127px" class="button" OnClick="btnAddCustomers_Click"/>
        <br />   
        <br />
        
        </div>
</asp:Content>
