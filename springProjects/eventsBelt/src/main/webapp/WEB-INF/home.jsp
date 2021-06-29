

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
		<link rel="stylesheet" href="/css/style.css" />
		<meta charset="ISO-8859-1">
	<title>Event Planner</title>
</head>
	<body>
		<div class="text-center grab">
			<main class="form-signin">
				<form:form class="user-form" action="/" method="post" modelAttribute="registration">
					<h1 class="h3 mb-3 fw-normal">Register</h1>
				 	<div class="form-group">
				        <form:errors path="firstName"/>
				        <form:input class="form-control" path="firstName" placeholder="First Name"/>
				    </div>
				    <div class="form-group">
				        <form:errors path="lastName"/>
				        <form:input class="form-control" path="lastName" placeholder="Last Name"/>
				    </div>
				    <div class="form-group">
				        <form:errors path="email"/>
				        <form:input type="email" class="form-control" path="email" placeholder ="Email"/>
				    </div>
				    <div class="form-group">
				        <form:errors path="city"/>
				        <form:input class="form-control" path="city" placeholder="City"/>
				    </div>
				    <div class="form-group">
				        <form:errors path="state"/>
						<form:select class="form-select padd" path="state">
						<option selected>State</option>
						<c:forEach items="${ states }" var="state">
							<option value="${ state }">${ state }</option>
						</c:forEach>
						</form:select>
				    </div>
				     <div class="form-group">
				        <form:errors path="password"/>
				        <form:password class="form-control" path="password" placeholder="Password"/>
				    </div>
				    <div class="form-group">
				        <form:errors path="passwordConfirmation"/>
				        <form:password class="form-control" path="passwordConfirmation" placeholder="Confirm Password"/>
				    </div>
				    <button class="w-100 btn btn-lg btn-primary">Register</button>
				</form:form>
			</main>
			<main class="form-signin">
				<form action="/login" class="user-form" method="post">
					<h2 class="h3 mb-3 fw-normal">Login</h2>
					<span>${ error }</span>
					<div class="form-group">
						<input type="email" name="email" placeholder="Email" id="email" class="form-control" />
					</div>
					<div class="form-group">
				        <input type="password" name="password" placeholder="Password" id="password" class="form-control" />		        
				    </div>
				    <button class="w-100 btn btn-lg btn-primary">Login</button>
				</form>
			</main>
		</div>
	</body>
</html>
