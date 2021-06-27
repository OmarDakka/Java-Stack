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
<title>All Drivers</title>
</head>
<body>
	<div class="container">
		<nav>
			<h2><a href="/products/new">Add Product</a> | <a href="/categories/new">Add Category</a> | <a href="/categories">View Categories</a></h2>
		</nav>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ pro }" var="product">
				<tr>
					<td><a href="/products/${product.id}">${ product.name}</a></td>
					<td>${ product.description }</td>
					<td>${ product.price }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>	
	</div>
</body>
</html>