<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>All Categories</title>
</head>
<body>
	<div class="container">
		<nav>
			<h2><a href="/products/new">Add Product</a> | <a href="/categories/new">Add Category</a> | <a href="/products">View Products</a></h2>
		</nav>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ cat }" var="category">
				<tr>
					<td><a href="/categories/${category.id}">${ category.name}</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>	
	</div>
</body>
</html>