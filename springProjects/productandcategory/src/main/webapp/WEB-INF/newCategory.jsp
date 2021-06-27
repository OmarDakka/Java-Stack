<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Create New Category</title>
</head>
<body>
<center>
	<h1>New Category</h1><br>
	
		<form:form action="/categories/new" method="post" modelAttribute="category">
		    <div class="mb-2">
		        <h4><form:label path="name" class="form-label">Category Name: </form:label></h4>
		        <form:errors path="name"/>
		        <form:input path="name" class="form-control w-50"/>
		    </div><br><br>
		    <input type="submit" value="Submit" class="btn btn-md btn-primary"/>
		</form:form>
</center>
</body>
</html>