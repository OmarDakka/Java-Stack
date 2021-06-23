<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Create New Student</title>
</head>
<body>
<center>
	<h1>New Contact</h1><br>
	
		<form:form action="/contacts/new" method="post" modelAttribute="contact">
			<div class="mb-2">
		        <h4><form:label path="student" class="form-label">Select Student: </form:label></h4>
		        <form:errors path="student"/>
		        <form:select path="student" class="form-control w-50"> 
		        	<c:forEach items="${ stu }" var="student">
		        		<form:option value="${ student.id }">${ student.firstName } ${ student.lastName }</form:option>
		        	</c:forEach>
		        </form:select>
		    </div>
		    <div class="mb-2">
		        <h4><form:label path="address" class="form-label">Address: </form:label></h4>
		        <form:errors path="address"/>
		        <form:input path="address" class="form-control w-50"/>
		    </div>
		    <div class="mb-2">
		        <h4><form:label path="city" class="form-label">City: </form:label></h4>
		        <form:errors path="city"/>
		        <form:input path="city" class="form-control w-50"/>
		    </div>
		    <div class="mb-2">
		        <h4><form:label path="state" class="form-label">State: </form:label></h4>
		        <form:errors path="state"/>
		        <form:input path="state" class="form-control w-50"/>
		    </div><br><br>
		    <input type="submit" value="Submit" class="btn btn-md btn-primary"/>
		</form:form>
</center>
</body>
</html>