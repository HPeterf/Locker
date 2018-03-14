<!DOCTYPE.html>
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

		<c:forEach items="${lockers}" var="locker">
			<tr>
				<td><c:out value="${lockers.employee.name}" /></td>
				<td><c:out value="${lockers.number}" /></td>
			</tr>
			</c:forEach>
	</table>
</body>

<br>
<br>
<a href="/lockermod">Reserve a new Locker</a>

<br>
<br>

<a href="/employee">Add new Employee</a>

</html>