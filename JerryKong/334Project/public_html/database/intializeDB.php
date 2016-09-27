<?php


	// create an array that will store the database schema and all sample data
	$dbinfo = array();

	//Create and Check connection
	include("createDB.php");
	//set up SQL tables
	include("createTables.php");
	//set up sample data
	include("sampleData.php");


?>