<?php

//Check to see if all fields have been input
	if (!isset($_POST['inputHOSTNAME']) || !isset($_POST['inputDBNAME']) || !isset($_POST['inputDBUSERNAME']) )
	die("<strong>Fatal Error:</strong> Missing Parameters! Please go back and try again");
	//Trim the input from the user (may cause problems with password matching and config.php generation)
	$servername = trim($_POST['inputHOSTNAME']);
	$dbname = trim($_POST['inputDBNAME']);
	$username = trim($_POST['inputDBUSERNAME']);
	$password = trim($_POST['inputDBPASSWORD']);

?>