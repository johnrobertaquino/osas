<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OSAS</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
</head>
<body>
<div id="header">
	<div id="topHeaderDiv"></div>
	<div id="bannerTitleDiv">
		<div id="bannerTitleSubDiv">
			<div><span id="bannerTitleMain"><span>S</span>tudent <span>A</span>ffairs and <span>S</span>ervices <span>S</span>ystem</span></div>
			<div><span id="bannerTitleSub">Office of the Student Affairs and Services</span></div>
		</div>
		<div style="clear:both"></div>
	</div>
	<div id="logoDiv"><img alt="" src="images/PUPLogo.png"></div>
	<div style="clear:both"></div>
	<div id="headerSeparatorDiv">
		<div id="headerLinkDiv">
			<a href="javascript:void(0);">Change Password</a><s:if test="%{user.userTypeId == 1}"><a href="javascript:void(0);">Manage Users</a></s:if>
		</div>
	</div>
</div>
<div id="contentBody">
	${user.userName}
</div>
<div id="footer">
	<div id="headerSeparatorDiv"></div>
</div>
</body>
</html>