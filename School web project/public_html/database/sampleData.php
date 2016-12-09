<?php

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$sql = "INSERT INTO SECRET (id, username, password)
VALUES ('1', 'admin', 'a');";
$sql .= "INSERT INTO SECRET (id, username, password)
VALUES ('2', 'joe', '123');";

if (mysqli_multi_query($conn, $sql)) {
    echo "New records created successfully<br>";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>