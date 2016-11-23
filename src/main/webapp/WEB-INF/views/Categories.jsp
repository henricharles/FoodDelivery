<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="Admin/header.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Categories</title>
</head>
<body>
	<div class="categories">
		<h1>Categories</h1>
			<table>
			<c:forEach var="category" items="${categories}">
			<tr>
				<td>${category.name}</td>
				<td><img src="/foodDelivery/images/${category.id}"/></td>
				<td><a href="categories/${category.id}">Detail</a></td>
			</tr>
			
			</c:forEach>
			</table>
			
		<a href="addCategory"> Add a Category</a>
	</div>
</body>
</html>