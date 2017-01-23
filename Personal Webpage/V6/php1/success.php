<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body>

    Login Successful as
    <?php

    session_start();
    echo $_SESSION["type"];
    //user or admin at top left corner
    ?>

    <br>

    <a href="showall.php">Show all in database</a>


</body>
</html>