<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
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

<a href="/employee">Add new Employee</a>
<a href="/lockermod">Change locker number</a> 

</html>