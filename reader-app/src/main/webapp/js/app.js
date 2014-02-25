var readerApp = angular.module('readerApp',
		[ 'ngRoute', 'readerAppControllers' ]);

readerApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/profile', {
		templateUrl : 'pages/user/profile.jsp',
		controller : 'profileCtrl'
	}).when('/home', {
		templateUrl : 'pages/welcome.jsp',
		controller : 'profileCtrl'
	}).when('/users', {
		templateUrl : 'pages/user/listuser.jsp',
		controller : 'profileCtrl'
	})/*
		 * .otherwise({ redirectTo : '/user.action' })
		 */;
	;
} ]);