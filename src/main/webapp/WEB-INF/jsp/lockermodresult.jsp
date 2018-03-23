<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="something-went-wrong.jsp" %>
<html>

<head>
<style>
a:link {
		color: purple;
		text-decoration: none;
}
html, body {
            margin: 10;
            height: 100%;
            color: black;
            font-family: calibri;
            font-size: 16px;
            overflow: hidden;
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
	<b>Result:</b>
	<br>
	<p>
		<c:out value="${result}" />
	</p>
	<p>
		<c:out value="${error}" />
	</p>
	
	<br>
	<br>
	<div class="buttonbox">
	<a href="/employee" class="button">Back to Main Page</a>
	<a href="/lockermod" class="button">Change locker number</a>
	<a href="/employeelist" class="button">Check reserved Lockers</a>
	</div>
</body>

</html>