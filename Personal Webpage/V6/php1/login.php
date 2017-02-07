<?php
session_start();


if($_GET['username'] == 'admin' && $_GET['password'] == 'a')
{
    $_SESSION["type"] = "ADMIN";
    header("Location: success.php");
}


else if ($_GET['username'] == 'joe' && $_GET['password'] == '123')
{

    $_SESSION["type"] = "USER";
    header("Location: success.php");
}


else
{
    header("Location: failed.php");
}

header("Location: success.php");
