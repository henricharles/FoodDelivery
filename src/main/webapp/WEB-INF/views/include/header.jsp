<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link  type="text/css" href="../css/bootstrap.css" rel="stylesheet">
<link  type="text/css" href="../css/main.css" rel="stylesheet">
	<script type="text/javascript" src="../js/bootstrap.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<style type="text/css">
		nav{
			float:left;
		}
		body>nav{
			width:100%;
		}
	</style>
</head>
<body>
	<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">FoodDelivery</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="productView">Product</a></li>
        <li><a href="index">Category</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li><a href="/foodDelivery/cart">Cart</a></li>
        <li><a href="/foodDelivery/OrderView/${user.username}">Order View</a></li>
        <li><a href="login">Log In</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</body>
</html>