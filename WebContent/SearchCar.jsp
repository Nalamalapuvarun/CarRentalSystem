<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head color:>
<meta charset="ISO-8859-1">
<title>Search Car</title>
<style type="text/css">
body {
	background-image: url("car3.png"), url("paper.gif");
	background-repeat: no-repeat;
	background-position: bottom;
	background-color: #c9c3c3;
	width: 100%;
}

h2 {
	font-weight: bold;
	font-weight: 900;
}

table {
	width: 50%;
	font-weight: 900;
	font-weigth: bold;
}

table tr td {
	font-weigth: bold;
	font-weight: 900;
}

tr:hover {
	background-color: #4CAF50;
}

a {
	font-weight: bold;
	text-align: right;
	vertical-align: top;
	margin-left: 1400px;
	'
}
</style>
</head>

<body background-image="car3.png">
	<h2>Search Car</h2>
	<img src="car4.png" alt="car img" height="100" width="100">

	<form action="${pageContext.request.contextPath}/SearchcarControl"
		method="post">
		<table>
			
			<tr>
				<td>Select start date:</td>
				<td><input type="text" name="startdate" id="startdate"></td>
			</tr>
			
			<tr>
				<td>Select end date:</td>
				<td><input type="text" name="enddate" id="enddate"></td>
			</tr>
			

		</table>
		<br> <br> <input type="submit" name="submit"
			value="searchcar" />
	</form>
</body>
</html>