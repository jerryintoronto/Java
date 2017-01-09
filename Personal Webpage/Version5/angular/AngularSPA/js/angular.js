var app = angular.module('myApp', ['ngRoute', 'ngAnimate', 'ngSanitize', 'ui.bootstrap', 'ngTouch', 'ui.grid']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/home', {
            templateUrl: 'home.html',
            controller: 'homeController'
        })
        .when('/page1-1', {
            templateUrl: 'pages/page1.html',
            controller: 'page1Controller'
        })
        .when('/page1-2', {
            templateUrl: 'pages/page1-2.html',
            controller: 'page1-2Controller'
        })
        .when('/page1-3', {
            templateUrl: 'pages/page1-3.html',
            controller: 'page1-3Controller'
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
});

app.controller('menuController', function($scope) {
    $scope.a = "#/home";
    $scope.aName = "Home";
    $scope.b = "#/page1-1";
    $scope.bName = "Page 1";
    $scope.ba = "#/page1-2";
    $scope.baName = "Page 1-2";
    $scope.bb = "#/page1-3";
    $scope.bbName = "Page 1-3";
    $scope.c = "#/page2";
    $scope.cName = "Page 2";
    $scope.d = "#/page3";
    $scope.dName= "Page 3";
})

//    home
app.controller('homeController', function ($scope) {
    $scope.name = 'Home';
    $scope.today = function () {
        $scope.dt = new Date();
    };
    $scope.today();
    $scope.mytime = new Date();

});

//page 1
app.controller('page1Controller', function ($scope, events) {
    $scope.name = 'page1-1';
    $scope.show = false;
    $scope.showcheckbox = true;
    $scope.size = 'col-sm-offset-2';
    events.success(function (data1) {
        $scope.content = data1;
        $scope.buttonText = 'show source';
    });

    $scope.showText = function () {
        $scope.show = !$scope.show;
        if ($scope.buttonText == 'show source')
            $scope.buttonText = 'hide';
        else
            $scope.buttonText = 'show source';
    };

    $scope.showCharts = function () {

        $scope.showcheckbox = false;
        $scope.size = 'col-sm-4';
        new Chart(document.getElementById('myChart').getContext('2d'), {
            type: 'line',
            data: {
                labels: ['1', '2', '3'],
                datasets: [{
                    label: 'oranges',
                    data: [123, 231, 311],
                    backgroundColor: "rgba(255,153,0,0.4)"
                }]
            }
        });

        new Chart(document.getElementById('myChart2').getContext('2d'), {
            type: 'bar',
            data: {
                labels: ['1', '2', '3'],
                datasets: [{
                    label: 'oranges',
                    data: [123, 231, 311],
                    backgroundColor: "rgba(255,153,0,0.4)"
                }]
            }
        });
    };
});


//    1-2
app.controller('page1-2Controller', function ($scope, events2) {
    $scope.name = 'page1-2';
    events2.success(function (data2) {
        $scope.content = data2;
        $scope.sourceDescription = "json data is hosted by https://jsonplaceholder.typicode.com/posts ";
        $scope.buttonText = 'show source';
    });

    $scope.showText = function () {
        $scope.show = !$scope.show;
        if ($scope.buttonText == 'show source')
            $scope.buttonText = 'hide';
        else
            $scope.buttonText = 'show source';
    }


    new Chart(document.getElementById('page1-2chart').getContext('2d'), {
        type: 'radar',
        data: {
            labels: ['1', '2', '3'],
            datasets: [{
                label: 'oranges',
                data: [123, 231, 311],
                backgroundColor: "rgba(255,153,0,0.4)"
            }]
        }
    });

    new Chart(document.getElementById('page1-2chart2').getContext('2d'), {
        type: 'polarArea',
        data: {
            labels: ['1', '2', '3'],
            datasets: [{
                label: 'oranges',
                data: [123, 131, 311],
                backgroundColor: "rgba(155,153,111,0.4)"
            }]
        }
    });
});

