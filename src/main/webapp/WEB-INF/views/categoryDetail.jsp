<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Car</title>
<style type="text/css">
		img{
			max-width:100px;
		}
		
	</style>
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
			<td><img src="../images/${category.image}"/></td>
		</tr>
	</table>
	<input type="submit" value="update"/>
	</form>
	<form action="delete?id=${category.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>