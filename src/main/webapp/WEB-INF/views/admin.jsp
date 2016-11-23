<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
		<ul>
			<li>
				<div class="image">
					<a href="product">
						<img alt="" src="image/product.png" />
					</a>
					<a href="product">Product</a>
				</div>
			</li>
			<li>
				<div class="image">
					<a href="categories">
						<img alt="" src="image/category.png" />
					</a>
					<a href="categories">Category</a>
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