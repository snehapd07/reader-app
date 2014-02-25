var readerAppControllers = angular.module('readerAppControllers', []);

readerAppControllers.controller('userListCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$http.get('http://localhost:9080/reader-apis/api/user/all')
					.success(function(data) {
						$scope.users = data.users;
					});
		} ]);

readerAppControllers.controller('profileCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.editbtn = "Edit";
			$scope.user = "";
			$scope.getuser = function(id) {
				$http.get('http://localhost:9080/reader-apis/api/user/' + id)
						.success(function(data) {
							$scope.user = data;
						});
			};

			$scope.changeValue = function() {
				if ($scope.editbtn == "Edit")
					$scope.editbtn = "X";
				else if ($scope.editbtn == "X")
					$scope.editbtn = "Edit";
			};

			$scope.saveUser = function() {
				$http.post('http://localhost:9080/reader-apis/api/user/add/',
						$scope.user).success(function(data) {
					$scope.user = data;
				});
			};

			$scope.getUsers = function() {
				$http.get('http://localhost:9080/reader-apis/api/user/all')
						.success(function(data) {
							$scope.users = data.users;
						});
			};

			// $scope.profile(1);

		} ]);
