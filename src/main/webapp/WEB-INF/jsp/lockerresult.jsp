<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<body>
	<b>Locker reservation Result:</b>
	<br>
	<p>
		<c:out value="${result}" />
	</p>
	<p>
		<c:out value="${error}" />
	</p>
	<br>
	<a href="/employee">Add a new Employee</a>
	<br>
	<a href="/lockermod">Change locker number</a>

	<br>
	<a href="/employeelist">Check employees who already have a Locker</a>

</body>

</html>