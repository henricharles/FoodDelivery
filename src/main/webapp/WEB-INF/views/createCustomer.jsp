    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"  	pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Creation of customer</title>
    </head>
    <style>
    div.ex {
    	text-align: right width:300px;
    	padding: 10px;
    	border: 5px solid grey;
    	margin: 0px
    }
    </style>
    <body>
    	<h1>Customer registration Form</h1>
    	<div class="ex">
    		<spring:url var="customer_add" value="/Customers/Signup" />
    		<form:form  modelAttribute="newCustomer" class="form-horizontal" action="${customer_add}" >
    		
    			<table style="with: 50%">
    				
    				<tr>
    					<td>First Name</td>
    					<td><form:input path="firstName" type="text" class="form:input-large"/>
    					<form:errors path="firstName" cssStyle="color:red"/></td>
    				</tr>
    				<tr>
    					<td>Last Name</td>
    					<td><form:input path="lastName" type="text" class="form:input-large"/>
    					<form:errors path="lastName" cssStyle="color:red"/>
    					</td>
    				</tr>
    				
    				<tr>
    					<td>Email</td>
    					<td><form:input path="email" type="text" class="form:input-large"/>
    					<form:errors path="email" cssStyle="color:red"/>
    					</td>
    				</tr>
    				<tr>
    					<td> User Name</td>
    					<td><form:input type="text" path="user.username" />
    					<form:errors path="user.username" cssStyle="color:red"/></td>
    				</tr>
    				<tr>
    					<td> Password</td>
    					<td><form:input type="password" path="user.password" /></td>
    					<form:errors path="user.password" cssStyle="color:red"/>
    				</tr>
    		
    				<tr>
    					<td>City</td>
    					<td><form:input type="text" path="adress.city" />
    	
    					</td>
    				</tr>
    				<tr>
    					<td>State</td>
    					<td><form:input type="text" path="adress.state" />
    	
    					</td>
    				</tr>
    				
    				<tr>
    					<td>Street</td>
    					<td><form:input type="text" path="adress.street" />
    	
    					</td>
    				</tr>
    				<tr>
    					<td>Zip</td>
    					<td><form:input type="text" path="adress.zip" />
    	
    					</td>
    				</tr>
    				
<tr>
    					<td>Mobile Number</td>
    					<td><form:input type="text" path="phone" />
    	
    					</td>
  
    				</tr>
    				<tr>
    			</table>
    			<input type="submit" value="register" />
    		</form:form>
    	</div>
    </body>
    </html>