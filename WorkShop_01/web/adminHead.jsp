<%-- 
    Document   : adminHead
    Created on : Feb 23, 2024, 3:13:45 PM
    Author     : manhc
--%>

<%-- any content can be specified here e.g.: --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<div class="row">
    <nav class="navbar navbar-expand-lg navbar-light bg-light border border-dark rounded-3">
        <div class="container-fluid">
            <c:set var="user" value="${USER}"></c:set>
            <c:choose>
                <c:when test="${not empty user}">
                    <a class="navbar-brand" href="#">
                        <!-- Product introduction <b class="red">Version 2.0</b>-->
                        Welcome to <b class="text-danger">${user.account}</b> [${user.lastName} ${user.firstName}]
                    </a>
                </c:when>
            </c:choose> 
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" href="dashboard.jsp">Home</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Accounts
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="accountList.jsp">List all accounts</a></li>
                            <li><a class="dropdown-item" href="addNewAccount.jsp">New account</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Categories
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="categoriesList.jsp">All categories</a></li>
                            <li><a class="dropdown-item" href="categoriesAddNew.jsp">New category</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Products
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="productList.jsp">All products</a></li>
                            <li><a class="dropdown-item" href="productAddNew.jsp">New product</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Page 2</a>
                    </li>
                </ul>
                <form class="d-flex" action="logout">
                    <button type="submit" class="btn btn-outline-dark">
                        <span class="bi bi-box-arrow-right"></span> Logout
                    </button>
                </form>
            </div>
        </div>
    </nav>
</div>


