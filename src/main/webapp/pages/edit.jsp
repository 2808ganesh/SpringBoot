<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> EDIT FORM</title>
</head>
<body>
	<h1>REGISTRATION FORM</h1>
	<form action="update">
	
	<pre>
	
	EmployeeId:<input type="hidden" name="eid" value="${emp.eid}">
	name:<input type="text" name="name" value="${emp.name}">
	username:<input type="text" name="username"value="${emp.username}">
	password:<input type="text" name="password" value="${emp.password}">
	<input type="submit" value="UPDATE">
	

	</pre>

	</form>
</body>
</html>