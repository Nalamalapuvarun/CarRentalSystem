<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User Role</title>
<link rel="stylesheet" type="text/css" href="test.css" media="screen" />
</head>
<body style="width:450px;">
<h2 align="center">WELCOME TO EDIT USER ROLE</h2>

<form name="Loginform" action="${pageContext.request.contextPath}/rentalcontrol" method="post" style="width: 300px; ">

<input type="submit"  name = "submit" value = "logout" />
</form>
<img src="car4.png" alt="car img" height="100" width="100">
<br><br><br>

<form name="Loginform" action="${pageContext.request.contextPath}/Admin" method="post" style="width: 300px; ">
<table style="width: 50%">
	
	<tr><td>Username </td><td><input type="text" name="username" c></td></tr>
	
	<tr><td>Role </td><td><input type="text" name="role"></td></tr>
	
	
</table>
<br>
<br>



<input type="submit" name="submit" value="editrole" >
</form>
</body>
</html>