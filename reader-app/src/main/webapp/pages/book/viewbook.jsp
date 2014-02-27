<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
#book {
	width: 60%;
	margin: 0px auto;
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
<div id="book" ng-controller="bookCtrl as b"
	ng-init="getBook();getBookLink();">
	<br />
	<h3>
		Book Name : {{book.bookName}} <br /> Book Author: {{book.bookAuthor}}
	</h3>



	<div id="activity" ng-controller="activitiCtrl as a"
		ng-init="getStatusOptions();">

		<a href ng-click="getActiviti(<%=id%>,book.id);edit=!edit;">Change
			Book Status</a>

		<form name="statusForm" style="display: inline;" ng-hide="edit"
			ng-init="edit=true">
			<select ng-model="activiti.status"
				style="padding: 0; border: 1px solid rgb(233, 218, 218); border-radius: 5px; background: rgb(204, 204, 204);"
				ng-change="addActiviti(<%=id%>,book.id);"
				ng-options="s for s in statusoptions">
				<option value="">-- choose color --</option>
			</select> <input type="hidden" ng-model="activiti.userId" required /> <input
				type="hidden" ng-model="activiti.bookId" required /> <br />
		</form>


	</div>
	<br />
	<iframe ng-src="{{trustSrc(bookLink)}}" width="990px" height="900px"
		style=""></iframe>
	<br />
</div>