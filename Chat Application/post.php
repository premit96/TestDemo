<?php


include('conf.php');


function getIp() {
	$remote = $_SERVER["REMOTE_ADDR"];
	$remote = ip2long($remote);
	return $remote;
}


function getDateTime() {
	$nowTime = date("Y-m-d H:i:s");
	return $nowTime;
}


$username = isset($_POST['username']);
$message = isset($_POST['message']);
if ( ($username && $message) ) {
	
	$username = $_POST['username'];
	$message = $_POST['message'];
	
	
	$nowTime = getDateTime();
	$userIp = getIp();
	$sql = "INSERT INFO shoutbox (id,username, message,date,ip) VALUES ('', '$username', '$message', '$nowTime', '$userIp');
	$result = mysqli_query($connection, $sql);
	
	
if($result){
			echo " Data Inserted Successfully";
} else {
	echo " Data insert failed - ".mysqli_error($connection);
	}
  else {
	echo " Required fields are missing";
}


mysqli_close($connection);


?>


}