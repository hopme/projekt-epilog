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
<head>
    <title>Title</title>
</head>
<body>
<h1>Kokpit użytkownika</h1>
<h2>Kalendarz ataków</h2>
<table>
    <tr>
        <th>Data</th>
        <th>Atak</th>
        <th>Czynniki</th>
        <th>Opcje</th>
    </tr>
      <c:forEach items="${daylogs}" var="daylog">

        <tr>
            <td>${daylog.created}</td>
            <td>${daylog.attack}</td>
            <td>lista czynników dla danego dayloga</td>
            <%--<td>${daylog.factors}</td> JAK TO WYSWIETLIC??--%>
            <td>Edycja</td>
        </tr>
      </c:forEach>

</table>
<a href="http://localhost:8080/factors/add-factor">Link do dodania czynnika</a>

<h2>Korelacje</h2>
<p>Te wydarzenia najczęściej zdarzają się przy atakach</p>

<table>
    <tr>
        <th>Czynnik</th>
        <th>Kategoria</th>
        <th>Korelacja</th>
    </tr>
    <c:forEach items="${correlations}" var="correlation">

        <tr>
            <td>${correlation.factor.name}</td>
            <td>${correlation.factor.category.name}</td>
            <td>${correlation.correlationMeasure}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
