<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<body>
 
	<form action="categories" method="post"  enctype="multipart/form-data">
		<table>
			<tr>
			<td>Category Name:</td>
			<td><input type="text" name="categoryName" /> </td>
		</tr>
		<tr>
			<td>Choose Image:</td>
			<td><input type="file" name="image" /> </td>
		</tr>
		<tr colspan="2">
			<td><input type="submit" value="save" name="submit"></td>
		</tr>
		</table>
	</form>
</body>
</html>