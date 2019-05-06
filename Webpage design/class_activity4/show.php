<!--  This file is made by Hsin Han Wu  -->
<!--    資管二   吳信翰  403530026      -->
<!--     2015.11.25    -->
<!--     show.php     -->
<?php
	$newfile=fopen('newfile.txt', 'a') or die ("Unable to reach file, please create the file.");
	
	$txt1="Name: ".$_POST['name']."\n";
	$txt2="StudentID: ".$_POST['id']."\n";
	$txt3="Sex: ".$_POST['gender']."\n";
	$txt4="Age: ".$_POST['age']."\n";
	
	if (isset($_POST['sub'])){
		echo "Submit pressed, will save input to newfile.txt.".'<BR>';
		fwrite($newfile, $txt1);
		fwrite($newfile, $txt2);
		fwrite($newfile, $txt3);
		fwrite($newfile, $txt4);
		fclose($newfile);
		echo 'Write successful.';
	}else if (isset($_POST['del'])){
		echo "Delete pressed, will delete newfile.txt".'<BR>';
		unlink('newfile.txt');
		echo "Delete successful.";
	}
?>