<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>WebApp</title>
</head>
<body>
<h1>Welcome to WebApp </h1>
    <c:forEach items="rep" var="human">
        <li>
            <c:out value="${human.name}"/>
        </li>
    </c:forEach>
</body>
</html>
