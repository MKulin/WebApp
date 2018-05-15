<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>WebApp</title>
</head>
<body>
<h1>Welcome to WebApp, <c:out value="${human.username}"/> </h1>
<h2><c:out value="${human.firstName}"/> </h2></br>
<h2><c:out value="${human.lastName}"/> </h2></br>
<h2><c:out value="${human.email}"/> </h2></br>
</body>
</html>
