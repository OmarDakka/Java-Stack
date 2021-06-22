<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>${ song.title }</title>
<style>
	.buttons {
		margin-left: 20px;
		margin-top: 20px;
		margin-right: 20px;
	}
</style>
</head>
<body>
	<div class="d-flex flex-row-reverse">
		<a href="/dashboard" class="btn btn-md btn-primary buttons">Dashboard</a>
	</div>
	<center>
		<h2>Song Title: ${ song.title }</h2><br><br>
		<h2>Song Artist: ${ song.artist}</h2><br><br>
		<h2>Song Rating(1-10): ${ song.rating}</h2><br><br>
		<form action="/songs/${song.id}" method="post">
			<input type="hidden" name="_method" value="delete">
		   	<input type="submit" class="btn btn-md btn-primary" value="Delete">
		</form>
	</center>
</body>
</html>