<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
<h1>Submitted info</h1>
<p>Name: <c:out value="${ result.getName() }"/></p>
<p>Language: <c:out value="${ result.getLanguage() }"/></p>
<p>Location: <c:out value="${ result.getLocation() }"/></p>
<p>Comment: <c:out value="${ result.getComment() }"/></p>
</body>
</html>