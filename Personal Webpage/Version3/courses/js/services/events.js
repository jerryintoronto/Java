app.factory("events", ['$http', function($http) {
  return $http.get("https://raw.githubusercontent.com/weiyikong/fun/master/test.json")
  .success(function(data) {
    return data;
  })
  .error(function(err) {
    return err;
  });
}]);
