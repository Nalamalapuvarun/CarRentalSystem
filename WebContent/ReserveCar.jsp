<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CHOOSE CARS FROM HERE</title>
<link rel="stylesheet" type="text/css" href="test.css" media="screen" />
</head>
<body>
    <img src="car4.png" alt="car img" height="100" width="100">
	<table class="myTable">
        <tr class="myTableRow">
				<td>CAR NAME</td> &nbsp &nbsp &nbsp
				<td>CAPACITY</td>
				
				
				

			</tr>
		<c:forEach items="${caravail}" var="availcar">
			<tr class="myTableRow">
				<td>${availcar.carName}</td> 
				<td>${availcar.capacity} </td>
				
				
				

			</tr>
		</c:forEach>
	</table>
</body>
</html>