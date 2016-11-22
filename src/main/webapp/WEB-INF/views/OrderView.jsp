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
	<table>
	
		<c:forEach var="order" items="${order}" varStatus="rowStatus">
			<c:forEach var="prod" items="${order.product}" varStatus="rowCount">
				<tr><td>${prod.photo}</td></tr>
				<tr><td>${prod.name}</td></tr>
				<tr><td>${prod.description}</td></tr>
				<tr><td>${prod.price }</td></tr>
			</c:forEach>
		<tr>
			<td>${TotalOrderAmt}</td>
			<td>${order.orderDate}</td>
			<td>${order.status}</td>
		</tr>
		</c:forEach>
	</table>

	<%-- <table>
		<tr>
			<td>${order.amount}</td>
			<td>${order.orderDate}</td>
			<td>${order.status}</td>
		</tr>
	</table> --%>
</body>
</html>