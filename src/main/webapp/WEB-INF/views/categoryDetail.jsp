<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Car</title>
<%@include file="Admin/header.jsp" %>
<link  type="text/css" href="../css/bootstrap.css" rel="stylesheet">
<link  type="text/css" href="../css/main.css" rel="stylesheet">
	<script type="text/javascript" src="../js/bootstrap.js"></script>
</head>
<body>
	<form action="../categories/${category.id}" method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${category.name}" /> </td>
		</tr>
		<tr>
			<td>Image:</td>
			<td><img src="/foodDelivery/images/${category.id}" width="200px"/></td>
		</tr>
	</table>
	<input type="submit" value="update"/>
	</form>
	<form action="delete?id=${category.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>