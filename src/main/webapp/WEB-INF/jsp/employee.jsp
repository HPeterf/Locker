<!DOCTYPE html>

<html>

<head>
</head>

<body>
	<form action="lockerresult" method="POST">
		<b>Enter name to get a Locker:</b>
		<br>
		<br>

		<b>Enter Employee name:</b>
		<input type="text" name="name" required />
		<br>
		<b>Enter locker number:</b>
		<input type="number" name="number" required />
		<p>
			<input type="submit" name="Submit" value="Submit" />
		</p>

	</form>
	
	<br>
	<br>
	
	<form action="findlocker" method="GET">
	<b>Search for Employee by Locker number:</b>
	<br>
	
	<input type="number" name="locker" required />
	<p>
		<input type="submit" name="Submit" value="Submit">
	</p>
	</form>
	
	<br>
	<br>
	<a href="/lockermod">Click here to change your Locker number</a>

	<br>	
	<br>
	<a href="/employeelist">Check employees who already have a Locker</a>
	<br>
	<br>

</body>
</html>