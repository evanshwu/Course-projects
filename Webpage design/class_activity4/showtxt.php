<!--  This file is made by Hsin Han Wu  -->
<!--    資管二   吳信翰  403530026      -->
<!--     2015.11.25    -->
<!--     showtxt.php     -->
<?php
	$name = $_FILES['filename']['name'];
	$tmp_name = $_FILES['filename']['tmp_name'];
	
	
	echo "name: $name<BR>";
	echo "tmp_name: $tmp_name<BR>";
  
	move_uploaded_file($_FILES['filename']['tmp_name'],$name);
	$filedir=fopen('/xampp/htdocs/'.$name, 'r');
	$content=fgets($filedir, 10);
	echo $content;
	fclose($filedir);
	
?>