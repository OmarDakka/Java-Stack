<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>${ product.name }</title>
</head>
<body>

	<center>
		<h1>${ product.name }</h1><br><br>
		<h2>Categories</h2>
		<h3>
		<ul>
		<c:forEach items="${ product.categories }" var="cat">
			<li><c:out value="${ cat.name }"></c:out></li>
		</c:forEach>
		</ul>
		</h3>
		<form action="/products/${ product.id }" method="post">
			<select name= "category_id" class="form-control w-50"> 
		   		<c:forEach items="${ category }" var="cat">
		        		<option  value="${ cat.id }">${ cat.name}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Add Category!">
		</form>
	</center>
</body>
</html>