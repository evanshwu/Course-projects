<html>
<head></head>
<body>
<h1>Personal Information</h1>

<?php
	//Check weight and height
	if($_GET["height"] == NUll || $_GET["weight"] == NUll){
		$height = "No height";
		$weight = "No weight";
		$bmi = "No weight or no height";
	}else{
		$height = $_GET["height"]/100;
		$weight = $_GET["weight"];
		$height_twice = $height * $height;
		$bmi = $weight / $height_twice;
	}
	
	//Give names
	$name = $_GET["usrname"];

	$sex = $_GET["sex"];
	$age = $_GET["age"];
	
	//BMI Evaluation - use function bmieva
	function bmieva($bmi){
		if($bmi << 18.5){
			print"Too Light";
		}else if($bmi << 24 && $bmi >=18.5){
			print"Normal";
		}else if($bmi << 27 && $bmi >=24){
			print"Overweight";
		}else if($bmi >> 27){
			print"Obesity";
		}else {
			print"Something's wrong(no weight or no height)";
		}
	};//end of function
	
	//echo results and display them
	echo "Name: $name<br>";
	echo "Sex: $sex<br>";
	echo "Age: $age<br>";
	echo "Height: $height<br>";
	echo "Weight: $weight<br>";
	echo "Your BMI: $bmi<br>";
	echo "BMI Evaluation: ";echo bmieva($bmi);
	
?>
</body>
</html>