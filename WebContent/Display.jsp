<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<input name="errMsg" value="<c:out value='${errorMsg}'/>"
		type="text"
		style="background-color: white; color: red; border: none; width: 800px"
		disabled="disabled">
<img src="car4.png" alt="car img" height="100" width="100">
<link rel="stylesheet" type="text/css" href="test.css" media="screen" />
<table><tr><td>CAR AVAILABLE </td></tr>
<c:forEach items="${list}" var="item">
  <tr><td>  ${item}  </td></tr><br>
</c:forEach>
</table>
<br> <br> <br>
Please Choose your car from drop Down List : 
<select name="database1" form="carform" >
  <option value="SUV">SUV</option>
  <option value="Compact">Smart</option>
  <option value="Smart">Compact</option>
  
</select><br><br>
<select name="CardName" form="carform" >
  <option value="volvo">VISA</option>
  <option value="saab">MASTER CARD</option>
  <option value="mercedes">AMERICAN EXPRESS</option>
  <option value="audi">DISCOVER</option>
</select><br>

<form action="${pageContext.request.contextPath}/SearchFunction" id="carform" method = "POST">
Select the additional features <br>
<input type="checkbox" name="GPS" value="1"> GPS

<input type="checkbox" name="OnStar" value="1"> OnStar

<input type="checkbox" name="siriusXm" value="1" > siriusXm <br><br><br>

Card No <input type="text" name="cardno" >
<input name="usernameError"
								value="<c:out value='${emsgs.p_cardnoError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"><br>
VALID THROUGH <input type="text" name="vt" >
<input name="usernameError"
								value="<c:out value='${emsgs.p_expirationdateError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"><br>
CVV NO <input type="text" name="cvv"/><input name="usernameError"
								value="<c:out value='${emsgs.p_cvvnoError}'/>" type="text"
								style="background-color: white; color: red; border: none; width: 800px"
								disabled="disabled"><br>


<input type = "hidden" name = "startdaten" value="${startdate}" /><br>
<input type = "hidden" name = "enddaten" value="${enddate}" /><br>
<input type="hidden" name="starttimen" value="${starttime}"/> <br> 
<input type="hidden"  name="endtimen" value="${endtime}" /> <br>
<input type="hidden" name="capacityn"  value="${capacity}" /><br>


             <input type ="submit" value="BookMyCar" name="submit"/>
</form>


<a href="index.jsp" id="abc">logout</a>

</body>
</html>