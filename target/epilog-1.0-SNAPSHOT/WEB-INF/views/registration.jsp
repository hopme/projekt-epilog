<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja użytkownika</title>
</head>
<body>
<form:form method="post" modelAttribute="data">
    <p>
        Email: <form:input path="email" type="email"/>
        <form:errors path="email"/>
    </p>
    <p>
        Hasło: <form:password path="password"/>
        <form:errors path="password"/>
    </p>
    <p>
        Powótrz hasło: <form:password path="rePassword"/>
        <form:errors path="rePassword"/>
    </p>
    <p>
        Imię: <form:input path="firstName"/>
        <form:errors path="firstName"/>
    </p>
    <p>
        Nazwisko: <form:input path="lastName"/>
        <form:errors path="lastName"/>
    </p>
    <p>
        <input type="submit" value="Zarejestruj"/>
        <input type="reset" value="Wyczyść"/>
    </p>
</form:form>
</body>
</html>