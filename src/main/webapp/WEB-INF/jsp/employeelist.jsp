<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<link rel="stylesheet" href="../WEB-INF/css/lockerapp.css"/>
</head>

<body>
	<table border="1" width="50%">

		<tr>
			<th>Employee</th>
 			<th>Locker No.</th>
		</tr>

		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.name}" /></td>
  				<td><c:out value="${employee.locker.number}" /></td>
			</tr>
 		</c:forEach>
	</table>
</body>

<br>
<br>
<div class="buttonbox">
<a href="/employee" class="button">Back to Main Page</a>
<a href="/lockermod" class="button">Change locker number</a> 
</div>
</html>