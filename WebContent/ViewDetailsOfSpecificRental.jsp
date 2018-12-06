<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>VIEW DETAILS OF SPECIFIC RESERVATION</title>
<link rel="stylesheet" type="text/css" href="test.css" media="screen" />
</head>
<body>
<h2>VIEW DETAILS OF SPECIFIC RESERVATION</h2>
<img src="car4.png" alt="car img" height="100" width="100">
<form name="Loginform" action="${pageContext.request.contextPath}/rentalcontrol" method="post" style="width: 300px; ">

<input type="submit"  name = "submit" value = "logout" />
</form>
<br><br><br>
<form name="Loginform" action="${pageContext.request.contextPath}/ManagerController" method="post" style="width: 300px; ">
<table style="width: 50%">
	
	<tr>
		<td>Confirmation Id</td>
		<td><input type="text" name="confirmationid" id="confirmationid" /></td>
	</tr>
	
</table>
<br>
<br>
<input type="submit" name="submit" value="ViewDetails" ></form>
</body>
</html>