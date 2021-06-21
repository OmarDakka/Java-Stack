<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>All Languages</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<center>
<h1>All Languages</h1>
</center>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ languages }" var="language">
			<tr>
				<td><a href="/languages/${language.id}"><c:out value="${ language.name }"/></a></td>
				<td><c:out value="${ language.creator }"/></td>
				<td><c:out value="${ language.currentVersion }"/></td>
				<td>
					<div class="d-flex justify-content-evenly">
						<form action="/languages/${language.id}" method="post">
		    				<input type="hidden" name="_method" value="delete">
		    				<input type="submit" class="btn btn-md btn-primary" value="Delete">
		    			</form>
		    			<a href="/languages/edit/${ language.id }" class="btn btn-md btn-primary" style="width:72px;">Edit</a>
	    			</div>
	    		</td>
					
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<center>
		<h1>New Language</h1>
	
		<form:form action="/languages" method="post" modelAttribute="language">
		    <div class="mb-2">
		        <h3><form:label path="name" class="form-label">Name</form:label></h3>
		        <form:errors path="name"/>
		        <form:input path="name" class="form-control w-50"/>
		    </div>
		    <div class="mb-2">
		        <h3><form:label path="creator" class="form-label">Creator</form:label></h3>
		        <form:errors path="creator"/>
		        <form:textarea path="creator" class="form-control w-50"/>
		    </div>
		    <div class="mb-2">
		        <h3><form:label path="currentVersion" class="form-label">Current Version</form:label></h3>
		        <form:errors path="currentVersion"/>
		        <form:input path="currentVersion" class="form-control w-50"/>
		    </div>  
		    <input type="submit" value="Submit" class="btn btn-md btn-primary"/>
		</form:form>    
	</center>
</body>
</html>