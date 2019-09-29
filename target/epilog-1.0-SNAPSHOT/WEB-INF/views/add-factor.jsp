<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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


    <label>Kategoria</label>
    <form:select path="category.id" items="${categories}"
                 itemValue="id" itemLabel="name"/>

    <%--jesli category name = jedzenie--%>
    <label>Wpisz składnik diety (np. ziemniaki/kiełbasa/czekolada):</label>
    <form:input path="name"/>
    <%--jesli alkohol--%>
    <label>Dodaj produkt alkoholowy (np. piwo/wódka):</label>
    <form:input path="name"/>
    <%--jesli tyton--%>
    <label>Dodaj produkt tytoniowy (np. cygaro/papierosy):</label>
    <form:input path="name"/>
    <%--jesli stresujacy czynnik--%>
    <label>Dodaj stresujacy czynnik (np. egzamin/spóźnienie)</label>
    <form:input path="name"/>

   <p>
        <input type="submit" value="Dodaj"/>
    </p>
</form:form>

</body>
</html>
