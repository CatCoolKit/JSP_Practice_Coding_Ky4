<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : Dec 19, 2023, 9:04:57 AM
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
        <form action="add" method="POST">
            
        <table>
            <tbody>
                <tr>
                    <td>ID</td>
                    <td>
                        <input type="text" name="id" value="" />
                    </td>
                </tr>
                <tr>
                    <td>khName</td>
                    <td>
                        <input type="text" name="khname" value="" />
                    </td>
                </tr>
                <tr>
                    <td>khDate</td>
                    <td>
                        <input type="text" name="khdate" value="" />(yyyy-MM-dd)
                    </td>
                </tr>
                <tr>
                    <td>khDiachi</td>
                    <td>
                        <input type="text" name="khdiachi" value="" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <c:forEach var="at" items="${listA}">
                            <input type="checkbox" name="sauthor" value="${at.id}" />${at.name}
                            <br>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" name="action" value="Sign up to buy books" />
                    </td>
                    <td>
                        <input type="submit" name="action" value="Load List Author" />
                    </td>
                </tr>
            </tbody>
        </table>
        </form>

    </body>
</html>
