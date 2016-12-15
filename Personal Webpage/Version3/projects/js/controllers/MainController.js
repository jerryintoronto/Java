app.controller('MainController', ['$scope', function($scope) {

  $scope.apps = [
  {
    icon: 'img/tutorial.JPG',
    title: 'Basic Tutorials',
    lang: 'Java, C, MASM',
      url : 'https://github.com/weiyikong/Projects/tree/master/Basic%20Tutorials',
    date: '2016'
  },
  {
    icon: 'img/coding.JPG',
    title: 'Coding Problems',
    lang: 'Java',
      url : 'https://github.com/weiyikong/Projects/tree/master/Coding%20Problems',
    date: '2016'
  },
    {
    icon: 'img/drawingchat.PNG',
    title: 'Drawing and Chat',
    lang: 'Java',
        url : 'https://github.com/weiyikong/Projects/tree/master/Java%20Drawing%20and%20Chat',
    date: '2016'
  },
    {
    icon: 'img/personweb.JPG',
    title: 'Person WebPage',
    lang: 'jQuery, Angular.JS',
        url : 'https://github.com/weiyikong/Projects/tree/master/Personal%20Webpage',
    date:'2016'
  } ,
    {
    icon: 'img/recursion.PNG',
    title: 'Recursion GUI Tracing',
    lang: 'Java',
        url : 'https://github.com/weiyikong/Projects/tree/master/Recursion%20GUI%20Tracing%20in%20Java',
    date: '2016'
  },
    {
    icon: 'img/schoolweb.JPG',
    title: 'Web Project',
    lang: 'Php',
        url : 'https://github.com/weiyikong/Projects/tree/master/School%20web%20project',
    date: '2016'
  }
  ];
}]);
