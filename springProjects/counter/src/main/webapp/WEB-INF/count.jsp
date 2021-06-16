<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>
<h2>You have visited <a href="/">http://localhost:8080 </a><c:out value="${count}"/> times.</h2>
<h2><a href="/">Test another visit?</a></h2>
<h2><a href="/three">WANNA ADD THE COUNTER BY 2? ENTER HERE :3</a></h2>
<h3><a href="/clear">RESET DA COUNTER BABY!!</a></h3>
</body>
</html>