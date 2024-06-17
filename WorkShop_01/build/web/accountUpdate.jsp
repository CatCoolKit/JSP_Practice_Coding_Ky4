<%-- 
    Document   : accountUpdate
    Created on : Feb 23, 2024, 4:08:41 PM
    Author     : manhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Update</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css" rel="stylesheet">
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
        <jsp:useBean id="ACC" class="model.Account" scope="session" >
            <jsp:setProperty name="ACC" property="*"></jsp:setProperty>
            <jsp:getProperty name="ACC" property="account"></jsp:getProperty>
            <jsp:getProperty name="ACC" property="pass"></jsp:getProperty>
            <jsp:getProperty name="ACC" property="firstName"></jsp:getProperty>
            <jsp:getProperty name="ACC" property="lastName"></jsp:getProperty>
            <jsp:getProperty name="ACC" property="phone"></jsp:getProperty>
            <jsp:getProperty name="ACC" property="birthday"></jsp:getProperty>
            <jsp:getProperty name="ACC" property="gender"></jsp:getProperty>
            <jsp:getProperty name="ACC" property="roleInSystem"></jsp:getProperty>
            <jsp:getProperty name="ACC" property="isUse"></jsp:getProperty>
        </jsp:useBean>

        <div id="addAccount" class="container">
            <h2>Account Update</h2>
            <form id="formUI" class="row g-3" action="accountUpdate" method="POST">
                <div class="col-md-6">
                    <label for="account" class="form-label">Account</label>
                    <input type="text" class="form-control" id="account" value="${ACC.account}" placeholder="Enter email" name="account" readonly>
                </div>
                <div class="col-md-6"> 
                    <label for="password" class="form-label">Password</label> 
                    <div class="input-group"> 
                        <input type="password" class="form-control" id="pass" value="${ACC.pass}" placeholder="Enter password" name="pass" onclick="togglePassword(event)"> 
                        <button class="btn btn-outline-secondary" id="togglePass" type="button"> 
                            <i class="bi bi-eye"></i> 
                        </button> 
                    </div> 
                </div> 
                <div class="col-md-6">
                    <label for="firstName" class="form-label">First name</label>
                    <input type="text" class="form-control" id="firstName" value="${ACC.firstName}" placeholder="First name" name="firstName">
                </div>
                <div class="col-md-6">
                    <label for="lastName" class="form-label">Last name</label>
                    <input type="text" class="form-control" id="lastName" value="${ACC.lastName}" placeholder="Last name" name="lastName">
                </div>
                <div class="col-md-6">
                    <label for="phone" class="form-label">Phone number</label>
                    <input type="text" class="form-control" id="phone" value="${ACC.phone}" placeholder="Phone number" name="phone">
                </div>
                <div class="col-md-6">
                    <label for="birthday" class="form-label">Birth day</label>
                    <input type="date" class="form-control" id="birthday" value="${ACC.birthday}" placeholder="Phone number" name="birthday">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Gender</label>
                    <div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" id="male" value="Male" ${ACC.gender=="Male"?"checked":"''"}>
                            <label class="form-check-label" for="male">Male</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" id="female" value="Female" ${ACC.gender=="Female"?"checked":"''"}>
                            <label class="form-check-label" for="female">Female</label>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <label for="roleInSystem" class="form-label">Role in system</label>
                    <select class="form-select" id="roleInSystem" name="roleInSystem">
                        <option value="1" ${ACC.roleInSystem==1?"selected":""}>Administrator</option>
                        <option value="2" ${ACC.roleInSystem==2?"selected":""}>Manager</option>
                        <option value="3" ${ACC.roleInSystem==3?"selected":""}>Team leader</option>
                        <option value="4" ${ACC.roleInSystem==4?"selected":""}>Staff</option>
                        <option value="5" ${ACC.roleInSystem==5?"selected":""}>Guard</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="isUse" name="isUse" ${ACC.isUse?"Checked":""}>
                        <label class="form-check-label" for="isUse">Is active</label>
                    </div>
                </div>
                <div class="col-12 text-end">
                    <button id="submitBtn" type="submit" value="UPD#${ACC.account}" class="btn btn-transparent" onclick="validateForm(event)">Update</button>
                </div>
            </form>
        </div>

        <%@include file="adminFooter.jsp" %>

        <script src="JavaScript/accountUpdate.js"></script>
    </body>
</html>

<script> document.getElementById('togglePass').addEventListener('click', function (event) {
                            const input = event.target.previousElementSibling;
                            if (input.type === 'password') {
                                input.type = 'text';
                                this.querySelector('i').classList.remove('bi-eye');
                                this.querySelector('i').classList.add('bi-eye-slash');
                            } else {
                                input.type = 'password';
                                this.querySelector('i').classList.remove('bi-eye-slash');
                                this.querySelector('i').classList.add('bi-eye');
                            }
                        });
</script>