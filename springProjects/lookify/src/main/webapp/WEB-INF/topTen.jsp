<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>Top Ten Songs</title>
<style type="text/css">
.top {
	margin-top: 20px;
	margin-bottom: 10px;
	margin-right:20px;
}	

.styling {
	list-style-type: none;
	margin-left: 50px;
	margin-top:20px;
	width: 500px;
	border: 2px solid black;
	padding-bottom: 60px;
}
</style>
</head>
<body>
	<nav>
	<div class="d-flex justify-content-between top">
		<h2>Top Ten Songs:</h2>
		<form action="/search" method="GET">
			<input type="text" name="search">
			<input type="submit" value="Search Artists">
		</form>
		<a href="/dashboard" class="btn btn-md btn-primary buttons">Dashboard</a>
	</div>
	</nav>
		<ul class="styling">
	<c:forEach items="${ highest }" var="song">
		<li><h4><c:out value="${ song.rating }"/>/10-<a href="/songs/${song.id}"><c:out value="${ song.title }"/></a>-<c:out value="${ song.artist }"/></h4></li>
	</c:forEach>
		</ul>
</body>
</html>