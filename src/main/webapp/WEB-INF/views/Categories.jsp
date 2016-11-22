<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Categories</title>
	<style type="text/css">
		img{
			max-width:100px;
		}
		
	</style>
	
</head>
<body>
	<h1>Categories</h1>
	<table>
	<c:forEach var="category" items="${categories}">
	<tr>
		<td>${category.name}</td>
		<td><img src="images/${category.image}"/></td>
		<td><a href="categories/${category.id}">Detail</a></td>
	</tr>
	
	</c:forEach>
	</table>
	
	<a href="addCategory"> Add a Category</a>
</body>
</html>