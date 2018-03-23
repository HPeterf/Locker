<!DOCTYPE html>
<html>

<head>
<style>
html, body {
            margin: 10;
            height: 100%;
            color: black;
            font-family: calibri;
            font-size: 16px;
            overflow: hidden;
            }
</style>
</head>

<body>
	<form action="lockermodresult" method="POST">
		<b>Enter Employee name:</b>
		<br>
		<br>
		<input type="text" name="name" required />
		<br>
		<b>Enter new Locker number:</b>
		<br>
		<input type="number" name="number" required />
		<p>
		<input type="submit" name="Submit" value="Submit new Locker number" />
		</p>
	</form>
</body>
</html>