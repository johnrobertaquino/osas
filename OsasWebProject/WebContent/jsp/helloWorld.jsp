<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OSAS</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
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
			<a href="javascript:void(0);">Change Password</a>
		</div>
	</div>
</div>
<div id="contentBody">
	<div id="loginDiv">
		<div id="loginContent">
			<form class="contentForm">
				<div class="loginElement">
					<span>Username:</span><input type="text">
				</div>
				<div class="loginElement">
					<span>Password:</span><input type="password">
				</div>
				<div class="loginElement">
					<div id="loginButtonDiv">LOGIN</div>
					<div style="clear:both"></div>
				</div>
				<div style="clear:both"></div>
			</form>
		</div>
	</div>
</div>
<div id="footer">
	<div id="headerSeparatorDiv"></div>
</div>
</body>
</html>