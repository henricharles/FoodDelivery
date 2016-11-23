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
	
	<div class="content">
		<ul class="products">
			<c:forEach var="category" items="${categories}">
				<li class="item">
					<ul class="product-col">
						<li><a href="productList/${category.id}"><img class="img-responsive" src="/foodDelivery/images/${category.id}"/></a></li>
						<li><a href="productList/${category.id}">${category.name}</a></li>
						
					</ul>
				</li>
			</c:forEach>
		</ul>
	</div>
	
</body>
</html>