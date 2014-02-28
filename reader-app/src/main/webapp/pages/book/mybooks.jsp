<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
#books {
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
	whitespace: nowrap;
}

th {
	font-weight: bold;
}
</style>
<%
	Long userid = (Long) session.getAttribute("id");
	String id = String.valueOf(userid);
%>
<div ng-controller="profileCtrl">
	<div id="books" ng-controller="bookCtrl as b"
		ng-init="getUserBooks('<%=id%>')">
		<table>
			<tr>
				<th><a href ng-click="predicate = 'id'; reverse=!reverse">Book
						Id</a></th>
				<th><a href ng-click="predicate = 'bookName'; reverse=!reverse">Book
						Name</a></th>
				<th><a href
					ng-click="predicate = 'bookAuthor'; reverse=!reverse">Book
						Author</a></th>
				<th><a href ng-click="predicate = 'rating'; reverse=!reverse">Rating</a></th>
				<th><a href ng-click="predicate = 'addedBy'; reverse=!reverse">Added
						By</a></th>
				<th><a href ng-click="predicate = 'bookLink'; reverse=!reverse">File
						Name</a></th>
				<th width="100px">File Action</th>
			</tr>
			<tr ng-repeat="book in books | orderBy:predicate:reverse">
				<td>{{book.id}}</td>
				<td>{{book.bookName}}</td>
				<td>{{book.bookAuthor}}</td>
				<td>{{book.rating | number}}/5</td>
				<td>{{book.addedBy}}</td>
				<td>{{book.bookLink}}</td>
				<td><a href="#/book/edit/{{book.id}}">Update</a> | <a
					href="#/book/view/{{book.id}}">Read</a></td>

			</tr>
		</table>
	</div>
</div>
