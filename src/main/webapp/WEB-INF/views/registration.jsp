<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>WebApp</title>
    <style>
        <%@include file="/WEB-INF/views/css/registration.css"%>
    </style>
</head>
<body>
<h1>Welcome to WebApp </h1>
    <sf:form method="post" modelAttribute="human" action="/registration">
        <sf:errors path="*" element="div" cssClass="error"/>
        First name: <sf:input path="firstName"/><br>
        Last username: <sf:input path="lastName"/><br>
        Username: <sf:input path="username"/><br>
        E-mail: <sf:input path="email"/><br>
        Password: <sf:password path="password"/><br>
        <input type="submit" value="Register">
    </sf:form>
</body>
</html>
