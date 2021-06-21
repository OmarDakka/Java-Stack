<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>Login and Registration</title>
</head>
<body>
	
	<form action="/login" method="POST">
		email <input type="email" name="email">
		password <input type="password" name="password" > 
		<input type="submit" name="submit" value="LOGIN BABY!" >
	</form>
	
</body>
</html>