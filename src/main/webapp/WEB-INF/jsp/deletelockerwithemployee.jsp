<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="employee-does-not-exist.jsp" %>

<html>
<head>
<link rel="stylesheet" href="../WEB-INF/css/lockerapp.css"/>
</head>

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
	<br>
	
	<div class ="buttonbox">
	<a href="/employee" class="button">Back to Main Page</a>
	<a href="/employeelist" class="button">Check reserved Lockers</a>
	</div>

</body>

</html>