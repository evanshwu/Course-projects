<!--
        This file is made by 吳信翰 403530026
        2015/11/3
        For CCU HTML Course (2015 Fall) only
-->
<html>
<title>BMI</title>
<h1>
 <form action="Activity3_2.php" method="get">
        <p>
		<label for="height">Height(m):</label>
		<input type="text" name="height" id="height" />
        </p>
        <p>
		<label for="weight">Weight(kg):</label>
		<input type="number" name="weight" id="weight" />
        </p>
        <p>
        	<input type="submit" value="Call"/>
        </p>
 </form>
<h1>
    <br>
        <?php
            $height = $_GET["height"] * $_GET["height"];
            $weight = $_GET["weight"];
            $bmi = $weight / $height;
            echo "Your BMI is : ".$bmi;
        ?>
    </br>
	
</html>
