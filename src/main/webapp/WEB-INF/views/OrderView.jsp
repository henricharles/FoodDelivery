<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="include/header.jsp" %>
<h3>Your Order :</h3>
	<table>
		<c:forEach var="element" items="${order.product}">
		<tr>
			<td>${element.photo}</td>	
			<td>${element.name}</td>	
			<td>${element.description}</td>
			<td>${element.price }</td>
		</c:forEach>
	</table>
	
	<table>
	<tr>
		<td>${order.amount}</td>
		<td>${order.orderDate}</td>
		<td>${order.status}</td>
	</tr>
	</table>
</body>
</html>