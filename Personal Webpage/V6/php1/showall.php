<?php


session_start();

if ($_SESSION["type"] != 'ADMIN' && $_SESSION["type"] != 'USER')
    header("location: index.html");




?>

<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">


</head>
<body>




<br><br><br>
<div>

    <div class="container">



        <nav class="navbar navbar-toggleable-md navbar-light bg-faded">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                <a class="navbar-brand" href="success.php">Home</a>
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">

                    <li class="nav-item">
                        <a class="nav-link disabled" href="#"><?php echo $_SESSION['type'];?></a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" action="logout.php">

                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log out</button>
                </form>
            </div>
        </nav>


        <div class = "row">
            <div class="col">


                <?php

                include_once("config.php");

                // Create connection
                $conn = mysqli_connect($servername, $username, $password, $dbname) or die("Connection failed: " . mysqli_connect_error());;
                $sql = 'select * from test';

                $return = mysqli_query($conn, $sql) or die("Could not execute query: " .mysqli_error($conn));



                while ($row = mysqli_fetch_assoc($return))
                {
                    echo '<br>' . '| ' . $row['id'] . ' | ' .  $row['c1'] . ' , ' . $row['c2'];
                }


                ?>

            </div>


        </div>

        <div class="col">

        <hr>
            <form method = 'GET' action="add.php">
                <div class="form-group row">
                    <label for="example-number-input" class="col-2 col-form-label">Num1 </label>
                    <div class="col-10">
                        <input name = 'a' class="form-control" type="number"  id="example-number-input " required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="example-number-input" class="col-2 col-form-label">Num2 </label><br>
                    <div class="col-10">
                        <input name = 'b' class="form-control" type="number"  id="example-number-input" required/>
                    </div>
                </div>
                <button class = 'btn btn-active' type = 'submit'> Add </button>
            </form>

            <br>

            <form method = 'GET' action="remove.php">
                <div class="form-group row">
                    <label for="example-number-input" class="col-2 col-form-label">Row ID</label>
                    <div class="col-10">
                        <input name = 'id' class="form-control" type="number"  id="example-number-input" required>
                    </div>
                </div>
                <button class = 'btn' type = 'submit'> Remove </button>
            </form>


        </div>
</div>



<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>


</body>
</html>

