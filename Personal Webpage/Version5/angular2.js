var app = angular.module('myApp', ['ngRoute']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/home', {
            templateUrl: 'home.html',
            controller: 'homeController'
        })
        .when('/page1', {
            templateUrl: 'page1.html',
            controller: 'page1Controller'
        })
        .when('/page2', {
            templateUrl: 'page2.html',
            controller: 'page2Controller'
        })
        .when('/page3', {
            templateUrl: 'page3.html',
            controller: 'page3Controller'
        })
        .otherwise({redirectTo: '/home'});

    // setup top bar and color theme
    setup();
});


app.controller('header', function($scope){

    $scope.a = function(){
        recursiveCall(1)
    };

    function recursiveCall(x) {
        if (x <= 10) {
            changeallfromtitle();
            setTimeout(function () {
                recursiveCall(++x)
            }, 50);
        }
    }
});

app.controller('homeController', function ($scope) {
    startanimation();
    setTimeout(changeallfromtitle, 300);

});

app.controller('page1Controller', function ($scope) {
    startanimation();
    setTimeout(changeallfromtitle, 300);
});

app.controller('page2Controller', function ($scope) {
    startanimation();
    setTimeout(changeallfromtitle, 300);
});

app.controller('page3Controller', function ($scope) {
    startanimation();
    setTimeout(changeallfromtitle, 300);
});
