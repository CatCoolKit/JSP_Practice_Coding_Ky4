<%-- 
    Document   : index
    Created on : Feb 19, 2024, 4:14:15 PM
    Author     : manhc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bui Manh Cuong - CE171488 -WorkShop1</title>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="styles/login.css" type="text/css"/>
        <style type="text/css">
            .cancel{
                text-decoration: none;
                color: #ffffff;
            }
        </style>
    </head>
    <body>

        <h2>Login Account</h2>

        <form action="login" method="post">
            <div class="imgcontainer">
                <img src="images/img_avatar2.png" alt="Avatar" class="avatar">
                
            </div>

            <div class="container">
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="uname" required>

                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required>
                
                <c:if test="${ErrorMessage != null}">
                    <p><i style="color: red;">${ErrorMessage}</i></p>
                </c:if>
                
                <button type="submit" name="action" value="loginUser">Login</button>
                <label>
                    <input type="checkbox" checked="checked" name="remember"> Remember me
                </label>
            </div>

            
            <div class="container" style="background-color:#f1f1f1">
                <a href="homePage.jsp" class="cancel"><button type="button" class="cancelbtn">Cancel</button></a>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form>
    </body>
</html>
