<?php

include("homepage/style.html");
include("homepage/loginForm.html");
include("homepage/javascript.html");


$_SESSION["type"] = "EXIT";
//set "type" to EXIT from "user" or "admin"
//once logged out, can't back.

?>

</body>
</html>

