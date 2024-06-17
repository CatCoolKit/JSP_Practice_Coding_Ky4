<%-- 
    Document   : homePage
    Created on : Feb 22, 2024, 1:48:39 PM
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

        <div class="row">
            <nav class="navbar navbar-dark bg-dark navbar-expand-lg rounded-3">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Product introduction <span class="text-danger">Version 2.0</span></a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="homePage.jsp">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Page 1</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Page 2</a>
                            </li>
                        </ul>
                        <ul class="navbar-nav ms-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="#"><span class="bi bi-person"></span> Sign Up</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="index.jsp"><span class="bi bi-box-arrow-in-right"></span> Login</a>
                            </li>
                        </ul>
                    </div>
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
                <div class="media col-lg-3 col-md-4 col-sm-6 col-xs-12">
                    <div class="media-left">
                        <img src="${i.productImage.startsWith('/') ? i.productImage.substring(1) : i.productImage}" alt="card image cap">
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
        <!-- Footer -->
        <footer class="text-center text-lg-start bg-body-tertiary text-muted">
            <!-- Section: Social media -->
            <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
                <!-- Left -->
                <div class="me-5 d-none d-lg-block">
                    <span>Get connected with us on social networks:</span>
                </div>
                <!-- Left -->

                <!-- Right -->
                <div>
                    <a href="" class="me-4 text-reset">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="fab fa-twitter"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="fab fa-google"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="fab fa-instagram"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="fab fa-linkedin"></i>
                    </a>
                    <a href="" class="me-4 text-reset">
                        <i class="fab fa-github"></i>
                    </a>
                </div>
                <!-- Right -->
            </section>
            <!-- Section: Social media -->

            <!-- Section: Links  -->
            <section class="">
                <div class="container text-center text-md-start mt-5">
                    <!-- Grid row -->
                    <div class="row mt-3">
                        <!-- Grid column -->
                        <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                            <!-- Content -->
                            <h6 class="text-uppercase fw-bold mb-4">
                                <i class="fas fa-gem me-3"></i>Company name
                            </h6>
                            <p>
                                Here you can use rows and columns to organize your footer content. Lorem ipsum
                                dolor sit amet, consectetur adipisicing elit.
                            </p>
                        </div>
                        <!-- Grid column -->

                        <!-- Grid column -->
                        <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                            <!-- Links -->
                            <h6 class="text-uppercase fw-bold mb-4">
                                Products
                            </h6>
                            <p>
                                <a href="#!" class="text-reset">Angular</a>
                            </p>
                            <p>
                                <a href="#!" class="text-reset">React</a>
                            </p>
                            <p>
                                <a href="#!" class="text-reset">Vue</a>
                            </p>
                            <p>
                                <a href="#!" class="text-reset">Laravel</a>
                            </p>
                        </div>
                        <!-- Grid column -->

                        <!-- Grid column -->
                        <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                            <!-- Links -->
                            <h6 class="text-uppercase fw-bold mb-4">
                                Useful links
                            </h6>
                            <p>
                                <a href="#!" class="text-reset">Pricing</a>
                            </p>
                            <p>
                                <a href="#!" class="text-reset">Settings</a>
                            </p>
                            <p>
                                <a href="#!" class="text-reset">Orders</a>
                            </p>
                            <p>
                                <a href="#!" class="text-reset">Help</a>
                            </p>
                        </div>
                        <!-- Grid column -->

                        <!-- Grid column -->
                        <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                            <!-- Links -->
                            <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                            <p><i class="fas fa-home me-3"></i> New York, NY 10012, US</p>
                            <p>
                                <i class="fas fa-envelope me-3"></i>
                                info@example.com
                            </p>
                            <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
                            <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
                        </div>
                        <!-- Grid column -->
                    </div>
                    <!-- Grid row -->
                </div>
            </section>
            <!-- Section: Links  -->

            <!-- Copyright -->
            <div class="text-center p-4" style="background-color: rgba(15, 20, 6, 0.2);">
                © 2021 Copyright:
                <a class="text-reset fw-bold" href="https://mdbootstrap.com/">MDBootstrap.com</a>
            </div>
            <!-- Copyright -->
        </footer>
        <!-- Footer -->

        <script src="JavaScript/homePage.js"></script>
    </body>

</html>

