<%-- 
    Document   : categoriesAddNew
    Created on : Feb 26, 2024, 12:33:46 PM
    Author     : manhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Category</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="styles/categoriesList.css" type="text/css"/>
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


        <div id="addCate" class="container">
            <h2>Add New Category</h2>
            <form id="formCT" class="row g-3" action="categoryNew" method="post">
                <div class="col-md-12">
                    <label for="categoryName" class="form-label">Category Name</label>
                    <input type="text" class="form-control" id="categoryName" placeholder="Enter category name" name="categoryName" >
                </div>
                <div class="col-md-12">
                    <label for="memo" class="form-label">Memo</label>
                    <textarea class="form-control" id="memo" placeholder="Enter category description" name="memo" ></textarea>
                </div>

                <div class="col-12 text-end">
                    <button id="submitBtn" class="btn btn-transparent" type="submit" class="btn btn-transparent" onclick="validateForm(event)">Submit</button>
                </div>
            </form>
        </div>

        <%@include file="adminFooter.jsp" %>

        <script src="JavaScript/categoryAdd.js"></script>
    </body>
</html>
