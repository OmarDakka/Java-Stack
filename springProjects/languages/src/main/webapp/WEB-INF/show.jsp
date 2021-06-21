<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>${ language.name }</title>
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
		<a href="/languages" class="btn btn-md btn-primary buttons">Dashboard</a>
	</div>
	<center>
		<h2>Language Name: ${ language.name }</h2><br><br>
		<h2>Language Creator: ${ language.creator }</h2><br><br>
		<h2>Language Version: ${ language.currentVersion }</h2><br><br>
		<a href="/languages/edit/${ language.id }" class="btn btn-md btn-primary" style="width:72px;">Edit</a><br><br>
		<form action="/languages/${language.id}" method="post">
			<input type="hidden" name="_method" value="delete">
		   	<input type="submit" class="btn btn-md btn-primary" value="Delete">
		</form>
	</center>
</body>
</html>