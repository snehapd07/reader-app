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
	<table>
		<tr>
			<th>User Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Username</th>
			<th>User Type</th>
			<th>Address</th>
		</tr>
		<tr ng-repeat="user in users">
			<td>{{user.id}}</td>
			<td>{{user.firstName}}</td>
			<td>{{user.lastName}}</td>
			<td>{{user.username}}</td>
			<td>{{user.userType}}</td>
			<td>{{user.address}}</td>
		</tr>
	</table>

</div>