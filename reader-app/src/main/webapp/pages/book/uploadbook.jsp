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
<div id="book" ng-controller="bookCtrl"
	ng-init="initUploadForm('<%=id%>')">
	<h2>Upload New Book to store:</h2>
	<form name="uploadForm" id="uploadForm">
		<input type="file" file-model="file" name="file" required /> <br />
		<input type="hidden" ng-model="userId" name="userId" required /><br />
		<input ng-click="uploadBook();" type="submit" value="Submit"
			ng-disabled="uploadForm.$invalid" />
	</form>
</div>