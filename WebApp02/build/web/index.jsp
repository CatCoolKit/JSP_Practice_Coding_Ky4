<%-- 
    Document   : index
    Created on : Dec 17, 2023, 4:31:05 PM
    Author     : manhc
--%>

<%@ include file="/includes/header.html" %>

<h1>Join our email list</h1>
<p>To join our email list, enter your name and
    email address below.</p>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${message != null}">
    <p><i>${message}</i></p>
</c:if>
<!--<p><i>${message}</i></p>-->
<form action="emailList" method="post">
    <input type="hidden" name="action" value="add">   
    
    <p style="color: red">${message1}</p>
    <label class="pad_top">Email:</label>
    <input type="email" name="email" value="${user.email}"><br>
    
    <p style="color: red">${message2}</p>
    <label class="pad_top">First Name:</label>
    <input type="text" name="firstName" value="${user.firstName}"><br>
    
    <p style="color: red">${message3}</p>
    <label class="pad_top">Last Name:</label>
    <input type="text" name="lastName" value="${user.lastName}"><br>  
    
    <p>"I'm interested in these types of music"</p>
    <label for=""music1>Rock</label>
    <input type="checkbox" id="music1" name="music" value="Rock"><br>
    <label for=""music2>Jazz</label>
    <input type="checkbox" id="music2" name="music" value="Jazz"><br>
    <label for=""music3>Country</label>
    <input type="checkbox" id="music3" name="music" value="Country"><br>
    
    <label>&nbsp;</label>
    <input type="submit" value="Join Now" class="margin_left">
</form>
<%@ include file="/includes/footer.jsp" %>
