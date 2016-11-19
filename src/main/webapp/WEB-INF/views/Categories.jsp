<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
</head>
<body>
	<h1>Cars currently in the shop</h1>
	<table>
	<c:forEach var="category" items="${categories}">
	<tr>
		<td>${category.name}</td>
		<td>${category.image}</td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="addCategory.jsp"> Add a Category</a>
</body>
</html>