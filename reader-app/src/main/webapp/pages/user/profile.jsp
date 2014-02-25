<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
#profile {
	width: 700px;
	margin: 16px auto;
}

#profileForm {
	
}

h1,h2,h3 {
	margin: 0;
	padding: 0;
}

#editbtn {
	float: right;
	background: rgb(95, 95, 95);
	border: 1px solid white;
	padding: 4px 13px;
	font-size: 16px;
	color: white;
}
</style>
<%
	Long userid = (Long) session.getAttribute("id");
	String id = String.valueOf(userid);
%>
<div id="profile" ng-controller="profileCtrl"
	ng-init="getuser('<%=id%>')">

	<button id="editbtn" ng-href="#"
		ng-click="edit=!edit;changeValue();getuser('<%=id%>');">{{editbtn}}</button>

	<form name="profileForm" id="profileForm" ng-hide="edit"
		ng-init="edit=true">
		<h3>Edit User Details</h3>
		<table width="400px">
			<tr>
				<td>First Name</td>
				<td><input type="text" ng-model="user.firstName" required /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" ng-model="user.lastName" required /></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" ng-model="user.username"
					ng-disabled="true" required /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" ng-model="user.passowrd" required /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><textarea type="text" ng-model="user.address" required></textarea></td>
			</tr>
			<tr>
				<td>User Type</td>
				<td><input type="text" ng-model="user.userType"
					ng-disabled="true" required /></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="primarybtn"
					ng-click="edit=!edit;changeValue();saveUser();" type="submit"
					value="Submit" ng-disabled="profileForm.$invalid || isUnchanged(user)" /></td>
			</tr>
		</table>
		<br />
		<hr>
		<br />
	</form>

	<h3>User Details</h3>
	<table width="400px">
		<tr>
			<td>First Name</td>
			<td><span>{{user.firstName}} </span></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><span>{{user.lastName}} </span></td>
		</tr>
		<tr>
			<td>Username</td>
			<td><span>{{user.username}} </span></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><span>{{user.address}} </span></td>
		</tr>
		<tr>
			<td>User Type</td>
			<td><span>{{user.userType}} </span></td>
		</tr>
	</table>


</div>

