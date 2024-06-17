<%-- 
    Document   : addNewAccount
    Created on : Feb 25, 2024, 6:35:25 PM
    Author     : manhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Account</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="styles/accountList.css" type="text/css"/>
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

        <div id="addAccount" class="container">
            <h2>Add New Account</h2>
            <div id="error-box"></div>
            <form id="formUI" class="row g-3" action="accountNew" method="post">
                <div class="col-md-6">
                    <label for="account" class="form-label">Account</label>
                    <input type="text" class="form-control" id="account" value="" placeholder="Enter email" name="account">
                    
                </div>
                <div class="col-md-6">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="pass" value="" placeholder="Enter password" name="pass">
                </div>
                <div class="col-md-6">
                    <label for="firstName" class="form-label">First name</label>
                    <input type="text" class="form-control" id="firstName" value="" placeholder="First name" name="firstName">
                </div>
                <div class="col-md-6">
                    <label for="lastName" class="form-label">Last name</label>
                    <input type="text" class="form-control" id="lastName" value="" placeholder="Last name" name="lastName">
                </div>
                <div class="col-md-6">
                    <label for="phone" class="form-label">Phone number</label>
                    <input type="text" class="form-control" id="phone" value="" placeholder="Phone number" name="phone">
                </div>
                <div class="col-md-6">
                    <label for="birthday" class="form-label">Birth day</label>
                    <input type="date" class="form-control" id="birthday" value="" placeholder="Phone number" name="birthday">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Gender</label>
                    <div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" id="male" checked>
                            <label class="form-check-label" for="male">Male</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" id="female">
                            <label class="form-check-label" for="female">Female</label>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <label for="roleInSystem" class="form-label">Role in system</label>
                    <select class="form-select" id="roleInSystem" name="roleInSystem">
                        <option value="1" >Administrator</option>
                        <option value="2" >Manager</option>
                        <option value="3" >Team leader</option>
                        <option value="4" >Staff</option>
                        <option value="5" >Guard</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="isUse" name="isUse">
                        <label class="form-check-label" for="isUse">Is active</label>
                    </div>
                </div>
                <div class="col-12 text-end">
                    <button id="submitBtn" type="submit" class="btn btn-transparent" onclick="validateForm(event)">Submit</button>
                </div>
            </form>
        </div>

        <%@include file="adminFooter.jsp" %>
        
        <script src="JavaScript/accountAdd.js"></script>
    </body>
</html>
