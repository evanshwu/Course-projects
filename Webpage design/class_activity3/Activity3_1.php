<!--
        This file is made by 吳信翰 403530026
        2015/11/3
        For CCU HTML Course (2015 Fall) only
-->
<html>
<title>Login</title>

 <form action="ckeck.php" method="post" enctype='multipart/form-data'>
        <p>
		<label for="aclogin">Account:</label>
		<input type="text" name="aclogin" id="aclogin" />
        </p>
        <p>
		<label for="pwlogin">Password:</label>
		<input type="password" name="pwlogin" id="pwlogin" />
        </p>
	<p>
		Upload Picture:
		<input type = "file" name="uploadpic"/>
	</p>

        <p>
        	<input type="submit" value="Login"/>
        </p>
 </form>
	
</html>
