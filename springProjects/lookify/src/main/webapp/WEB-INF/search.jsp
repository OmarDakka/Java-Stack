<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>search</title>
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

.top {
	margin-top: 20px;
	margin-bottom: 10px;
	margin-right:20px;
}
</style>
</head>
<body>
	<div class="d-flex flex-row-reverse top">
		<a href="/dashboard" class="btn btn-md btn-primary buttons">Dashboard</a>
	</div>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ search }" var="result">
			<tr>
				<td><a href="/songs/${result.id}"><c:out value="${ result.title }"/></a></td>
				<td><c:out value="${ result.rating }"/></td>
				<td>
					<div class="d-flex justify-content-evenly">
						<form action="/songs/${result.id}" method="post">
		    				<input type="hidden" name="_method" value="delete">
		    				<input type="submit" class="btn btn-md btn-primary" value="Delete">
		    			</form>
	    			</div>
	    		</td>
					
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>