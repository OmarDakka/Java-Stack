<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>${ person.firstName } ${ person.lastName }</title>
</head>
<body>

	<center>
		<h1>${ person.firstName } ${ person.lastName }</h1><br><br>
		<h3>License Number: ${ person.license.getNumberAsString() }</h3><br><br>
		<h3>Expiration Date: ${ person.license.getExpirationDateFormatted() }</h3><br><br>
	</center>
</body>
</html>