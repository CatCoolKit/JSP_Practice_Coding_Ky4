<%-- 
    Document   : thanks
    Created on : Dec 17, 2023, 4:35:23 PM
    Author     : manhc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />
<h1>Thanks for joining our email list</h1>

<p>Here is the information that you entered:</p>

<label>Email:</label>
<span>${user.email}</span><br>
<label>First Name:</label>
<span>${user.firstName}</span><br>
<label>Last Name:</label>
<span>${user.lastName}</span><br>

<p>We'll use this email to notify you whenever we have new release for these types of music</p>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${user.music.isEmpty()}">
    <p><i>There are no tracks marked</i></p>
</c:if>
<c:if test="${user.music != null}">
    <p><i>${user.music}</i></p>
</c:if>

<p>To enter another email address, click on the Back 
    button in your browser or the Return button shown 
    below.</p>

<form action="" method="post">
    <input type="hidden" name="action" value="join">
    <input type="submit" value="Return">
</form>
<c:import url="/includes/footer.jsp" />
