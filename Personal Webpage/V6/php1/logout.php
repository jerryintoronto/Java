<?php
/**
 * Created by PhpStorm.
 * User: J
 * Date: 2/4/2017
 * Time: 9:27 PM
 */
session_start();
session_destroy();
header('Location: index.php');