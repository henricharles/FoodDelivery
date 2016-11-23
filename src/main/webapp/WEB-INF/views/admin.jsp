<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Admin/header.jsp" %>
	<div class="content">
		<ul>
			<li>
				<div class="image">
					<a href="addProduct">
						<img alt="" src="image/product.png" />
					</a>
					<a href="/foodDelivery/addProduct">Product</a>
				</div>
			</li>
			<li>
				<div class="image">
					<a href="categories">
						<img alt="" src="image/category.png" />
					</a>
					<a href="/foodDelivery/categories">Category</a>
				</div>
			</li>
			<li>
				<div class="image">
					<a href="deleveryBoy">
						<img alt="" src="image/deleveryboy.jpg">
					</a>
					<a href="deleveryBoy">DeleveryBoy</a>
				</div>
			</li>
			<li>
				<div class="image">
					<a href="schedule">
						<img alt="" src="image/schedule.jpg">
					</a>
					<a href="schedule">Schedule</a>
				</div>
			</li>
		</ul>
	</div>
</body>
</html>