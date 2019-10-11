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
    <title>Wszystkie czynniki</title>
</head>
<body>

<table>
    <tr>
        <th>Data utworzenia</th>
        <th>Kategoria</th>
        <th>Nazwa</th>
    </tr>
    <c:forEach items="${factors}" var="factor">
        <tr>
            <td>${factor.created.dayOfMonth} / ${factor.created.monthValue} / ${factor.created.year}  </td>
            <td>${factor.category.name}</td>
            <td>${factor.name}</td>
        </tr>
    </c:forEach>

</table>
<br/>
<a href="http://localhost:8080/factors/add-factor">Link do dodania czynnika</a>


</body>
</html>
