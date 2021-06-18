<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
</head>
<body>
<form action="/result" method="post">
	<label for="name" >Your Name: </label>
	<input type="text" name="name" required><br><br>
	<label for ="location">Dojo Location: </label>
	<select name="location" required>
	<c:forEach items="${ locations }" var="loc">
		<option value="<c:out value='${loc }'/>"><c:out value='${ loc }'/></option>
	</c:forEach>
	</select><br><br>
	<label for="language">Favorite Language: </label>
	<select name="language" required>
	<c:forEach items="${ languages }" var="lang">
		<option value="<c:out value='${ lang }'/>"><c:out value='${ lang }'/></option>
	</c:forEach>
	</select><br><br>
	<label for="comment">Comment(optional)</label>
	<textarea name="comment" rows="2" cols="30"></textarea><br><br>
	<input type="submit" value="Submit">
</form>
</body>
</html>