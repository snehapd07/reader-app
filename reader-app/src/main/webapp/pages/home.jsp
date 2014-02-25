<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="./header.jsp"%>

<!-- 	<div ng-controller="userCtrl"> -->
<!-- 		<ul> -->
<!-- 			<li ng-repeat="user in users"> -->
<!-- 			       {{user.username}} -->
<!-- 				<p>{{user.address}}</p> -->
<!-- 			</li> -->
<!-- 		</ul> -->
<!-- 	</div> -->
<%
	String username = (String) request.getAttribute("username");
	Long userId = (Long) request.getAttribute("id");
	session.setAttribute("username", username);
	session.setAttribute("id", userId);
%>

<div ng-view></div>
<span ng-show="isViewLoading"> loading the view... <span>


<%@ include file="./footer.jsp"%>