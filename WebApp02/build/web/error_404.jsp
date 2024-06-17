<%-- 
    Document   : error_404
    Created on : Dec 17, 2023, 8:54:54 PM
    Author     : manhc
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<form action="emailList" method="post">
<input type="hidden" name="action" value="">

<h1>404 Error</h1>
<p>The server was not able to find the file you requested.</p>
<p>To continue, click the Back button.</p>

<input type="submit" value="Back" class="margin_left">
</form>
</body>
</html>
