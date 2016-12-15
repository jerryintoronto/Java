app.directive('installApp', function() {
    return {
        restrict: 'E',
        scope: {
            info: '='
        },

        link: function(scope, element, attrs) {
            scope.buttonText = "See Source Code";
            } ,
        templateUrl: 'js/directives/installApp.html'
    };
});