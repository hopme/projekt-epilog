<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 28.09.19
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Dodaj nowy log</h1>

    <form:form method="post" modelAttribute="data">
        <p>
            Wybierz produkty które jadłeś na śniadanie:
            <form:input path="email" type="email"/>
            <form:errors path="email"/>
        </p>
        <p>
            Wybierz produkty, które jadłeś na obiad:
            Hasło: <form:password path="password"/>
            <form:errors path="password"/>
        </p>
        <p>
            Wybierz produkty, które jadłeś na kolacje:
            <form:password path="rePassword"/>
            <form:errors path="rePassword"/>
        </p>
        <p>
            Godzina obudzenia się:
            <form:input path="firstName"/>
            <form:errors path="firstName"/>
        </p>
        <p>
            Godzina położenia się spać:
            <form:input path="lastName"/>
            <form:errors path="lastName"/>
        </p>
        <p>
            Inne:
            <form:input path="lastName"/>
            <form:errors path="lastName"/>
        </p>
        <p>
            Atak:
            <form:input path="lastName"/>
            <form:errors path="lastName"/>
        </p>
        <p>
            <input type="submit" value="Zarejestruj"/>
            <input type="reset" value="Wyczyść"/>
        </p>
    </form:form>




</body>
</html>
