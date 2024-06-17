<%-- 
    Document   : homePageVR
    Created on : Feb 23, 2024, 4:46:58 PM
    Author     : manhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product introduction site</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="styles/homePage.css" type="text/css"/>

    </head>
    <body class="container">
        <c:if test="${USER == null}">
            <c:redirect url="index.jsp"/>
        </c:if>

        <div class="row">
            <nav class="navbar navbar-dark bg-dark navbar-expand-lg rounded-3">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Product introduction <b class="text-danger">Version 2.0</b></a>
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" href="homePageVR.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Page 1</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Page 2</a>
                        </li>
                    </ul>
                    <form class="d-flex" action="logout">
                        <button type="submit" class="btn btn-outline-light">
                            <span class="bi bi-box-arrow-right"></span> Logout
                        </button>
                    </form>
                </div>
            </nav>
        </div>



        <!-- Carousel -->
        <div id="demo" class="carousel slide" data-bs-ride="carousel">

            <!-- Indicators/dots -->
            <ol class="carousel-indicators">
                <li data-bs-target="#demo" data-bs-slide-to="0" class="active"></li>
                <li data-bs-target="#demo" data-bs-slide-to="1"></li>
                <li data-bs-target="#demo" data-bs-slide-to="2"></li>
                <li data-bs-target="#demo" data-bs-slide-to="3"></li>
                <li data-bs-target="#demo" data-bs-slide-to="4"></li>
            </ol>

            <!-- The slideshow/carousel -->
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="images/XUAN_DAC_LOC_png.webp" class="d-block w-100" alt="Los Angeles">
                </div>
                <div class="carousel-item">
                    <img src="images/Coffee-Lovers-Collection-Series-2_2_jpg.webp" class="d-block w-100" alt="Chicago">
                </div>
                <div class="carousel-item">
                    <img src="images/LIMITED_EDTION__jpg.webp" class="d-block w-100" alt="New York">
                </div>
                <div class="carousel-item">
                    <img src="images/Couple_Collection_Desktop_jpg.webp" class="d-block w-100" alt="New York">
                </div>
                <div class="carousel-item">
                    <img src="images/WINTER_COLLECTION_2023_2_jpg.webp" class="d-block w-100" alt="New York">
                </div>
            </div>

            <!-- Left and right controls/icons -->
            <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

        <div id="content" class="row">
            <c:set var="list" value="${requestScope.dssp}" ></c:set>
            <c:forEach var="i" items="${list}">
                <div class="media col-md-4">
                    <div class="media-left">
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">${i.productName}</h4>
                        <p class="brief">${i.brief}</p>
                        <p> <span class="left"> Price : <b>${i.price}</b></span>
                            <c:if test="${i.discount>0}">
                                <span class="rightSpan red">Discount: <b>${i.discount}</b></span>
                            </c:if>
                        </p>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="row contact">
            <div class="container bg-light">
                <h2 class="text-center">CONTACT</h2>
                <div class="row">
                    <div class="col-sm-5">
                        <p>Contact us and we'll get back to you within 24 hours.</p>
                    </div>
                    <div class="col-sm-7">
                        <div class="row">
                            <div class="col-sm-6 form-group">
                                <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
                            </div>
                            <div class="col-sm-6 form-group">
                                <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
                            </div>
                        </div>
                        <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea><br>
                        <div class="row">
                            <div class="col-sm-12 form-group">
                                <button class="btn btn-transparent float-end" type="submit">Send</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="adminFooter.jsp" %>

        <script src="JavaScript/homePage.js"></script>
    </body>
</html>
