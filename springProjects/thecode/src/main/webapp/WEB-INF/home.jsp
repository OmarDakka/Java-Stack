<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>Secret Code</title>
<style>
.errorColor{
	color : red;
}
</style>
</head>
<body>
<center>
	<h3 class="errorColor"><c:out value="${error}"/></h3>
	<h1>What is the code?</h1>
	<form action="/code" method="post">
	<input type="text" name="code"><br><br>
	<button type="submit"><h1>Try Code</h1></button>
	</form>
</center>
</body>
</html>