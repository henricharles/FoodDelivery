<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<body>
 	<%@include file="Admin/header.jsp" %>
	<form:form action="categories" method="post" commandName="category" enctype="multipart/form-data" >
		<table>
			<tr>
			<td>Category Name:</td>
			<td><form:input class="input-group" path="name" required="required" /> </td>
			<td><form:errors path="name" cssStyle="color:red;"/></td>
		</tr>
		<tr>
			<td>Choose Image:</td>
			<td><form:input class="input-group" type="file" path="image"/> </td>
			
		</tr>
		<tr colspan="2">
			<td><input class="input-group label label-default" type="submit" value="save" /></td>
		</tr>
		</table>
	</form:form>
</body>
</html>