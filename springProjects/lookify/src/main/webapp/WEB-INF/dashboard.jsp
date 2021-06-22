<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Lookify!</title>
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
}
</style>
</head>
<body>
	<nav class="d-flex justify-content-evenly top">
		<a href="/songs/new">Add New</a>
		<a href="/search/topTen">Top Songs</a>
		<form action="/search" method="GET">
			<input type="text" name="search">
			<input type="submit" value="Search Artists">
		</form>
	</nav>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ songs }" var="song">
			<tr>
				<td><a href="/songs/${song.id}"><c:out value="${ song.title }"/></a></td>
				<td><c:out value="${ song.rating }"/></td>
				<td>
					<div class="d-flex justify-content-evenly">
						<form action="/songs/${song.id}" method="post">
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