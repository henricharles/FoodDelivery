<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link  type="text/css" href="css/bootstrap.css" rel="stylesheet">
	<link  type="text/css" href="css/main.css" rel="stylesheet">
	<script type="text/javascript" src="../js/bootstrap.js"></script>
</head>
<body>
	<%@include file="include/header.jsp" %>
	<section>
		<div class=""><h2>Order Information</h2></div>
			<div class="content">
				<header>
				    <hgroup>
				      <h1>${user.username}! you have selected</h1>
				    </hgroup>
				</header>
				<c:forEach var="product" items="${products}">
				<%-- <div class="pic">
					<img alt="${product.image}" src="images/${product.image}">
				</div> --%>
				 <figure>
				  	<img src="images/images1.jpg">
				   	<%-- <img alt="${product.image}" src="images/${product.image}"> --%>
				   </figure>
				   
				   <div class="product-detail">
				   		<ul>
				   			<li><p>${product.description}</p></li>
				   			<li><p>${product.price}</p></li>
				   		</ul>
				   </div>
				</c:forEach>
			</div>
			<div class="total-price">
				<p>${totalamount}</p>
			</div>
			<div class="order-button">
				<form action="orderSave" method="post">
					<input type="hidden" value="${totalamount}" name="totalAmount" />
					<input type="submit" value="CheckOut"/>
				</form>
			</div>
		</section>
</body>
</html>