<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Detail</title>
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
	<div class="content">
		<h2>${product.name}</h2>
		<%-- <div class="pic">
			<img alt="${product.image}" src="images/${product.image}">
		</div> --%>
		<div class="product-detail">
			<ul>
				<li><p>${product.description}</p></li>
				<li><p>${product.price}</p></li>
			</ul>
		</div>
		
		<div class="order-button">
			<form action="order/${product.id}" method="get">
				<input type="submit" value="Add Cart"/>
			</form>
		</div>
	</div>
</body>
</html>