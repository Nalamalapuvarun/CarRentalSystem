<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW AVAILABLE CARS</title>
<link rel="stylesheet" type="text/css" href="test.css" media="screen" />
</head>
<body>
<h2>VIEW AVAILABLE CARS</h2>
<img src="car4.png" alt="car img" height="100" width="100">
<form name="Loginform" action="${pageContext.request.contextPath}/rentalcontrol" method="post" style="width: 300px; ">

<input type="submit"  name = "submit" value = "logout" />
</form>
<br><br><br>
<form action=" " method="post">
<table style="width: 50%">
	<tr>
		
		
	<tr><td>Select start date: </td><td><input type="date" name="startdate" id="startdate"></td></tr>
	<tr><td>Select end date: </td><td><input type="date" name="startdate" id="enddate"></td></tr>
	
</table>
<br>
<br>
<input type="submit"  name = "submit" value = "Submit" /></form>
</body>
</html>