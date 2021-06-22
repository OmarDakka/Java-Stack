<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<meta charset="ISO-8859-1">
<title>Add a New Song</title>
<style>
	.space {
		margin-top:15px;
		margin-right:20px;
		margin-bottom:20px;
	}
</style>
</head>
<body>
	<div class="d-flex flex-row-reverse space">
		<h3><a href="/dashboard">Dashboard</a></h3>
	</div>	
	<center>
		<h1>New Song</h1><br>
	
		<form:form action="/songs/new" method="post" modelAttribute="song">
		    <div class="mb-2">
		        <h4><form:label path="title" class="form-label">Song Title</form:label></h4>
		        <form:errors path="title"/>
		        <form:input path="title" class="form-control w-50"/>
		    </div>
		    <div class="mb-2">
		        <h4><form:label path="artist" class="form-label">Song Artist</form:label></h4>
		        <form:errors path="artist"/>
		        <form:input path="artist" class="form-control w-50"/>
		    </div>
		    <div class="mb-2">
		        <h4><form:label path="rating" class="form-label">Song Rating</form:label></h4>
		        <form:errors path="rating"/>
		        <form:input type="number" path="rating" class="form-control w-50"/>
		    </div><br><br>
		    <input type="submit" value="Submit" class="btn btn-md btn-primary"/>
		</form:form>
	</center>   
</body>
</html>