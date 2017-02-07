<!doctype html>
<html ng-app="myApp" xmlns="http://www.w3.org/1999/html">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">


    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular-route.min.js"></script>

</head>

<body>



<!--constant header-->
<div class="main">

    <nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="#/home">Home</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item ">
                    <a class="nav-link" href="#/page1">North America</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#/page2">Europe</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#/page3">Korea</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#/page4">Brazil</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Github</button>
            </form>
        </div>
    </nav>



    <!--main content placeholder-->
    <div ng-view></div>
</div>


<!--angular logic-->
<script>

    var app = angular.module('myApp', ['ngRoute']);

    app.config(function ($routeProvider) {
        $routeProvider

            .when('/home', {
                templateUrl: 'home.php'
            })
            .when('/page1', {
                templateUrl: 'page1.php'
            })
            .when('/page2', {
                templateUrl: 'page2.php'
            })
            .when('/page3', {
                templateUrl: 'page3.php'
            })
            .when('/page4', {
                templateUrl: 'page4.php'
            })
            .otherwise({redirectTo: '/home'});
    });

</script>
</body>
</html>