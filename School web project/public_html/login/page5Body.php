
<i>Test SQL injection below:</i> <br><br>

<form method="POST" action="<?php $_SERVER['PHP_SELF']; ?>">
    Username: <input type="text" name="username">
    Password <input type="password" name="password">
    <button type="submit">Submit</button>
</form>

<br><b>String below are prevented from SQL injection:</b><br><br>

' OR '1'='1<br>
' OR '1'='1' -- <br>
' OR '1'='1' ({ <br>
' OR '1'='1' /* <br>


<?php

if ( isset($_POST['username']) and isset($_POST['password']))
{
    include("../../PRIVATE_HTML/config.php");

    $u = $_POST['username'];
    $p = $_POST['password'];

    //prevent sql injection
    $u = str_replace('=','',$u); 
    $u = str_replace('\'','',$u);
    $u = str_replace('\"','',$u);
    $p = str_replace('=','',$p); 
    $p = str_replace('\'','',$p);
    $p = str_replace('\"','',$p);

 
// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);

// Check connection
if (!$conn) 
    die("Connection failed: " . mysqli_connect_error());

    $ret=mysqli_query($conn, "SELECT * 
    FROM secret
    WHERE username='$u' 
    AND password='$p' ") 
    or die("Could not execute query: " .mysqli_error($conn));


    $row = mysqli_fetch_assoc($ret);
	if(!$row) {
			echo "<h1 style = 'color: red' >no</h1>";
		}
		else {
            echo "<h1 style = 'color: red' >yes</h1>";
	       
	}
}

?>

</body>
</html>







