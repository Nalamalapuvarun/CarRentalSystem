<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="test.css" media="screen" />
<title>BooKing Details</title>
</head>
<body>
<img src="car4.png" alt="car img" height="100" width="100">
<h1>YOUR RESERVATION IS CONFIRM</h1><br>
Your Reservation Details are : <br>
Start date :<input name="errMsg" value="2018-11-30"
		type="text"
		style="background-color: white;  border: none; width: 800px"
		disabled="disabled"><br>
End Date<input name="errMsg" value="<c:out value='${enddate}'/>"
		type="text"
		style="background-color: white;  border: none; width: 800px"
		disabled="disabled"><br>
Start Time <input name="errMsg" value="<c:out value='${starttime}'/>"
		type="text"
		style="background-color: white;  border: none; width: 800px"
		disabled="disabled"><br>
		
End Time<input name="errMsg" value="<c:out value='${endtime}'/>"
		type="text"
		style="background-color: white;  border: none; width: 800px"
		disabled="disabled"><br>

Capacity <input name="errMsg" value="<c:out value='${capacity}'/>"
		type="text"
		style="background-color: white;  border: none; width: 800px"
		disabled="disabled"><br>
CarName<input name="errMsg" value="<c:out value='${CarName}'/>"
		type="text"
		style="background-color: white;  border: none; width: 800px"
		disabled="disabled"><br>
		
Total Price Charged $<input name="errMsg" value="<c:out value='${price}'/>"
		type="text"
		style="background-color: white;  border: none; width: 800px"
		disabled="disabled"><br>
		

Return To HomePage <a href="UserHomePage.jsp">CLick Here</a>		
		
</body>
</html>