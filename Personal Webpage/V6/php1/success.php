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

    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">



</head>
<body>

<div class ="container">
    <br>
    <br>

<!--    navbar-->
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




    <div class="row">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-block">
                    <h3 class="card-title">MYSQL add and delete</h3>
                    <p class="card-text">Add and delete number pairs via mysql</p>
                    <a href="showall.php" class="btn btn-primary">Go </a>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="card">
                <div class="card-block">
                    <h3 class="card-title">??</h3>
                    <p class="card-text">??</p>
                    <a href="#" class="btn btn-primary">Go</a>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-block">
                    <h3 class="card-title">??</h3>
                    <p class="card-text">??</p>
                    <a href="#" class="btn btn-primary">Go</a>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <div class="card">
                <div class="card-block">
                    <h3 class="card-title">??</h3>
                    <p class="card-text">??</p>
                    <a href="#" class="btn btn-primary">Go</a>
                </div>
            </div>
        </div>
    </div>




    <div class="row">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-block">
                    <h3 class="card-title">??</h3>
                    <p class="card-text">??</p>
                    <a href="#" class="btn btn-primary">Go</a>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <div class="card">
                <div class="card-block">
                    <h3 class="card-title">??</h3>
                    <p class="card-text">??</p>
                    <a href="#" class="btn btn-primary">Go</a>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-block">
                    <h3 class="card-title">??</h3>
                    <p class="card-text">??</p>
                    <a href="#" class="btn btn-primary">Go</a>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <div class="card">
                <div class="card-block">
                    <h3 class="card-title">??</h3>
                    <p class="card-text">??</p>
                    <a href="#" class="btn btn-primary">Go</a>
                </div>
            </div>
        </div>
    </div>




</div>

</body>
</html>

