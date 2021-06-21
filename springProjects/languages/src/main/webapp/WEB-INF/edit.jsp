<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<meta charset="ISO-8859-1">
<title>Edit Language</title>
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
		<form action="/languages/${language.id}" method="post">
			<input type="hidden" name="_method" value="delete">
		   	<input type="submit" class="btn btn-md btn-primary buttons" value="Delete">
		</form>
		<a href="/languages" class="btn btn-md btn-primary buttons">Dashboard</a>
	</div>
<center>
	<h1>Edit ${ language.name } Language</h1>
	<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
	    <input type="hidden" name="_method" value="put">
	    <p>
	        <h3><form:label path="name" class="form-label">Name</form:label></h3>
	        <form:errors path="name"/>
	        <form:input path="name" value="${ language.name }" class="form-control w-50"/>
	    </p>
	    <p>
	        <h3><form:label path="creator" class="form-label">Creator</form:label></h3>
	        <form:errors path="creator"/>
	        <form:textarea path="creator" value="${ language.creator }" class="form-control w-50"/>
	    </p>
	    <p>
	        <h3><form:label path="currentVersion" class="form-label">Version</form:label></h3>
	        <form:errors path="currentVersion"/>
	        <form:input path="currentVersion" value="${ language.currentVersion }" class="form-control w-50"/>
	    </p> 
	    <input type="submit" value="Submit" class="btn btn-md btn-primary"/>
	</form:form>
</center>
</body>
</html>