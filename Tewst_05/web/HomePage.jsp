<%-- 
    Document   : HomePage
    Created on : Mar 12, 2024, 3:10:10 PM
    Author     : manhc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <style>
            .label, .btn {
                display: inline-block;
                min-width: 100px;
            }
            .box {
                border: 1px solid #333;
                width: fit-content;
            }
            .title {
                margin-bottom: 40px;
            }
        </style>
    </head>

    <body>

        <h3 class="title">Supplier filter:</h3>
        <form>
            <div class="box">
                <span class="label">Sublier name:</span>
                <input type="text" value="" name="supplierName">
                <input type="text" value="filterByName" name="Service" hidden>
                <button class="btn" type="submit">Filter by name</button>
            </div>
        </form>
        <form action="show" method="get">
            <div class="box">
                <span class="label">Year of birth:</span>
                <input type="text" value="" name="supplierYear">
                <input type="text" value="filterByYear" name="Service" hidden>
                <button class="btn" type="submit">Filter by year</button>
            </div>
        </form>
        <c:set var="list" value="${requestScope.list}"/>
        <h3 class="title">List of Suppliers:</h3>
        <div id="content">
            <table border="1">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Date of birth</th>
                        <th>Gender</th>
                        <th>Address</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="supplier" items="${list}">
                        <tr>
                            <td>${supplier.getSupplierID()}</td>
                            <td>${supplier.getSupplierName()}</td>
                            <td>${supplier.getBirthDate()}</td>
                            <td>${supplier.getGender()}</td>
                            <td>${supplier.getAddress()}</td>
                            <td><a href="?Service=delete&SupplierID=${supplier.getSupplierID()}">delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>



        <h3>So nguoi truy cap ${counter}</h3>
        <script>
            // Sử dụng window.onload để gọi hàm khi trang được tải
            window.onload = function () {
                // Tạo một yêu cầu XMLHttpRequest để gọi servlet
                var xhttp = new XMLHttpRequest();
                xhttp.open("GET", "/Tewst_05/show", true);
                xhttp.send();
            };
        </script>
    </body>
</html>
