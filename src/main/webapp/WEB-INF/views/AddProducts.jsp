
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>

<form:form action="AddProduct" method="post" commandName="product">
	<table>
		<tr>
		<%-- <td>Product Number</td>
		<td><form:input path="id" /></td>
		</tr> --%>
		
		<tr>
		<td>Name</td>
		<td><form:input path="name" /></td>
		</tr>
		
		<tr>
		<td>Description</td>
		<td><form:input path="description" /></td>
		</tr>
		
		<tr>
		<td>Price</td>
		<td><form:input path="price" /></td>
		</tr>	
		
		<tr>
		<td>Category</td>
		<td><form:select path="category" items="${categories}" multiple="false" /> </td>
		</tr>
		
		<tr>
		<td>Photo</td>
		<td><form:input type="file" path="photo" /> </td>
		</tr>
		
		<tr>
		<td></td><td><input type="submit" value="${Val}"></td>
		</tr>
	</table>
	</form:form>
	
</body>
</html>