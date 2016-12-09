<!DOCTYPE html>
<html lang="en">
<head>


<?php 

//display form 
include("form.php");

if (isset($_POST['submit'])) { // submit button pressed 

  //perform form validation 
  include("formValidation.php");
	
  //then intialize database
  include("intializeDB.php");

	//store database info to file
	include("saveDB.php");

	//output success message
	include("success.html");
} 

?>


<!-- start of footer -->
        <div class="well well-sm footer">

                </div>
            </div>
        </div>

    </div> <!-- /container -->

  </body>
</html>
 
