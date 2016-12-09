<!DOCTYPE html>
<html lang="en">
<head>
  <title>Jerry Kong 334</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <?php

  session_start(); 
  if ($_SESSION["type"] == "EXIT")
    header("Location: ../index.php"); //redirect to home page not logged in! 

?>

</head>
<body>


<!-- Menu Bar -->

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="home.php">

      <?php 
           echo $_SESSION["type"]; 
          //user or admin at top left corner
      ?>
      </a>   
    </div>
    <ul class="nav navbar-nav">
    
      <li><a href="page1.php">AJAX</a></li>
      <li><a href="page2.php">XML/XSLT</a></li>
      <li><a href="page3.php">Javascript</a></li>
      <li><a href="page4.php">HTML Injection</a></li>
      <li><a href="page5.php">SQL Injection</a></li>
      <li><a href="page6.php">Page Modification</a></li>
      <li><a href="page7.php">Extra</a></li>
      