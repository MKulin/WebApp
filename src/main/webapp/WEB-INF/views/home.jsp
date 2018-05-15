<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>WebApp</title>
</head>
<body>
<h1>Welcome to WebApp</h1>
<a href="<c:url value="/" />">Login</a> |
<a href="<c:url value="/registration" />">Register</a>
</body>
</html>

