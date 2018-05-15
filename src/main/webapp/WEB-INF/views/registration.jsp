<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>WebApp</title>
    <style>
        <%@include file="/WEB-INF/views/css/registration.css"%>
    </style>
</head>
<body>
<h1>Welcome to WebApp </h1>
    <sf:form method="post" modelAttribute="human" action="registration">
        <ul>
            <li>First username: <sf:input path="firstName"/> <sf:errors path="firstName" cssClass="error"/></li>
            <li>Last username: <sf:input path="lastName"/> <sf:errors path="lastName" cssClass="error"/></li>
            <li>Username: <sf:input path="username"/> <sf:errors path="username" cssClass="error"/></li>
            <li>E-mail: <sf:input path="email"/> <sf:errors path="email" cssClass="error"/></li>
            <li>Password: <sf:password path="password"/> <sf:errors path="password" cssClass="error"/> </li>
            <li><input type="submit" value="Register"></li>
        </ul>
    </sf:form>
</body>
</html>
