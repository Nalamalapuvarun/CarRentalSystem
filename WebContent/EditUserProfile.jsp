<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE PROFILE</title>
<link rel="stylesheet" type="text/css" href="test.css" media="screen" />
</head>
<body>
<h2>UPDATE PROFILE</h2>
<img src="car4.png" alt="car img" height="100" width="100">
<form name="Loginform" action="${pageContext.request.contextPath}/Admin" method="post" style="width: 300px; ">

<input type="submit"  name = "submit" value = "logout" />
</form>
<br><br><br>
<form name="Loginform" action="${pageContext.request.contextPath}/Admin" method="post" style="width: 300px; ">
<table style="width: 50%">
	<tr>
		<td></td>
		<td><input type="hidden" name="user_name"  value="${uname}" id="username" /></td>
	</tr>
	
	<tr>
		<td>Full Name</td>
		<td><input type="text" name="name"  value="${fname}" id="fullname"/></td>
	</tr>
	

<tr>
		<td>Email</td>
		<td><input type="email" name="email" value="${email1}" id="email"/></td>
	</tr>	
	
	<tr>
		<td>Phone Number:</td>
		<td><input type="text" name="phone" value="${fno}" id="phoneno"/></td>
	</tr>
	
<tr>
		<td>Address</td>
		<td><input type="textarea" rows="4" columns="5"  value="${add}" name="addr" id="address"/></td>
	</tr>
<tr>
		


</table>
<br>
<br>
<br>
<input type="submit" name="submit" value="UpdateUserProfile" >
</form>
</body>
</html>