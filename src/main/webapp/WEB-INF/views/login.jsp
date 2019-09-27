<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz logowania</title>
</head>
<body>
<h1>Logowanie</h1>
<c:choose>
    <c:when test="${param.error != null}">
        <p>Błędne dane logowania!</p>
    </c:when>
    <c:when test="${param.logout != null}">
        <p>Poprawnie wylogowano</p>
    </c:when>
</c:choose>
<form:form method="post" modelAttribute="data">
    <p>
        Email: <form:input path="email" type="email"/>
    </p>
    <p>
        Hasło: <form:password path="password"/>
    </p>

    <p>
        <input type="submit" value="Zaloguj"/>
    </p>
</form:form>
</body>
</html>