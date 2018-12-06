<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="test.css" media="screen" />
</head>
<body>
<input name="errMsg" value="<c:out value='${mess}'/>"
		type="text"
		style="background-color: white; color: red; border: none; width: 800px"
		disabled="disabled">

<img src="car4.png" alt="car img" height="100" width="100">
<form action="${pageContext.request.contextPath}/SearchFunction" method = "POST">
start date   <input type = "date" name = "startdate" value="${uname}" />
<input name="usernameError"
								value="<c:out value='${emsgs.s_startdateError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled">

<br>
end date     <input type = "date" name = "enddate" value="${uname}" />
<input name="usernameError"
								value="<c:out value='${emsgs.s_enddateError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled">
<br>
start time   <input type="text" name="starttime" value="${uname}" /> 
<input name="usernameError"
								value="<c:out value='${emsgs.s_starttimeError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled">
<br> 
End Time     <input type="text"  name="endtime"  value="${uname}"  /> 
<input name="usernameError"
								value="<c:out value='${emsgs.s_endtimeError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled">
<br>
Capacity     <input type="text" name="capacity" value="${uname}" />
<input name="usernameError"
								value="<c:out value='${emsgs.s_capacityError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled">
<br>

<input type="submit" name="submit" value="Search">

</form>
</body>
</html>