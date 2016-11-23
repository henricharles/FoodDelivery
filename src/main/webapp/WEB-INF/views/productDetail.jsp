<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Detail</title>	
<link  type="text/css" href="../../css/bootstrap.css" rel="stylesheet">
	<link  type="text/css" href="../../css/main.css" rel="stylesheet">
	<script type="text/javascript" src="../../js/bootstrap.js"></script>	
</head>
<body>
	<%@include file="include/header.jsp" %>
	
	<section class="product-detail">
	<div class="product">
		<header>
		    <hgroup>
		      <h1>${product.name}</h1>
		    </hgroup>
		  </header>
		  <figure>
		  	<img src="/foodDelivery/images/${product.id}">
		   	<%-- <img alt="${product.image}" src="images/${product.image}"> --%>
		   </figure>
		   
		   
		    <section>
 
			  <p>${product.description}</p>
			 
			  <details>
			   <summary>${product.price}</summary>
			  </details>
			<div class="order-button">
				<form action="order/${product.id}" method="post">
					<input type="submit" value="Add Cart"/>
				</form>
			</div>
		</div>
	 
  	</section>
 
</div>
	
</body>
</html>