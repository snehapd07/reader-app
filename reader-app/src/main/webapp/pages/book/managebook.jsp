<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
#book {
	width: 700px;
	margin: 16px auto;
}

#bookForm {
	
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
<div id="book" ng-controller="bookCtrl" ng-init="getBook()">

	<button id="editbtn" ng-href="#"
		ng-click="edit=!edit;changeValue();getBook();">{{editbtn}}</button>

	<form name="bookForm" id="bookForm" class="css-form" ng-hide="edit" ng-init="edit=true">
		<h3>Edit Book Details</h3>
		<table width="400px">
			<tr>
				<td>Book Name</td>
				<td><input type="text" ng-model="book.bookName" required /></td>
			</tr>
			<tr>
				<td>Author Name</td>
				<td><input type="text" ng-model="book.bookAuthor" required /></td>
			</tr>
			<tr>
				<td>Rating</td>
				<td><input type="text" ng-model="book.rating"
					ng-disabled="true" required /></td>
			</tr>
			<tr>
				<td>Added By</td>
				<td><input type="text" ng-model="book.addedBy"
					ng-disabled="true" required /></td>
			</tr>
			<tr>
				<td>File Name</td>
				<td><input type="text" ng-model="book.bookLink"
					ng-disabled="true" required /></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="primarybtn"
					ng-click="edit=!edit;changeValue();saveBook();getBook();"
					type="submit" value="Submit"
					ng-disabled="bookForm.$invalid || isUnchanged(book)" /></td>
			</tr>
		</table>
		<br />
		<hr>
		<br />
	</form>

	<h3>book Details</h3>
	<table width="400px">
		<tr>
			<td>Book Name</td>
			<td><span>{{book.bookName}} </span></td>
		</tr>
		<tr>
			<td>Author Name</td>
			<td><span>{{book.bookAuthor}} </span></td>
		</tr>
		<tr>
			<td>Rating</td>
			<td><span>{{book.rating}} </span></td>
		</tr>
		<tr>
			<td>Added By</td>
			<td><span>{{book.addedBy}} </span></td>
		</tr>
		<tr>
			<td>File Name</td>
			<td><span>{{book.bookLink}} </span></td>
		</tr>
	</table>


</div>

