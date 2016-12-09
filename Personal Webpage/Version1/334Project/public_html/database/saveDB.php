
<?php
//Private Directory Usage!!!
//Dynamically create the config.php that stores authentication information for the website (must be placed into private_html)
$myfile = fopen("../../private_html/config.php", "w");
fwrite($myfile, '<?php' . "\n");
fwrite($myfile, '//Description: The purpose of this php file is to store all configuration options that for the database.'. "\n");
fwrite($myfile, "\$servername = '". $servername . "';\n");
fwrite($myfile, "\$username = '". $username . "';\n");
fwrite($myfile, "\$password = '". $password . "';\n");
fwrite($myfile, "\$dbname = '". $dbname . "';\n");
fwrite($myfile, '?>');
fclose($myfile);

?>