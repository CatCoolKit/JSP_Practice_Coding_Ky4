<%-- 
    Document   : dashboard
    Created on : Feb 23, 2024, 3:10:37 PM
    Author     : manhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adminitrator pages</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
        <!-- Begin body content here -->
        
        <!-- End of body content here -->
        <%@include file="adminFooter.jsp" %>
    </body>
</html>
