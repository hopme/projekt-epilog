<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 26.09.19
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%--HEADER--%>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<body data-spy="scroll" data-target="#pb-navbar" data-offset="200">

<nav class="navbar navbar-expand-lg navbar-dark pb_navbar pb_scrolled-light" id="pb-navbar">
    <div class="container">
        <a class="navbar-brand" href="<c:url value="/"/>">EpiLog</a>
        <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#probootstrap-navbar" aria-controls="probootstrap-navbar" aria-expanded="false" aria-label="Toggle navigation">
            <span><i class="ion-navicon"></i></span>
        </button>
        <div class="collapse navbar-collapse" id="probootstrap-navbar">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="<c:url value="/#section-features"/>">O aplikacji</a></li>
                <li class="nav-item"><a class="nav-link" href="<c:url value="/"/>">Recenzje</a></li>
                <li class="nav-item cta-btn ml-xl-2 ml-lg-2 ml-md-0 ml-sm-0 ml-0"><a class="nav-link" href="<c:url value="/register"/>" target="_blank"><span class="pb_rounded-4 px-4">Rejestracja</span></a></li>
            </ul>
        </div>
    </div>
</nav>


<section class="pb_cover_v3 overflow-hidden cover-bg-indigo cover-bg-opacity text-left pb_gradient_v1 pb_slant-light" id="section-home">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-6 relative align-self-center">

                <form:form method="post" modelAttribute="data" class="bg-white rounded pb_form_v1">
                    <h2 class="mb-4 mt-0 text-center">Zarejestruj się</h2>
                    <div class="form-group">
                        <form:input path="email" type="email" class="form-control pb_height-50 reverse" placeholder="Email"/>
                    </div>
                    <div class="form-group">
                        <form:password path="password" class="form-control pb_height-50 reverse" placeholder="Hasło"/>
                    </div>
                    <div class="form-group">
                        <form:password path="rePassword" class="form-control pb_height-50 reverse" placeholder="Powtórz Hasło"/>
                    </div>
                    <div class="form-group">
                        <form:password path="firstName" class="form-control pb_height-50 reverse" placeholder="Imię"/>
                    </div>
                    <div class="form-group">
                        <form:password path="lastName" class="form-control pb_height-50 reverse" placeholder="Nazwisko"/>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary btn-lg btn-block pb_btn-pill  btn-shadow-blue" value="Zarejestruj się">
                        <input type="reset" class="btn btn-secondary btn-lg btn-block pb_btn-pill btn-shadow-blue" value="Wyczyść"/>

                    </div>
                </form:form>

            </div>
        </div>
    </div>
</section>
<!-- END section -->

<%--FOOTER--%>
<%@ include file="/WEB-INF/views/fragments/footer.jspf" %>

<!-- loader -->
<div id="pb_loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#1d82ff"/></svg></div>

<%--SCRIPTS--%>
<%@ include file="/WEB-INF/views/fragments/scripts.jspf" %>

</body>
</html>
