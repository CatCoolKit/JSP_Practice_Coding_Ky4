<%-- 
    Document   : error_java
    Created on : Dec 17, 2023, 8:55:31 PM
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

<h1>Java Error</h1>
<p>Sorry, Java has thrown an exception.</p>
<p>To continue, click the Back button.</p>
<input type="submit" value="Back" class="margin_left">

<h2>Details</h2>
<p>Type: ${pageContext.exception["class"]}</p>
<p>Message: ${pageContext.exception.message}</p>

</form>
</body>
</html>
