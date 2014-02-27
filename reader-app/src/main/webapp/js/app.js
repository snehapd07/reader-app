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
	}).when('/books', {
		templateUrl : 'pages/book/listbook.jsp',
		controller : 'bookCtrl'
	}).when('/mybooks', {
		templateUrl : 'pages/book/mybooks.jsp',
		controller : 'bookCtrl'
	}).when('/book/edit/:bookId', {
		templateUrl : 'pages/book/managebook.jsp',
		controller : 'bookCtrl'
	}).when('/book/view/:bookId', {
		templateUrl : 'pages/book/viewbook.jsp',
		controller : 'bookCtrl'
	}).when('/book/upload', {
		templateUrl : 'pages/book/uploadbook.jsp',
		controller : 'bookCtrl'
	}).when('/logout', {
		templateUrl : 'pages/logout.jsp',
		controller : 'bookCtrl'
	})/*
		 * .otherwise({ redirectTo : '/home' })
		 */;
} ]);