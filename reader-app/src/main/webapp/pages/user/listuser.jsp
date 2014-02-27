<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
#users {
	width: 700px;
	margin: 16px auto;
}

table {
	border-collapse: collapse;
	width: 700px;;
}

th,td {
	border: 1px solid gray;
	padding: 5px;
	text-align: center;
}

th {
	font-weight: bold;
}
</style>
<%
	Long userid = (Long) session.getAttribute("id");
	String id = String.valueOf(userid);
%>
<div id="users" ng-controller="profileCtrl" ng-init="getUsers()">
	Search User: <input type="text" ng-model="queryUser" /><br />
	<table>
		<tr>
			<th><a href ng-click="predicate = 'id'; reverse=!reverse">User
					Id</a></th>
			<th><a href ng-click="predicate = 'firstName'; reverse=!reverse">First
					Name</a></th>
			<th><a href ng-click="predicate = 'lastName'; reverse=!reverse">Last
					Name</a></th>
			<th><a href ng-click="predicate = 'username'; reverse=!reverse">Username</a></th>
			<th><a href ng-click="predicate = 'userType'; reverse=!reverse">User
					Type</a></th>
			<th><a href ng-click="predicate = 'address'; reverse=!reverse">Address</a></th>
		</tr>
		<tr
			ng-repeat="user in users | filter:queryUser | orderBy:predicate:reverse">
			<td>{{user.id}}</td>
			<td>{{user.firstName}}</td>
			<td>{{user.lastName}}</td>
			<td>{{user.username}}</td>
			<td>{{user.userType}}</td>
			<td>{{user.address}}</td>
		</tr>
	</table>

</div>