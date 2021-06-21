<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1>YAAAA WELCOME <c:out value="${ email }"></c:out></h1>

<h2><a href="/logout">LOGOUT OF HERE </a></h2>
</body>
</html>