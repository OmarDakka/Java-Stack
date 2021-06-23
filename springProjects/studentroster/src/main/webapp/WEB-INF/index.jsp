<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>All Students</title>
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
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ show }" var="student">
			<tr>
				<td><c:out value="${ student.firstName}"/> <c:out value="${ student.lastName}"/></td>
				<td><c:out value="${ student.age}"/></td>
				<td><c:out value="${ student.contact.address}"/></td>
				<td><c:out value="${ student.contact.city}"/></td>
				<td><c:out value="${ student.contact.state}"/></td>	
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>