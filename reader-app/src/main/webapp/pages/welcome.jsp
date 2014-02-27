<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<style>
#home {
	width: 700px;
	margin: 0 auto;
}
</style>
<%
	String username = (String) session.getAttribute("username");
	String password = (String) session.getAttribute("password");

%>

<div ng-controller="profileCtrl" id="home"
	ng-init="setAuth('<%=username%>','<%=password%>');">
	<h1>
		Hey, <i> <%
 	out.println(session.getAttribute("username"));
 %></i> <br />Welcome to App Reader !!!
	</h1>
</div>




