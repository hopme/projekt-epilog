<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 28.09.19
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Dodaj nowy czynnik</h1>

<form:form method="post" modelAttribute="factor">

    <label>Nazwa</label>
    <form:input path="title"/>
    <label>Kategoria</label>
    <form:select path="authors" items="${authors}"
                 itemValue="id" itemLabel="lastName"/>

    <p>
        Nazwa czynnika:
        <form:input path="email" type="email"/>
        <form:errors path="email"/>
    </p>
    <p>
        Kategoria czynnika:
        <form:input path="email" type="email"/>
        <form:errors path="email"/>
    </p>

    <p>
        <input type="submit" value="Dodaj"/>
    </p>
</form:form>

</body>
</html>
