<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 29.09.19
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%--HEADER--%>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<body data-spy="scroll" data-target="#pb-navbar" data-offset="200">

<%--NAV--%>
<%@ include file="/WEB-INF/views/fragments/top-nav.jspf" %>

<section class="pb_section bg-light pb_slant-white pb_pb-250" id="section-features">
    <div class="container">
        <div class="row justify-content-center mb-5">
            <div class="col-md-6 text-center mb-5">
                <h2>Kokpit</h2>
                <h5 class="text-uppercase pb_font-15 mb-2 pb_color-dark-opacity-3 pb_letter-spacing-2"><strong>Użytkownika</strong></h5>
            </div>
        </div>
        <div class="row justify-content-center">
            <p class="h4">Historia ataków</p>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Data</th>
                    <th scope="col">Atak</th>
                    <th scope="col">Czynniki</th>
                    <th scope="col">Opcje</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${daylogs}" var="daylog">
                    <tr class="${daylog.attack ? 'bg-danger text-light' : ''}">
                        <td>${daylog.created.dayOfMonth} / ${daylog.created.monthValue} / ${daylog.created.year}  </td>
                        <td>${daylog.attack}</td>
                        <td>lista czynników dla danego dayloga</td>
                            <%--<td>${daylog.factors}</td> JAK TO WYSWIETLIC??--%>
                        <td><a href="/daylogs/edit-log/${daylog.id}" class="${daylog.attack ? 'text-light' : ''}">Edytuj</a><br/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="<c:url value="/daylog/add-log"/>">Dodaj nowy DayLog</a>
        </div>
    </div>
</section>

<section class="pb_section pb_slant-light pb_pb-220" id="section-reviews">
    <div class="container">
        <div class="row justify-content-center mb-5">
            <div class="col-md-6 text-center mb-5">
                <h2>Korelacje</h2>
                <h5 class="text-uppercase pb_font-15 mb-2 pb_color-dark-opacity-3 pb_letter-spacing-2"><strong>Te wydarzenia najczęściej przydarzają się przy ataku</strong></h5>
            </div>
        </div>
        <div class="row justify-content-center">
            <p class="h4">Wydarzenia o najwyższej korelacji z atakami</p>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Czynnik</th>
                    <th scope="col">Kategoria</th>
                    <th scope="col">Korelacja</th>
                    <th scope="col">Tendencja</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${correlations}" var="correlation">
                    <tr>
                        <td>${correlation.factor.name}</td>
                        <td>${correlation.factor.category.name}</td>
                        <td>${correlation.correlationMeasure}</td>
                        <td>${correlation.tendency.toString()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
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