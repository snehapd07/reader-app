<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" ng-app="readerApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reader App</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular-route.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular-sanitize.min.js""></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular-cookies.js">
	
</script>

<!-- <script -->
<!-- 	src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/components/enc-base64-min.js"></script> -->
<script type="text/javascript" src="./js/app.js"></script>
<script type="text/javascript" src="./js/directives.js"></script>
<script type="text/javascript" src="./js/service.js"></script>
<script type="text/javascript" src="./js/controllers.js"></script>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

#header {
	width: 100%;
	height: 50px;
	text-align: center;
	margin: 0;
	padding: 0;
	color: white;
	background: black;
	font-size: 40px;
}

#middle {
	width: 90%;
	margin: 0 auto;
}

#menu {
	width: 700px;
	padding: 5px;
	background: rgb(214, 214, 214);
	margin: 0 auto;
}

#menu a {
	color: black;
	text-decoration: none;
}

.primarybtn {
	background: rgb(102, 15, 15);
	border: 1px solid white;
	padding: 4px 13px;
	font-size: 16px;
	color: white;
}

.css-form input.ng-invalid.ng-dirty {
	border: 1px solid #FA787E;
}

.css-form textarea.ng-invalid.ng-dirty {
	border: 1px solid #FA787E;
}

.css-form input.ng-valid.ng-dirty {
	border: 1px solid #78FA89;
}

.css-form textarea.ng-valid.ng-dirty {
	border: 1px solid #78FA89;
}
</style>
</head>

<body>
	<div id="header">Reader App</div>
	<div id="menu">
		<a href="#/home">Home Page</a> | <a href="#/profile">Profile</a> | <a
			href="#/users">View All Users</a> | <a href="#/books">View All
			Books</a> | <a href="#/mybooks">My Read Books</a> | <a
			href="#/book/upload">Upload New Book</a>|<a href="#/logout">
			Logout</a>

	</div>
	<div id="middle">