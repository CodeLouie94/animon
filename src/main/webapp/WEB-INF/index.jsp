<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 class="text-center " style="font-family: 'Bradley Hand', 'cursive'  ">ANIMON</h1>
	<div class="d-flex container justify-content-around"  >
		<div style="font-family: 'Bradley Hand', 'cursive'  ">
			<form:form action = "/register" method = "post" modelAttribute ="newUser">
				<h2 class="fs-1" style="font-family: 'Bradley Hand', 'cursive'  ">Register</h2>
				<div class="mb-3" >
					<form:label class="form-label fs-3" path = "username">User Name:</form:label>
					<form:input class="form-control" type="text" path ="username" />
					<form:errors path="username"/>
				</div>
				<div class="mb-3">
					<form:label class="form-label fs-3" path="email">Email:</form:label>
					<form:input class="form-control" type="text" path = "email"></form:input>	
					<form:errors path="email"/>	
				</div>
				<div class="mb-3">
					<form:label class="form-label fs-3" path="password">Password:</form:label>
					<form:input class="form-control" type="password" path = "password"></form:input>		
					<form:errors path="password"/>
				</div>
				<div class="mb-3">
					<form:label class="form-label fs-3" path="confirm">Confirm PW:</form:label>
					<form:input class="form-control" type="password" path = "confirm"></form:input>
					<form:errors path="confirm"/>		
				</div>
				<input type="submit" value="Register" class="btn btn-primary" />
			</form:form>
		</div>
		<div style="font-family: 'Bradley Hand', 'cursive'  ">
			<h2 class="fs-1" style="font-family: 'Bradley Hand', 'cursive'  ">Login</h2>
			<form:form action = "/login" method="post" modelAttribute="newLogin">
				<div class="mb-3">
					<form:label class="form-label fs-3" path="email">Email:</form:label>
					<form:input class="form-control" type="text" path = "email"></form:input>		
					<form:errors path="email"/>
				</div>
				<div class="mb-3">
					<form:label class="form-label fs-3" path="password">Password:</form:label>
					<form:input class="form-control" type="password" path = "password"></form:input>		
					<form:errors path="password"/>
				</div>
				<input type="submit" value="Login" class="btn btn-success" />
			</form:form>
		</div>
	</div>
</body>
</html>