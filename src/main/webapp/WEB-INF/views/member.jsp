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
    	<h1>Member Form</h1>
    	<div class="ex">
    		<form  action="add1" method="post">
    		
    			<table style="with: 50%">
    				
    				<tr>
    					<td>First Name</td>
    					<td><input name="firstName" type="text" class="input-large"/></td>
    				</tr>
    				<tr>
    					<td>Last Name</td>
    					<td><input name="lastName" type="text" class="input-large"/></td>
    				</tr>
    				
    				<tr>
    					<td>Email</td>
    					<td><input name="email" type="text" class="form:input-large"/></td>
    				</tr>
    				<tr>
    					<td> User Name</td>
    					<td><input type="text" name="user.username" class="form:input-large"/></td>
    				</tr>
    				<tr>
    					<td> Password</td>
    					<td><input type="password" name="user.password" class="form:input-large"/></td>
    				</tr>
    		
    				<tr>
    					<td>City</td>
    					<td><input type="text" name="adress.city" class="form:input-large"/>
    	
    					</td>
    				</tr>
    				<tr>
    					<td>State</td>
    					<td><input type="text" name="adress.state" class="form:input-large"/>
    	
    					</td>
    				</tr>
    				
    				<tr>
    					<td>Street</td>
    					<td><input type="text" name="adress.street" class="form:input-large" />
    	
    					</td>
    				</tr>
    				<tr>
    					<td>Zip</td>
    					<td><input type="text" name="adress.zip" class="form:input-large" />
    	
    					</td>
    				</tr>
    				
<tr>
    					<td>Mobile Number</td>
    					<td><input type="text" name="phone" />
    	
    					</td>
  
    				</tr>
    				<tr>
    			</table>
    			<input type="submit" value="register" />
    		</form>
    	</div>
    </body>
    </html>