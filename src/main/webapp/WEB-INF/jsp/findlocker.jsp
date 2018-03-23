<!DOCTYPE.html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="locker-does-not-exist.jsp" %>
<html>

<head>
<style>
a:link {
		color: purple;
		text-decoration: none;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
td {
    text-align: center;
}
table {
    border-spacing: 5px;
    background-color:  	#dfb9d2;
    font-family: arial, sans-serif;
    border-collapse: collapse;
}
tr:nth-child(even) {
    background-color: #FFF8DC;
}
.button {
       font-size: 12px;
       background-color: aqua;
       padding: 10px; 
       width: 120px;
       display: inline-block;           
       }
.button:hover {
       background-color: orange;
       transition-duration: 0.1s;
       }
</style>
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