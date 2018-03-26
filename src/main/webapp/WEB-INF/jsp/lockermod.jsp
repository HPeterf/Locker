<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<link rel="stylesheet" href="../WEB-INF/css/lockerapp.css"/>
</head>

<body>
		<b>Enter Employee name:</b>
	<form:form action="lockermodresult" method="POST">
		<table>
		<tr>
			<td><form:label path="name">Enter Employee name:</form:label></td>
			<td><form:input path="name" required/></td>
		</tr>
		<tr>
			<td><form:label path="number">Enter new locker number (Max:100)</form:label></td>
			<td><form:input path="number" required/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit new Locker Number"/></td>
		</tr>	
		</table>
	</form:form>
</body>
</html>