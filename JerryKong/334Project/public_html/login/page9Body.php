


<h2> This page can only be seen by the admin. </h2>  
<br>Here are the username and passwords stored in the database:

<p>

<?php
include("../../PRIVATE_HTML/config.php");

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$sql = "SELECT id, username, password FROM SECRET";
$result = mysqli_query($conn, $sql);

if (mysqli_num_rows($result) > 0) {
    // output data of each row
    while($row = mysqli_fetch_assoc($result)) {
        echo "<li>id: " . $row["id"]. ", Username: " . $row["username"]. ", Password: " . $row["password"]. "<br></li>";
    }
} else {
    echo "0 results";
}

?>


</p>