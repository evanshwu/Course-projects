<html>
	<head>
		<title>BMI Calculate</title>
	</head>
	<body>
		<h1>BMI Calculate</h1>
		
		<form action="Result.php" method="get">
			<a href="http://140.128.171.15/Calculate/Calculation.htm">Reference Link</a><br>
			Name: <input type="text" name="usrname"><br>
			Height(cm): <input type="text" name="height"><br>
			Weight(kg): <input type="text" name="weight"><br>
			Sex: <input type="radio" name="sex" value="boy">Boy<input type="radio" name="sex" value="girl"/>Girl<br>
			Age: <select name="age">
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
				 </select>
				<br>
		
			<input type="submit" value="Submit">
		</form>
		
		
	</body>
</html>