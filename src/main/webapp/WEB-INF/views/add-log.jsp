<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Dodaj nowy log dnia</h1>

<form:form method="post" modelAttribute="dayLogData">
    <form:errors path="*"/>

    <label>Wybierz z listy wszystkie produkty spożywcze spożywane tego dnia:</label>
    <form:label path="factors">Czynniki: </form:label>
    <form:select path="factors" items="${foodFactors}" multiple="true" itemLabel="name" itemValue="id"/>
    <label>Czy spożywałeś alkohol?</label>
    <form:select path="factors" items="${alcoFactors}" multiple="true" itemLabel="name" itemValue="id"/>
    <label>Czy spożywałeś wyroby tytoniowe?</label>
    <form:select path="factors" items="${tabacoFactors}" multiple="true" itemLabel="name" itemValue="id"/>
    <label>Stresujące zdarzenia?</label>
    <form:select path="factors" items="${stresFactors}" multiple="true" itemLabel="name" itemValue="id"/>
    <label>Czy tego dnia doszło do ataku?</label>
    <form:checkbox path="attack"/>

   <p>
        <input type="submit" value="Wyślij"/>
    </p>
</form:form>

</body>
</html>
