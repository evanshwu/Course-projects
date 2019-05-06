<?php
	function result(&$scorevar){
		$scorevar = (int)$score;
		if($score <= 100 && $score >= 91) {
			return"$scorevar Perfect";
		}else if($score <= 90 && $score >=81) {
			return"Good";
		}else if($score <= 80 && $score >=60) {
			return"Soso";
		}else if($score <= 59 && $score >=0) {
			return"Fail";
		}else{
			return"Score is out of 100 ~ 0";
		}
	}
  result(95);
  result(40);
  result(85);
  result(65);

?>
