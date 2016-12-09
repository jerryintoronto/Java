<?php

// Start the session
session_start();

if($_GET['uname'] == 'admin' && $_GET['psw'] == 'a')
{
    $_SESSION["type"] = "ADMIN";
    header("Location: ../login/home.php");
}


else if ($_GET['uname'] == 'joe' && $_GET['psw'] == '123')
{

    $_SESSION["type"] = "USER";
    header("Location: ../login/home.php");

}


else
{
    echo "<div style = 'text-align: center'><br><br><br>";
    echo "<h3 style = 'color: red'> Wrong username or password! </h3>";
    echo "<p><a href='../index.php'>Try Again</p>";
}


?>