var readerAppControllers = angular.module('readerAppControllers', [
		'ngSanitize', 'readerDirectives', 'readerService' ]);

readerAppControllers
		.controller(
				'activitiCtrl',
				[
						'$scope',
						'$http',
						'$timeout',
						function($scope, $http, $timeout) {

							$scope.addActiviti = function(userId, bookId) {
								$scope.activiti.userId = userId;
								$scope.activiti.bookId = bookId;
								$http
										.post(
												'http://localhost:9080/reader-apis/api/activiti/add',
												$scope.activiti).success(
												function(data) {
													$scope.activiti = data;
												});
							};

							$scope.getStatusOptions = function() {
								$http
										.get(
												'http://localhost:9080/reader-apis/api/activiti/statusoptions')
										.success(function(data) {
											$scope.statusoptions = data;
										});
							};
							$scope.getActiviti = function(userId, bookId) {
								$http.get(
										'http://localhost:9080/reader-apis/api/activiti/'
												+ userId + '/' + bookId)
										.success(function(data) {
											$scope.activiti = data;
										});
							};

						} ]);

readerAppControllers.controller('profileCtrl', [
		'$scope',
		'$http',
		'Base64',
		'$window',
		function($scope, $http, Base64, $window) {
			$scope.editbtn = "Edit";
			$scope.username = "";
			$scope.userMapForBooks = {};

			$scope.setAuth = function(username, password) {
				$http.defaults.headers.common.Authentication = 'Basic '
						+ Base64.encode(username + ':' + password);
				$http.defaults.headers.common.Authorization = 'Basic '
						+ Base64.encode(username + ':' + password);
			};

			$scope.delAuth = function() {

				delete $http.defaults.headers.common.Authentication;
				delete $http.defaults.headers.common.Authorization;

				$http.get('http://localhost:9080/reader-apis/api/user/logout')
						.success(function(data) {
							console.log("logged out");
						});
				$window.location.href = './j_spring_security_logout';
			};

			$scope.getuser = function() {
				$http.get('http://localhost:9080/reader-apis/api/user/me')
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

readerAppControllers
		.controller(
				'bookCtrl',
				[
						'$scope',
						'$http',
						'$routeParams',
						'$fileUpload',
						'$location',
						'$sce',
						function($scope, $http, $routeParams, $fileUpload,
								$location, $sce) {
							$scope.editbtn = "Edit";
							$scope.bookId = $routeParams.bookId;
							$scope.downlodedFile = "";

							$scope.getBook = function() {
								$http.get(
										'http://localhost:9080/reader-apis/api/book/'
												+ $scope.bookId).success(
										function(data) {
											$scope.book = data;
										}).error(function(data) {
									alert("error" + data);
								});
							};
							$scope.trustSrc = function(src) {
								return $sce.trustAsResourceUrl(src);
							};

							$scope.getUserBooks = function(id) {
								$http.get(
										'http://localhost:9080/reader-apis/api/book/user/'
												+ id).success(function(data) {
									$scope.books = data;
								});
							};

							$scope.changeValue = function() {
								if ($scope.editbtn == "Edit")
									$scope.editbtn = "X";
								else if ($scope.editbtn == "X")
									$scope.editbtn = "Edit";
							};

							$scope.saveBook = function() {
								$http
										.post(
												'http://localhost:9080/reader-apis/api/book/add/',
												$scope.book).success(
												function(data) {
													$scope.book = data;
												});
							};

							$scope.uploadBook = function() {
								var file = $scope.file;
								console.log('file is ' + JSON.stringify(file));
								var uploadUrl = "http://localhost:9080/reader-apis/api/book/upload/";
								$fileUpload.uploadFileToUrl(file, uploadUrl,
										$scope.userId);
							};

							$scope.getBooks = function() {
								$http
										.get(
												'http://localhost:9080/reader-apis/api/book/all')
										.success(function(data) {
											$scope.books = data.books;
										});
							};

							$scope.getBookLink = function() {
								$scope.bookLink = "http://localhost:9080/reader-apis/api/book/download/"
										+ $scope.bookId;
							};

							$scope.initUploadForm = function(id) {
								$scope.userId = id;
							};

							$scope.getBooksByStatus = function(userId, status) {
								$http.get(
										'http://localhost:9080/reader-apis/api/book/'
												+ userId + '/' + status)
										.success(function(data) {
											$scope.books = data;
										});
							};
							// $scope.profile(1);

						} ]);
