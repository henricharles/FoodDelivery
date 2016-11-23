
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Order</title>
</head>
<body>
	<h3>Your Order :</h3>
	<table border="1px">
		<tr>
			<th>Image</th>
			<th>Product</th>
			<th>Desc</th>
			<th>Price</th>
			<th>Order Date</th>
			<th>Status</th>
		</tr>
		
		<c:forEach var="order" items="${order}" varStatus="rowStatus">
		<tr>
			<c:forEach var="prod" items="${order.product}" varStatus="rowCount">
				<td><img src="/foodDelivery/image/${prod.id}" width="150px"/></td>
				<td>${prod.name}</td>
				<td>${prod.description}</td>
				<td>${prod.price }</td>
				<td>${order.orderDate}</td>
				<td>${order.status}</td>
			</c:forEach>
		</tr>
		</c:forEach>
		
	</table>
	<br>
	<br>
	Total Amount ${TotalOrderAmt}

</body>
</html>