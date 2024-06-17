<%-- 
    Document   : error_java
    Created on : Dec 17, 2023, 8:55:31 PM
    Author     : manhc
--%>

<%@page import="Object.info_User"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Login Error</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <%
            info_User user = (info_User) session.getAttribute("userT");
            if(user == null){
                response.sendRedirect("/WorkShop_1_PRJ301_2024/index.jsp");
            }
        %>
<form action="login" method="get">

<h1>Login Error</h1>
<p>You have entered the wrong account or password multiple times, please try again after 10 minutes.</p>
<p>To continue, click the Back button.</p>
<input type="submit" name="action" value="Back" class="margin_left">


</form>
</body>
</html>
