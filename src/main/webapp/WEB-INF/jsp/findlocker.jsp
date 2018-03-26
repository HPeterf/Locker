<!DOCTYPE.html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="locker-does-not-exist.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

		<c:forEach items="${lockers}" var="lockers">
			<tr>
 				<td><c:out value="${lockers.employee.name}" /></td>
				<td><c:out value="${lockers.number}" /></td>
			</tr>
			</c:forEach>
	</table>
</body>

<br>
<br>
<div class="buttonbox">
<a href="/lockermod" class="button">Reserve a new Locker</a>
<a href="/employee" class="button">Back to Main Page</a>
</div>
</html>