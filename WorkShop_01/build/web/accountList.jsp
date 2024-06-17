<%-- 
    Document   : accountList
    Created on : Feb 23, 2024, 4:22:12 PM
    Author     : manhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Account In System</title>
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
        <c:if test="${USER == null}">
            <c:redirect url="index.jsp"/>
        </c:if>

        <%@include file="adminHead.jsp" %>
        <div id="listAccount">
            <h1>List of account in system</h1>
            <div class="table-responsive">
                <table class="table table-tripped">

                    <c:forEach items="${A}" var="i">
                        <tr class="account-row">
                            <td>${i.account}</td>
                            <td>${i.firstName}, ${i.lastName}</td>
                            <td>
                                <fmt:formatDate pattern="yyyy-MM-dd" value="${i.birthday}"/>
                            </td>
                            <td>${i.gender?"Male":"Female"}</td>
                            <td>${i.phone}</td>
                            <td>${i.roleInSystem==1?"Administrator":"Staff"}</td>
                            <td>
                                <!--                        <form action="acc_process" method="post">
                                                            <input type="hidden" name="actionType" value="UPD#${i.account}"/>
                                                            <input type="submit" class="btn btn-primary" value="Update"/>
                                                        </form>
                                                        <form action="acc_process" method="post">
                                                            <input type="hidden" name="actionType" value="ATV#${i.account}"/>
                                                            <input type="submit" class="btn btn-success" value='${i.isUse?"Deactive":"Active"}'/>
                                                        </form>
                                                        <form action="acc_process" method="post">
                                                            <input type="hidden" name="actionType" value="DEL#${i.account}"/>
                                                            <input type="submit" class="btn btn-danger" value="delete"/>
                                                        </form>
                                -->
                                
                                <button class="btn btn-primary" data-isuse="999" value="UPD#${i.account}" onclick="validateForm(event)">Update</button>
                                <button class="btn btn-success activate-btn" data-isuse="${i.isUse ? 0 : 1}" value="ATV#${i.account}" onclick="validateForm(event)">${i.isUse?"Deactive":"Active"}</button>
                                <button class="btn btn-danger" data-isuse="999" value="DEL#${i.account}" onclick="validateForm(event)">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <%@include file="adminFooter.jsp" %>

        <script src="JavaScript/accountList.js"></script>
        
    </body>
</html>
