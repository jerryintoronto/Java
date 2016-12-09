<?php
include("header.php");
include("rightBar.php");

//to prevent user from accessing page9.php
if($_SESSION["type"] != "ADMIN")
    header("Location: ../index.php");
?>

  
<div class="container">
    

        
    <?php
    include("page9Body.php");
    ?>   

    

  
</div>

</body>
</html>

