<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 28.09.19
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%--HEADER--%>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<body data-spy="scroll" data-target="#pb-navbar" data-offset="200">

<%--NAV--%>
<%@ include file="/WEB-INF/views/fragments/top-nav.jspf" %>

<section class="pb_section bg-light pb_pb-250" id="section-features">
    <div class="container">
        <div class="row justify-content-center mb-5">
        </div>
        <div class="row justify-content-center">

            <form:form method="post" modelAttribute="dayLogData" class="bg-white rounded pb_form_v1">
                <h2 class="mb-4 mt-0 text-center">Dodaj log dnia</h2>
                <div class="form-group">
                    <label>Wybierz z listy wszystkie produkty spożywcze spożywane tego dnia:</label>
                    <form:select class="form-control pb_Height-50 reverse" path="factors"  items="${foodFactors}" multiple="true" itemLabel="name" itemValue="id"/>
                </div>
                <div class="form-group">
                    <label>Wybierz z listy produkty alkoholowe spożywane tego dnia:</label>
                    <form:select class="form-control pb_Height-50 reverse" path="factors"  items="${alcoFactors}" multiple="true" itemLabel="name" itemValue="id"/>
                </div>
                <div class="form-group">
                    <label>Wybierz z listy produkty tytoniowe spożywane tego dnia:</label>
                    <form:select class="form-control pb_Height-50 reverse" path="factors"  items="${tabacoFactors}" multiple="true" itemLabel="name" itemValue="id"/>
                </div>
                <div class="form-group">
                    <label>Wybierz z listy stresujące wydarzenia które wydarzyły się tego dnia:</label>
                    <form:select class="form-control pb_Height-50 reverse" path="factors"  items="${stresFactors}" multiple="true" itemLabel="name" itemValue="id"/>
                </div>
                <div class="form-group">
                    <label>Czy tego dnia doszło do ataku?:</label>
                    <form:checkbox path="attack"/>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary btn-lg btn-block pb_btn-pill  btn-shadow-blue" value="Dodaj">
                </div>
            </form:form>

        </div>
    </div>
</section>


<%--FOOTER--%>
<%@ include file="/WEB-INF/views/fragments/footer.jspf" %>

<!-- loader -->
<div id="pb_loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#1d82ff"/></svg></div>

<%--SCRIPTS--%>
<%@ include file="/WEB-INF/views/fragments/scripts.jspf" %>

</body>
</html>