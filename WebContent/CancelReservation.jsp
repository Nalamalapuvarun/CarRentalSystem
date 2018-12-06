<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CANCEL MY RESRVATION</title>
<link rel="stylesheet" type="text/css" href="test.css" media="screen" />
</head>
<body>
<h2>CANCEL MY RESERVATION</h2>
<img src="car4.png" alt="car img" height="100" width="100">
<form name="Loginform" action="${pageContext.request.contextPath}/rentalcontrol" method="post" style="width: 300px; ">
<input type ="button" value="LOGOUT">
<input type="submit"  name = "submit" value = "logout" />
</form>
<br><br><br>

<form name="Loginform" action="${pageContext.request.contextPath}/UserController" method="post" style="width: 300px; ">
<table style="width: 50%">
	<tr>
		<td>Confirmation Id</td>
		<td><input type="text" name="confirmationid" id="confirmationid" /></td>
	</tr>
	<tr>
		<td>UTA ID</td>
		<td><input type="text" name="uta_id" id="utaid"/></td>
	</tr>	
	
	
</table>
<br>
<br>
<input type="submit"  name = "submit" value = "CancelReservation" />
</form>
</body>
</html>