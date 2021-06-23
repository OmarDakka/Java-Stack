<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Create New Person</title>
</head>
<body>
<center>
	<h1>New Person</h1><br>
	
		<form:form action="/persons/new" method="post" modelAttribute="person">
		    <div class="mb-2">
		        <h4><form:label path="firstName" class="form-label">First Name: </form:label></h4>
		        <form:errors path="firstName"/>
		        <form:input path="firstName" class="form-control w-50"/>
		    </div>
		    <div class="mb-2">
		        <h4><form:label path="lastName" class="form-label">Last Name: </form:label></h4>
		        <form:errors path="lastName"/>
		        <form:input path="lastName" class="form-control w-50"/>
		    </div><br><br>
		    <input type="submit" value="Submit" class="btn btn-md btn-primary"/>
		</form:form>
</center>
</body>
</html>