<html>
	<head></head>
	<body>
		<?php
			$image = $_FILES["image"]["name"];
			$type = $_FILES["image"]["type"];
			$size = $_FILES["image"]["size"];
			$tmp_name = $_FILES["image"]["tmp_name"];
			move_uploaded_file($_FILES["image"]["tmp_name"], $image);
			echo "<img src='$image'><br>";
			echo "Image type: $type<br>";
			echo "Image size: $size<br>";
			
			$textn = $_FILES["text"]["name"];
			$textt = $_FILES["text"]["tmp_name"];
			move_uploaded_file($_FILES["textn"]["tmp_name"], $textn);
			
			$toread = fopen($textt, 'r');
			$content = fread($toread, 10);
			echo "File content: ".$content;
			fclose($toread);
			
			
			/*
			$handle = fopen($textt, "r");
			$contents = '';
			if ($handle) {
				while (!feof($handle)) {
					$contents .= fread($handle, 10);
					echo $contents;
					exit;
				}
				fclose($handle);
			}
			*/
		?>
	</body>
	
</html>