<%-- 
    Document   : productAddNew
    Created on : Feb 26, 2024, 2:15:56 PM
    Author     : manhc
--%>

<%@page import="model.Account"%>
<%@page import="model.Category"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Product</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="styles/productList.css" type="text/css"/>
        <style type="text/css">
            .brief {
                overflow: hidden;
                display: -webkit-box;
                -webkit-line-clamp: 2; /* number of lines to show */
                line-clamp: 2; 
                -webkit-box-orient: vertical;
            }
            .rightSpan{
                display: block;
                float: right;
            }
            .red{color:#f00;}
        </style>
    </head>
    <body class="container">

        <%@include file="adminHead.jsp" %>

        <jsp:useBean id="categoryTypeDAO" class="model.dao.CategoryDAO" />
        <%
            List<Category> categoryTypes = categoryTypeDAO.listAll();
        %>
        <jsp:useBean id="accountDAO" class="model.dao.AccountDao" />
        <%
            List<Account> accountList = accountDAO.listAll();
        %>


        <div id="addPro" class="container">
            <h2>Add New Product</h2>
            <form id="formPD" class="row g-3" action="productNew" method="post">
                <div class="col-md-6">
                    <label for="productId" class="form-label">Product ID</label>
                    <input type="text" class="form-control" id="productId" value="" placeholder="Enter product ID" name="productId">
                </div>
                <div class="col-md-6">
                    <label for="productName" class="form-label">Product Name</label>
                    <input type="text" class="form-control" id="productName" value="" placeholder="Enter product name" name="productName">
                </div>
                <div class="col-md-6">
                    <label for="productImage" class="form-label">Product Image URL</label>
                    <input type="text" class="form-control" id="productImage" value="" placeholder="Enter product image URL" name="productImage">
                </div>
                <div class="col-md-6">
                    <label for="brief" class="form-label">Brief Description</label>
                    <input type="text" class="form-control" id="brief" value="" placeholder="Enter brief description" name="brief">
                </div>
                <!--                <div class="col-md-6">
                                    <label for="postedDate" class="form-label">Posted Date</label>
                                    <input type="date" class="form-control" id="postedDate" value="" name="postedDate">
                                </div>-->
                <div class="col-md-6">
                    <label class="form-label">Category Type</label>
                    <select class="form-select" id="type" name="type">
                        <%
                            for (Category categoryType : categoryTypes) {
                        %>
                        <option value="<%= categoryType.getTypeId()%>"><%= categoryType.getCategoryName()%></option>
                        <% }%>
                        <!-- Add more options as needed -->
                    </select>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Account</label>
                    <select class="form-select" id="account" name="account">
                        <%
                            for (Account account : accountList) {
                        %>
                        <option value="<%= account.getAccount()%>"><%= account.getAccount()%></option>
                        <% }%>
                    </select>
                </div>
                <div class="col-md-6">
                    <label for="unit" class="form-label">Unit</label>
                    <input type="text" class="form-control" id="unit" value="" placeholder="Enter unit" name="unit">
                </div>
                <div class="col-md-6">
                    <label for="price" class="form-label">Price</label>
                    <input type="text" class="form-control" id="price" value="" placeholder="Enter price" name="price" maxlength="15" pattern="^[0-9]*\.?[0-9]+$">
                </div>
                <div class="col-md-6">
                    <label for="discount" class="form-label">Discount</label>
                    <input type="text" class="form-control" id="discount" value="" placeholder="Enter discount" name="discount" maxlength="15" pattern="^[0-9]*\.?[0-9]+$">
                </div>

                <div class="col-12 text-end">
                    <button id="submitBtn" class="btn btn-transparent" type="submit" class="btn btn-transparent" onclick="validateForm(event)">Submit</button>
                </div>
            </form>
        </div>

        <%@include file="adminFooter.jsp" %>

        <script src="JavaScript/productAdd.js"></script>
    </body>
</html>
