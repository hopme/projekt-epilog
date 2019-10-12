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


<section class="pb_section bg-light pb_pb-250" id="section-features">
    <div class="container">
        <div class="row justify-content-center mb-5">
            <div class="col-md-6 text-center mb-5">
                <h2 class="text-success">Lista czynników</h2>
                <h5 class="text-uppercase pb_font-15 mb-2 pb_color-dark-opacity-3 pb_letter-spacing-2"><strong>Mogących mieć wpływ na ataki epilepsji</strong></h5>
            </div>
        </div>
        <div class="row justify-content-center">

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Data</th>
                    <th scope="col">Kategoria</th>
                    <th scope="col">Nazwa</th>
                    <th scope="col">Opcje</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${factors}" var="factor">
                    <tr>
                        <td>${factor.created.dayOfMonth} / ${factor.created.monthValue} / ${factor.created.year}  </td>
                        <td>${factor.category.name}</td>
                        <td>${factor.name}</td>
                        <td><a href="/factors/edit-factor/${factor.id}">Edytuj</a><br/>
                            <a href="/factors/delete-factor/${factor.id}">Usuń</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
        <a class="btn btn-primary btn-lg btn-block pb_btn-pill btn-shadow-blue" href="<c:url value="/factors/add-factor"/>">Dodaj nowy czynnik</a>
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