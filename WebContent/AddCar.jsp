<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Car</title>
<link rel="stylesheet" type="text/css" href="test.css" media="screen" />
</head>
<body>
<input name="errMsg" value="<c:out value='${emsgs.a_errorMsg}'/>"
		type="text"
		style="background-color: white; color: red; border: none; width: 800px"
		disabled="disabled">
<h2>ADD CAR</h2>
<img src="car4.png" alt="car img" height="100" width="100">
<form name="Loginform" action="${pageContext.request.contextPath}/rentalcontrol" method="post" style="width: 300px; ">

<input type="submit"  name = "submit" value = "logout" />
</form>
<br><br><br>
<form name="Loginform" action="${pageContext.request.contextPath}/ManagerController" method="post" style="width: 300px; ">
<table style="width: 50%">
	<tr><td>Car Name </td><td><input type="text" name="CarName" value="${carname}" id="carname"></td>
	<td>
	</tr>
	<tr><td>Capacity </td><td><input type="text" name="Capacity"  value="${capacity}" id="carname"></td>
	<td><input name="usernameError"
								value="<c:out value='${emsgs.a_CapacityError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
	
	</tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td>Extra Rates :</td></tr>
	<tr><td>GPS</td><td><input type="text" name="Gps"  value="${gps}" id="gps"></td><td><input name="usernameError"
								value="<c:out value='${emsgs.a_GpsError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td></tr>
	<tr><td>OnStar</td><td><input type="text" name="OnStar"  value="${onstar}" id="OnStar"></td><td><input name="usernameError"
								value="<c:out value='${emsgs.a_OnStarError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td></tr>
	<tr><td>SiriusXM</td><td><input type="text" name="SiriusXM" value="${xm}" id="SiriusXM"></td><td><input name="usernameError"
								value="<c:out value='${emsgs.a_SiriusXMError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td>Rates :</td></tr>
	<tr><td>Weekday</td><td><input type="text" name="WeekDay"  value="${WD}" id="weekday"></td><td><input name="usernameError"
								value="<c:out value='${emsgs.a_WeekDayError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td></tr>
	<tr><td>Weekend</td><td><input type="text" name="WeekEnd" value="${WE}" id="weekend"></td><td><input name="usernameError"
								value="<c:out value='${emsgs.a_WeekEndError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td></tr>
	<tr><td>Week</td><td><input type="text" name="Week"  value="${ww}" id="week"></td><td><input name="usernameError"
								value="<c:out value='${emsgs.a_WeekError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td></tr>
	
</table>
<br>
<br>
<input type="submit"  name = "submit" value = "AddCar" /></form>
</body>
</html>