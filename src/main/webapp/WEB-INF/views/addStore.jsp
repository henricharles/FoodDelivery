    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
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
    	<h1>Store Creation  Form</h1>
    	<div class="ex">
    		<form action="customerSignup" method="post">
    			<table style="with: 50%">
    				
    				<tr>
    					<td>Store Name</td>
    					<td><input type="text" name="firstname" /></td>
    				</tr>

    				<tr>
    					<td>City</td>
    					<td><input type="text" name="city" />
    	
    					</td>
    				</tr>
    				<tr>
    					<td>State</td>
    					<td><input type="text" name="state" />
    	
    					</td>
    				</tr>
    				
    				<tr>
    					<td>Street</td>
    					<td><input type="text" name="street" />
    	
    					</td>
    				</tr>
    				<tr>
    					<td>Zip</td>
    					<td><input type="text" name="zip" />
    					</td>
    				</tr>
    			</table>
    			<input type="submit" value="Add Store" />
    		</form>
    	</div>
    </body>
    </html>