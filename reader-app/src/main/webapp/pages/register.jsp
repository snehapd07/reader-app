<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reader App</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular.min.js"></script>
<script>
	// define angular module/app
	var formApp = angular.module('formApp', []);

	// create angular controller and pass in $scope and $http
	function formController($scope, $http) {
		$scope.formData = {};
	}
</script>
</head>
<body ng-app="formApp" ng-controller="formController">
	<h1>Register</h1>

	<s:form action="./register.action" method="get" name="regForm">
		<s:textfield name="firstName" label="First Name" required="true" />
		<s:textfield name="lastName" label="Last Name" required="true" />
		<s:textfield name="username" label="User Name" required="true" />
		<s:password name="password" label="Password" required="true" />
		<s:textfield name="age" label="Age" required="true" />
		<s:textarea name="address" label="Address" required="true"></s:textarea>
		<input type="hidden" name=action value="save" required="true" />
		<s:submit />
	</s:form>
</body>