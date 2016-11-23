
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>

	<form:form action="AddProduct" method="post" commandName="product"
		enctype="multipart/form-data">
		<table>
		
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>Description</td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>Price</td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>Category</td>
				<td><form:select path="category.id" >
						<option value="">Please Select</option>
						<form:options items="${categories}" itemValue="id"
							itemLabel="name" />
					</form:select></td>
			</tr>

			<tr>
				<td>Photo</td>
				<td><input type="file" name="productImage" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="${Val}"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>