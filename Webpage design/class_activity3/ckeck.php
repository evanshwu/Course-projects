<!--
        This file is made by 吳信翰 403530026
        2015/11/3
        For CCU HTML Course (2015 Fall) only
-->
<html>
<title>Login</title>
<body>
	<br>Account Name = <?php 
        if(isset($_POST["aclogin"])){
            echo 'no account';
        }else{
            echo@$_POST["aclogin"];
        }
    ?> </br>
	<br>Password = <?php 
        if(isset($_POST["pwlogin"])){
            echo 'no password';
        }else{
            echo@$_POST["pwlogin"];
        }
    
    ?> </br>

	<br><?php 
		if($_FILES){ 
		$name = $_FILES['uploadpic']['name'];
		$size = $_FILES['uploadpic']['size'];
        $type = $_FILES['uploadpic']['type'];

		echo "name: $name<BR>";
		echo "size: $size<BR>";
        echo "type: $type<BR>";

		move_uploaded_file($_FILES['uploadpic']['tmp_name'],$name);
		echo "Uploaded image name: '$name'<BR><img src='$name'/>";
  		}
	?>
	</br>
</body>
</html>
