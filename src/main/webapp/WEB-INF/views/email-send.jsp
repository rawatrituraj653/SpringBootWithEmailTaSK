<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register-form</title>
	<style type="text/css">
		.app{
			text-align: center;
			border: 2px solid gray;
			border-radius: 10px;
			background-color: lightyellow;
			font-weight: bold;
			color: blue;
			
		}
		.error{
			color:red;
		}	
	</style>
</head>
<body>
	<h2 style="background-color: lime; text-align: center; color:Blue;">Email Sending Page</h2>
		<form:form action="send" method="POST" modelAttribute="emailModel" enctype="multipart/form-data">
		<pre class="app">
		TO :    <form:input path="userTo"/>      cc: <form:input path="userCc"/><br>
		<form:errors path="userTo" cssClass="error"/>						
		Subject:<form:input path="subject"/>     Bcc: <form:input path="userBcc"/><br>
		<form:errors path="subject" cssClass="error" />	
		Text:
			<form:textarea path="message"/>
			<form:errors path="message" cssClass="error"/><br>
		File:
			<input type="file" name="fileOb"/>	
				
		<input type="submit" value="Send"/>
		</pre>
		</form:form> 
	<font color="green" size=6> ${msg} </font><br>		
</body>
</html>