<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>

	<table border="1px" cellspacing="10px">
		<tr>
			<th>Product Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Photo</th>
			<th></th>
			<th></th>
		</tr>

		<c:forEach var="element" items="${product}">
			<tr>
				<td>${element.id}</td>
				<td>${element.name}</td>
				<td>${element.description}</td>
				<td>${element.price }</td>
				<td>
				<a href="/image/${element.id}"> 
					<img src="/foodDelivery/image/${element.id}" alt="Image placeholder" width="100px">
				</a>
				</td>

				<td>
					<form action="Delete" method="post">
						<input style="border-radius: 2px" type="hidden"
							name="productNumber" value="${element.id}"> <input
							type="submit" value="Delete">
					</form>
				</td>

				<td>
					<form action="Update" method="post">
						<input style="border-radius: 2px" type="hidden"
							name="productNumber" value="${element.id}"> <input
							type="submit" value="Update">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<form action="products" method="post">
		<input type="submit" value="Add Products">
	</form>
</body>
</html>