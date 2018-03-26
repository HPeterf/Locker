<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>

<!-- TODO: utána nézni, hogyan lehet a tabulátoroktól megszabadulni eclipseben. 1 db TAB == 4 db space stíluslapok kiszervezése külön css file-ba, lehetőleg minden oldalról ugyanazt a css file-t behúzni -->
<link rel="stylesheet" href="../WEB-INF/css/lockerapp.css"/>
</head>

<body>  <!-- spring form tag library használata -->

		<b>Enter name to get a Locker:</b>
	<form:form action="lockerresult" method="POST">
		<table>
		<tr>
			<td><form:label path="name">Enter Employee name:</form:label></td>
			<td><form:input path="name" required/></td>
		</tr>
		<tr>
			<td><form:label path="number">Enter locker number (Max:100)</form:label></td>
			<td><form:input path="number" required/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"/></td>
		</tr>	
		</table>
	</form:form>
	
	<br>
	<br>
	<form:form action="findlocker" method="GET">
	<table>
		<tr>
			<td><form:label path="number">Search for Employee by Locker number:</form:label></td>
			<td><form:input path="number" required/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Find Employee"/></td>
		</tr>	
		</table>
	</form:form>
	
	<br> <!-- ehelyett CSS margók használata -->
	<br>

	<form:form action="findlockerbyemployeename" method="GET">
		<table>
		<tr>
			<td><form:label path="name">Search for Employee by Name:</form:label></td>
			<td><form:input path="name" required/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Find Employee"/></td>
		</tr>	
		</table>
	</form:form>
	
	<br>
	<br>
	
	<form:form action="deletelockerwithemployee" method="POST">  <!-- állapotváltoztató operációk esetén POST legyen a GET helyett -->
		<table>
		<tr>
			<td><form:label path="name">Delete Employee:</form:label></td>
			<td><form:input path="name" required/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Delete Employee"/></td>
		</tr>	
		</table>
	</form:form>
	
	
	<br>
	<br>
	<div class="buttonbox">
	<a href="/lockermod" class="button">Change Locker number</a>
	<a href="/employeelist" class="button">Check reserved Lockers</a>
	</div>


</body>
</html>