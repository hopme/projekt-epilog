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

<table>
    <tr>
        <th>Id</th>
        <th>Nazwa</th>
        <th>Kategoria</th>
        <th>Data utworzenia</th>
    </tr>
    <c:forEach items="${factors}" var="factor">
        <tr>
            <td>${factor.id}</td>
            <td>${factor.name}</td>
            <td>${factor.category}</td>
            <td>${factor.created}</td>
        </tr>
    </c:forEach>

</table>
<br/>
<a href="http://localhost:8080/factors/add-factor">Link do dodania czynnika</a>


</body>
</html>
