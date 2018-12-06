<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<img src="car4.png" alt="car img" height="100" width="100">
	<input name="errMsg" value="<c:out value='${errorMsgs.errorMsg}'/>"
		type="text"
		style="background-color: white; color: red; border: none; width: 800px"
		disabled="disabled">
	<table>
		<tr>
			<td>
				<h2>Car Rental System</h2> IN REGISTRATION PAGE

				<form action="${pageContext.request.contextPath}/rentalcontrol"
					method="post">
					<table style="width: 50%">
						<tr>
							<td>User Name</td>
							<td><input type="text" name="user_name" /></td>
							<td><input name="usernameError"
								value="<c:out value='${errorMsgs.usernameError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="password" name="password" /></td>
							<td><input name="passwordError"
								value="<c:out value='${errorMsgs.passwordError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
							
						</tr>
						<tr>
							<td>Full Name</td>
							<td><input type="text" name="name" /></td>
							<td><input name="firstNameError"
								value="<c:out value='${errorMsgs.firstNameError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
						</tr>
						<TR>
							<TD>Role</TD>
							<TD><select name="select" value="select">
									<option value="user">user</option>
									<option value="manager">manager</option>
									<option value="admin">admin</option>

							</select></TD>
						</TR>
						<tr>
							<td>License</td>
							<td><input type="text" name="license" /></td>
							<td><input name="LicenseError"
								value="<c:out value='${errorMsgs.licenseError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
						</tr>

						<tr>
							<td>Email</td>
							<td><input type="email" name="Emai" /></td>
							<td><input name="emailError"
								value="<c:out value='${errorMsgs.emailError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
						</tr>
						<tr>
							<td>Age</td>
							<td><input type="age" name="age" /></td>
							<td><input name="ageError"
								value="<c:out value='${errorMsgs.ageError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
						</tr>
						

						<tr>
							<td>Phone Number:</td>
							<td><input type="text" name="phno" /></td>
							<td><input name="phoneError"
								value="<c:out value='${errorMsgs.phonenoError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>
						</tr>

						<tr>
							<td>Address</td>
							<td><input type="textarea" rows="4" columns="5" name="addr" /></td>
							<td><input name="addressError"
								value="<c:out value='${errorMsgs.addressError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>

						</tr>

						<tr>
							<td>UTA ID</td>
							<td><input type="text" name="uta_id" /></td>
							<td><input name="UtaIdError"
								value="<c:out value='${errorMsgs.utaidError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"></td>

						</tr>

						<tr>
							<td>Auto club Member</td>
							<td><input type="radio" name="auto_club" value="yes" />Yes</td>
							<td><input type="radio" name="auto_club" value="no" />No</td>
						</tr>
					</table>
					<br> <br> <input type="submit" name="submit"
						value="Register" />
				</form>
</body>
</html>