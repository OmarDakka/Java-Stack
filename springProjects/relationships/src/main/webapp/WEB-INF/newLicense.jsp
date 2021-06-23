<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Create New License</title>
</head>
<body>
<center>
	<h1>New License</h1><br>
	
		<form:form action="/licenses/new/" method="post" modelAttribute="license">
			<div class="mb-2">
		        <h4><form:label path="person" class="form-label">Select Person: </form:label></h4>
		        <form:errors path="person"/>
		        <form:select  name="personName" path="person" class="form-control w-50"> 
		        	<c:forEach items="${ noLicense }" var="person">
		        		<form:option  value="${ person.id }">${ person.firstName } ${ person.lastName }</form:option>
		        	</c:forEach>
		        </form:select>
		    </div>
		    <div class="mb-2">
		        <h4><form:label path="state" class="form-label">State: </form:label></h4>
		        <form:errors path="state"/>
		        <form:input path="state" class="form-control w-50"/>
		    </div>
		    <div class="mb-2">
		        <h4><form:label path="expirationDate" class="form-label">Expiration Date: </form:label></h4>
		        <form:errors path="expirationDate"/>
		        <form:input type="date" path="expirationDate" class="form-control w-50"/>
		    </div><br><br>
		    <input type="submit" value="Submit" class="btn btn-md btn-primary"/>
		</form:form>
</center>
</body>
</html>