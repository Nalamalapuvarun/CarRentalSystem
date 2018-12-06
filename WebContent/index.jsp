<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WELCOME TO CAMPUS RENTAL CAR</title>
<link rel="stylesheet" type="text/css" href="test.css" media="screen" />
</head>
<body>
<input name="errMsg" value="<c:out value='${emsgs.errorMsg}'/>"
		type="text"
		style="background-color: white; color: red; border: none; width: 800px"
		disabled="disabled">
	<h2>WELCOME TO CAMPUS RENTAL CAR</h2>
	<img src="car4.png" alt="car img" height="100" width="100">
	
	<br>
	<br>
	<br>

	<form name="Loginform"
		action="${pageContext.request.contextPath}/rentalcontrol"
		method="post" style="width: 300px;">
		<table>
			<tr>
				<td>UserName</td>
				<td></td>
				<td><input type="text" id="username" name="user_name" /></td>
				<td><input name="usernameError"
								value="<c:out value='${emsgs.usernameError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td></td>
				<td><input type="password" id="password" name="password"></td>
				<td><input name="passwordError"
								value="<c:out value='${emsgs.passwordError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
			</tr>
			<tr>
				<td><a href="Registration.jsp">New User</a></td>
				<td></td>

			</tr>
			<tr>
			<tr>
				<td><input type="submit" name="submit" value="login"></td>
			</tr>
		</table>
	</form>

	</table>
</body>
</html>