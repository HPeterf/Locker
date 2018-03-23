<!DOCTYPE html>
<html>

<head>

<!-- TODO: utána nézni, hogyan lehet a tabulátoroktól megszabadulni eclipseben. 1 db TAB == 4 db space stíluslapok kiszervezése külön css file-ba, lehetőleg minden oldalról ugyanazt a css file-t behúzni -->
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

<body>  <!-- spring form tag library használata -->
	<form action="lockerresult" method="POST">
		<b>Enter name to get a Locker:</b>
		<br>
		<br>

		<b>Enter Employee name:</b>
		<br>
		<input type="text" name="name" required />
		<br>
		<b>Enter locker number (max.:100):</b>
		<br>
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
	
	<input type="number" name="number" required />
	<p>
		<input type="submit" name="Submit" value="Find Employee">
	</p>
	</form>
	
	<br> <!-- ehelyett CSS margók használata -->
	<br>
	
	<form action="findlockerbyemployeename" method="GET">
	<b>Search for Employee by Name:</b>
	<br>
	
	<input type="text" name="name" required />
	<p>
		<input type="submit" name="Submit" value="Find Employee">
	</p>
	</form>
	
	<br>
	<br>
	
	<form action="deletelockerwithemployee" method="GET">  <!-- állapotváltoztató operációk esetén POST legyen a GET helyett -->
	<b>Delete Employee:</b>
	<br>
	<b>Enter Employee name:</b>
	<br>
	<input type="text" name="name" required />
	<p>
		<input type="submit" name="Submit" value="Delete" onclick="delete">  <!-- onclick helyett jquery eseménykezelő használata -->
	</p>
	</form>
	
	
	<br>
	<br>
	<div class="buttonbox">
	<a href="/lockermod" class="button">Change Locker number</a>
	<a href="/employeelist" class="button">Check reserved Lockers</a>
	</div>


</body>
</html>