<?php


$dbhost = "localhost";
$dbuser = "root";
$dbpass = "";
$dbname = "chatApp";



$connection = mysqli_connect("$dbhost" , "$dbuser" , "$dbpass", "$dbname");
$db = mysqli_select_db($connection, $dbname);

?>