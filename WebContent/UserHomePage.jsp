<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USER HOME PAGE</title>
<link rel="stylesheet" type="text/css" href="test.css" media="screen" />
</head>
<body>
<h2>USER HOME PAGE</h2><br>
<h2> Welcome <input name="Username"  value="<c:out value='${username}'/>" type="text"  style =" color: blue; " disabled="disabled"></h2>

<img src="car4.png" alt="car img" height="100" width="100">
<br>
<input name="errMsg" value="<c:out value='${Message}'/>"
		type="text"
		style="background-color: white; color: red; border: none; width: 800px"
		disabled="disabled">
		
<form name="Loginform" action="${pageContext.request.contextPath}/rentalcontrol" method="post" style="width: 300px; ">

<input type="submit"  name = "submit" value = "logout" />
</form>
<br><br><br>
1.<a href="searchcarnew.jsp"> Search car </a> <br>
2.<a href="ViewMyReservation.jsp"> View My Reservation </a> <br>
3.<a href="CancelReservation.jsp"> Cancel My Reservation </a> <br>

<br> <br> <br>
<form name="Loginform" action="${pageContext.request.contextPath}/rentalcontrol" method="post" style="width: 300px; ">

<input type="submit" name="submit" value="editprofile" style ="color: yellow;  " >




</body>
</html>