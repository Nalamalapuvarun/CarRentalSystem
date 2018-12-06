<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE PROFILE</title>
<link rel="stylesheet" type="text/css" href="test.css" media="screen" />
</head>
<body>
<input name="errMsg" value="<c:out value='${emsgs.u_errorMsg}'/>"
		type="text"
		style="background-color: white; color: red; border: none; width: 800px"
		disabled="disabled">
<h2>UPDATE PROFILE</h2>
<img src="car4.png" alt="car img" height="100" width="100">
<form name="Loginform" action="${pageContext.request.contextPath}/rentalcontrol" method="post" style="width: 300px; ">

<input type="submit"  name = "submit" value = "logout" />
</form>
<br><br><br>
<form name="Loginform" action="${pageContext.request.contextPath}/Admin" method="post" style="width: 300px; ">
<table style="width: 50%">
	<tr>
		<td>User Name</td>
		<td><input type="text" name="username" value="${uname}" id="username"/></td>
	</tr>
	
	<tr>
		<td>Full Name</td>
		<td><input type="text" name="name"  value="${fname}" id="fullname"/></td>
		<td><input name="usernameError"
								value="<c:out value='${emsgs.u_nameError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
	</tr>
	

<tr>
		<td>Email</td>
		<td><input type="email" name="email"  value="${email1}"id="email"/></td>
		<td><input name="usernameError"
								value="<c:out value='${emsgs.u_emailError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
	</tr>	
	
	<tr>
		<td>Phone Number:</td>
		<td><input type="text" name="phone" value="${fno}" id="phoneno"/></td>
		<td><input name="usernameError"
								value="<c:out value='${emsgs.u_phonenoError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
	</tr>
	
<tr>
		<td>Address</td>
		<td><input type="textarea" rows="4" columns="5"  value="${add}" name="addr" id="address"/></td>
		<td><input name="usernameError"
								value="<c:out value='${emsgs.u_addressError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
	</tr>
<tr>
		<td>Current Password</td>
		<td><input type="password" name="curpassword" id="currentpassword"/></td>
		<td><input name="usernameError"
								value="<c:out value='${emsgs.u_curpasswordError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
	</tr>
	<tr>
		<td>New Password</td>
		<td><input type="password" name="newpassword" id="newpassword"/></td><td><input name="usernameError"
								value="<c:out value='${emsgs.u_newpasswordError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
	</tr>
	<tr>
		<td>Confirm Password</td>
		<td><input type="password" name="conpassword" id="confirmpassword"/></td><td><input name="usernameError"
								value="<c:out value='${emsgs.u_conpasswordError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
	</tr>



</table>
<br>
<br>
<br>
<input type="submit" name="submit" value="Update" >
</form>
</body>
</html>