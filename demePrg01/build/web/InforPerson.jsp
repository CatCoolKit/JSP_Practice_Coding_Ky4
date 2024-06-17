<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : InforPerson
    Created on : Jan 15, 2024, 3:07:02 PM
    Author     : manhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcom!</h1>
        <form action="people1" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>DOB</th>
                        <th>Gender</th>
                        <th>Type</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <td>${user.humanName}</td>
                            <td>${user.humanDob}</td>
                            <td>${user.humangender}</td>
                            <td>${user.typeId}</td>
                            <td>
                                <form action="people1" method="POST">
                                    <input type="hidden" name="userId" value="${user.humanId}" />
                                    <input type="submit" name="action" value="Edit" />
                                </form>

                            </td>
                            <td>
                                <form action="people1" method="POST">
                                    <input type="hidden" name="userId" value="${user.humanId}" />
                                    <input type="submit" name="action" value="Delete" />
                                </form>
                            </td>

                        </tr>
                    </c:forEach>

                </tbody>
            </table>

            <input type="text" name="humanid" value="" placeholder="ID">
            <input type="text" name="humanname" value="" placeholder="Name">
            <input type="text" name="humandob" value="" placeholder="DOB">
            <input type="text" name="humangender" value="" placeholder="Gender">
            <input type="text" name="typeid" value="" placeholder="Type">

            <br>
            <input type="submit" name="action" value="Loading" />
            <input type="submit" name="action" value="Insert" />
            <input type="submit" name="action" value="Find" />

        </form>
    </body>
</html>
