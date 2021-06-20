<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>New Book</title>
</head>
<body>
	<h1>New Book</h1>
	<form action="/books" method="post" modelAttribute="book">
		<p>
			<label for="title">Title</label>
			<input type="text" name="title">
		<p>
			<label for="description">Description</label>
			<input type="text" name="description">
		</p>
		<p>
			<label for="language">Language</label>
			<input type="text" name="language">
		</p>
		<p>
			<label for="numberOfPages">Number of Pages</label>
			<input type="number" name="numberOfPages">
		</p>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>