<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link  type="text/css" href="main.css" rel="stylesheet">
	<style type="text/css">
		.content img{
			max-height:200px;
		}
		
		li{
			display: inline-block;
			padding-left:20px;
		}
		.content>li{
			display:inline-block;
		}
		li>ul>li{
			display:block;
		}
		
		.categories ul{
			padding-top:30px;
		}		
	</style>
</head>
<body>	
	<%@include file="include/header.jsp" %>
	
	<div class="content">
		<ul class="categories">
			<c:forEach var="product" items="${products}">
				<li>
					<ul>
						<%-- <li><a href="productList/${product.id}"><img src="images/${product.image}"/></a></li> --%>
						<li>
							<a href="productDetail/${product.id}">${product.name}</a>
						</li>
						<li>${product.price}</li>
					</ul>
				</li>
			</c:forEach>
		</ul>
	</div>
	
</body>
</html>