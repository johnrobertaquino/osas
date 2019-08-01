<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SASS</title>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="shortcut icon" type="image/png" href="images/PUPLogo.png" />
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/userList.js"></script>
</head>
<body>
<div id="header">
	<div id="headerHomeDiv">
		<div id="logoDiv"><img alt="" src="images/PUPLogo.png"></div>
		<div id="bannerTitleDiv">
			<div id="bannerTitleSubDiv">
				<div><span id="bannerTitleMain"><span>S</span>tudent <span>A</span>ffairs and <span>S</span>ervices <span>S</span>ystem</span></div>
			</div>
			<div style="clear:both"></div>
		</div>
		<div id="bannerDateDiv">
		<span>${currentDate}</span>
		</div>
		<div style="clear:both"></div>
	</div>
	<div id="headerSeparatorDiv"></div>
	<div id="headerMiddleSeparatorDiv"></div>
	<div id="headerSeparatorDiv"></div>
	<div id="navBar">
		<s:if test="%{pageName!=null}"><div id="pageName"><span>${pageName}</span></div></s:if>
		<div id="accountSettings">
			<span class="clickable" id="homeLink">Home</span><span>|</span>
			<span class="clickable">Alumni Site</span><span>|</span>
			<div id="userAccount" class="clickable">
				<div><span id="firstname">${session.USER.firstName}</span></div>
				<div id="userTypeDiv">
					<span id="userType">${session.USER.userRoleForDisplay}</span>
				</div>
				<form id="logoutForm" action="logout" method="POST">
				</form>
				<div class="dropdownMenu">
					<div id="changePasswordMenu">Change Password</div>
					<div id="logoutMenu">Logout</div>
				</div>
				<div style="clear:both"></div>
			</div>
		</div>		
		<div style="clear:both"></div>
	</div>
</div>
<div id="contentBody">
	<div id="addUserContentBody">
		<div id="contentBodyLeftPane">
			<div id="icon"><img src="images/manageuser.png"/></div>
			<div id="title">Add User</div>
		</div>
		<div id="contentBodyRightPane">
			<div id="addUserDiv">
				<form class="addUserContent" id="addUserForm" action="processUser" method="POST">
    				<div id="addUserElement">
    					<span>First Name</span>
    					<div><input name="firstName" type="text"></div>
    				</div>
    				<div id="addUserElement">
    					<span>Middle Name (optional)</span>
    					<div><input name="middleName" type="text"></div>
    				</div>
    				<div id="addUserElement">
    					<span>Last Name</span>
    					<div><input name="lastName" type="text"></div>
    				</div>
    				<div id="addUserElement">
    					<div><span>Birthday</span></div>
    					<input name="birthMonth" id="month" type="text">
    					<input name="birthDate" id="date" type="text">
    					<input name="birthYear" id="year" type="text">
    				</div>
    				<div id="addUserElement">
    					<span>Contact Number</span>
    					<div><input type="text"></div>
    				</div>
    				<div id="addUserElement">
    					<span>Position</span>
    					<div><input type="text"></div>
    				</div>
    				<div id="roleElement">
    					<div id="roleSpan"><span>Role</span></div>
    					<div id="roleDiv">
	    					<input type="checkbox" id="adminCheck" name="administrator" value="Administrator" unchecked>
	    					<span id="adminSpan">Administrator</span>
	    					<input type="checkbox" id="approverCheck" name="approver" value="Approver" unchecked>
	    					<span id="adminSpan">Approver</span>
	    					<input type="checkbox" id="userCheck" name="user" value="User" unchecked>
	    					<span id="adminSpan">User</span>
	    				</div>
    				</div>
					<div id="roleButton">
						<div id="addUserCancelButton" class="button">
							<span>Cancel</span>
						</div>
						<div id="addUserSaveButton" class="button">
							<span>Save</span>
						</div>
					</div>
    			</form>
    			</div>
    				<div style="clear:both"></div>
			</div>
		</div>
		<div style="clear:both"></div>
</div>

<div id="footer">
	<div id="footerSeparatorDiv">
		<div id="officeDiv"><span>Office of the Student Affairs and Services</span></div>
		<div id="copyrightDiv"><span>copyright:2019v.02</span></div>
		<div style="clear:both"></div>
	</div>
</div>
<div id="overlay">
	<div id="popup">
		<div id="xButton"><span>x</span></div>
		<div id="errorMessageDiv"><span id="errorMessage"></span></div>
		<div style="clear:both"></div>
		<div id="popupCancel" class="button">CANCEL</div>
		<div id="popupOk" class="button">OK</div>
		<div style="clear:both"></div>
	</div>
</div>
<s:if test="%{errorMessage!=null}"><script>popUp('${errorMessage}');</script></s:if>
<s:elseif test="%{notificationMessage!=null}"><script>popUp('${notificationMessage}');</script></s:elseif>
</body>
</html>