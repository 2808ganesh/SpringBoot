<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		
		<tr>
			
			<th>EID</th>
			<th>NAME</th>
			<th>USERNAME</th>
			<th>PASSWORD</th>
			<th>ACTION</th>
		
		</tr>
		
		<c:forEach items="${list }" var="e">
		
			<tr>
			
				<td>${e.eid}</td>
				<td>${e.name}</td>
				<td>${e.username}</td>
				<td>${e.password}</td>
				<td><a href="detete?eid=${e.eid}">DELETE</a>||<a href="edit?eid=${e.eid}">EDIT</a></td>
			</tr>
		</c:forEach>


	</table>

</body>
</html>