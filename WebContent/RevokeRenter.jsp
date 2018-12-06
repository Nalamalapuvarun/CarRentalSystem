<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Revoke Renter</title>
<link rel="stylesheet" type="text/css" href="test.css" media="screen" />
</head>
<body style="width:450px;">

<input name="errMsg" value="<c:out value='${emsgs.r_errorMsg}'/>"
		type="text"
		style="background-color: white; color: red; border: none; width: 800px"
		disabled="disabled">
<h2 align="center">WELCOME TO REVOKE RENTER </h2>


<form name="Loginform" action="${pageContext.request.contextPath}/rentalcontrol" method="post" style="width: 300px; ">

<input type="submit"  name = "submit" value = "logout" />
</form>
<img src="car4.png" alt="car img" height="100" width="100">
<br><br><br>

<form name="Loginform" action="${pageContext.request.contextPath}/Admin" method="post" style="width: 300px; ">

<table><tr><td>Username<input type="text" name="username" /></td><td><input name="usernameError"
								value="<c:out value='${emsgs.r_usernameError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td></tr>

<tr><td><input type="submit" name="submit" value="Revoke" ></td></tr></table>
</form>


</body>
</html>