//    1-3
app.controller('page1-3Controller', function ($scope, events3) {
    $scope.name = 'page1-3';
    events3.success(function (data3) {
        $scope.content = data3;
        $scope.sourceDescription = "json data is hosted by https://jsonplaceholder.typicode.com/comments ";
        $scope.buttonText = 'show source';
    });

    $scope.showText = function () {
        $scope.show = !$scope.show;
        if ($scope.buttonText == 'show source')
            $scope.buttonText = 'hide';
        else
            $scope.buttonText = 'show source';
    }
});
//page 2
app.controller('page2Controller', function ($scope) {
    $scope.name = 'page2';
    $scope.size = 'col-sm-6';
    $scope.items = ['Item 1', 'Item 2', 'Item 3'];
    $scope.data1 = {};

    $scope.addItem = function () {
        var newItemNo = $scope.items.length + 1;
        $scope.items.push('Item ' + newItemNo);
    };


    $scope.master = {};

    $scope.update = function (user) {
        $scope.master = angular.copy(user);
    };
    $scope.send1 = function () {
        $scope.data1 = angular.copy(JSON.stringify($scope.items.length));
    }

    $scope.style = function(x)
    {
        if (x == 's')
            $scope.size = 'col-sm-2';
        else if (x=='m')
            $scope.size = 'col-sm-6';
        else
            $scope.size = 'col-sm-12';
    }
});

//  page 3
app.controller('page3Controller', function ($scope) {
    $scope.name = 'page3';


    $scope.face1text = "You can do it! You are number 1!";
    $scope.face2text = "You rolled a 2!";
    $scope.face3text = "Hello! Its a 3!";
    $scope.face4text = "Almost there! It won't take 4-ever!";
    $scope.face5text = "Its a 5!";
    $scope.face6text = "Its a 6!";
    $scope.face7text = "100 more rolls!";
    $scope.a = $scope.b = $scope.c = $scope.d = $scope.e = $scope.f = 0;
    $scope.face7 = false;
    $scope.count = 0;
    //random button
    $scope.random = function (showText) {
        var num = getRandomInt(1, 6);
        $scope.face1 = $scope.face2 = $scope.face3 = $scope.face4 = $scope.face5 = $scope.face6 = $scope.face7 = false;
        switch (num) {
            case 1:
                $scope.face1 = true;
                $scope.a++;
                break;
            case 2:
                $scope.face2 = true;
                $scope.b++;
                break;
            case 3:
                $scope.face3 = true;
                $scope.c++;
                break;
            case 4:
                $scope.face4 = true;
                $scope.d++;
                break;
            case 5:
                $scope.face5 = true;
                $scope.e++;
                break;
            case 6:
                $scope.face6 = true;
                $scope.f++;
        }
        if (!showText) {
            $scope.face1 = $scope.face2 = $scope.face3 = $scope.face4 = $scope.face5 = $scope.face6 = false;
            $scope.face7 = true;
        }
        else
            updatechart();
        $scope.count++;
        function getRandomInt(min, max) {
            return Math.floor(Math.random() * (max - min + 1)) + min;
        }
    }; //end random();
    //random x 100 button
    $scope.random100 = function () {
        for (i = 0; i < 100; i++)
            $scope.random();
        updatechart();
    };
//                chart

    function updatechart() {
        new Chart(document.getElementById('myChartpage3').getContext('2d'), {
            type: 'line',
            data: {
                labels: ['1', '2', '3', '4', '5', '6'],
                datasets: [{
                    label: 'oranges',
                    data: [$scope.a, $scope.b, $scope.c, $scope.d, $scope.e, $scope.f],
                    backgroundColor: "rgba(155,153,0,0.4)"
                }]
            }
        });
    }
});


app.factory("events", ['$http', function ($http) {
    return $http.get("https://raw.githubusercontent.com/weiyikong/fun/master/courses.json")
        .success(function (data1) {
            return data1;
        })
        .error(function (err) {
            return err;
        })
}]);

app.factory("events2", ['$http', function ($http) {
    return $http.get('https://jsonplaceholder.typicode.com/posts')
        .success(function (data2) {
            return data2;
        })
}])


app.factory("events3", ['$http', function ($http) {
    return $http.get('https://jsonplaceholder.typicode.com/comments')
        .success(function (data3) {
            return data3;
        })
}])