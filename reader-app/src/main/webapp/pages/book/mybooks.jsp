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
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Book Author</th>
				<th>Rating</th>
				<th>Added By</th>
				<th>File Name</th>
				<th style="width: 100px">File Actions</th>
			</tr>
			<tr ng-repeat="book in books">
				<td>{{book.id}}</td>
				<td>{{book.bookName}}</td>
				<td>{{book.bookAuthor}}</td>
				<td>{{book.rating}}</td>
				<td>{{book.addedBy}}</td>
				<td>{{book.bookLink}}</td>
				<td><a href="#/book/edit/{{book.id}}">Edit</a> | <a
					href="#/book/view/{{book.id}}">View</a></td>

			</tr>
		</table>
	</div>
</div>
