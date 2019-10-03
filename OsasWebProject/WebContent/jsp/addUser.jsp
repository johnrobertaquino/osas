<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SASS</title>
<link rel="stylesheet" type="text/css" href="js/jquery-ui/jquery-ui.css?${dateTimeStamp}">
<link rel="stylesheet" type="text/css" href="css/main.css?${dateTimeStamp}">
<link rel="stylesheet" type="text/css" href="css/addUser.css?${dateTimeStamp}">
<link rel="shortcut icon" type="image/png" href="images/PUPLogo.png" />
<script type="text/javascript" src="js/jquery-3.4.1.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/jquery-ui/jquery-ui.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/common.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/addUser.js?${dateTimeStamp}"></script>
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
		<s:if test="%{pageName!=null}"><div id="pageNameIcon"><img src="images/userIconWhite.png"/></div><div id="pageName"><span>${pageName}</span></div></s:if>
		<div id="accountSettings">
			<span class="clickable" id="homeLink">Home</span><span>|</span>
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
	<div id="addUserContentBody" class="featureContent">
		<div id="contentBodyLeftPane">
			<div id="icon"><img src="images/userIcon.png"/></div>
			<div id="title">ADD USER</div>
		</div>
		<div id="contentBodyRightPane">
			<div id="rightPaneContentHolder">
				<form class="addUserContent" id="addUserForm" action="addUser" method="POST">
    				<div class="rightPaneElement withTitle">
	    				<div>
	    					<span class="title">First Name</span>
	    					<div><input id="firstName" name="firstName" type="text" value="${firstName}"></div>
	    				</div>
	    				<div>
	    					<span class="title">Middle Name</span>
	    					<div><input id="middleName" name="middleName" type="text" value="${middleName}"></div>
	    				</div>
	    				<div>
	    					<span class="title">Last Name</span>
	    			    	<div><input id="lastName" name="lastName" type="text" value="${lastName}"></div>
	    			    </div>
    				</div>
    				<div class="rightPaneElement withTitle">
    					<span class="title">Birthday</span>
    					<div><input type="text" name="birthday" id="birthday" value="${birthday}"></div>
    					<script type="text/javascript">
    						$(document).ready(function() {
    							$("#birthday").datepicker({ maxDate: 0});
    							maxDate:'0';
    						});
    					</script>
    				</div>
    				<div class="rightPaneElement withTitle">
    					<span class="title">Contact Number</span>
    					<div><input id="contactNumber" name="contactNumber" type="text" maxlength="11" value="${contactNumber}"></div>
    				</div>
    				<div class="rightPaneElement withTitle">
    					<span class="title">Position</span>
    					<div><input id="position" name="position" type="text" value="${position}"></div>
    				</div>
    				<div class="rightPaneElement withTitle">
    					<span class="title">Role</span>
	    				<div id="roleDiv">
		    				<input type="checkbox" id="adCheck" name="roleReferenceCodeList" value="AD" <s:if test="user.admin">checked</s:if>>
		    				<span>Administrator</span>
		    				<input type="checkbox" id="apCheck" name="roleReferenceCodeList" value="AP" <s:if test="user.approver">checked</s:if>>
		    				<span>Approver</span>
		    				<input type="checkbox" id="usCheck" name="roleReferenceCodeList" value="US" <s:if test="user.user">checked</s:if>>
		    				<span>User</span>
		    			</div>
    				</div>
    				<div class="rightPaneElement withTitle">
						<div id="buttonHolder">
							<div id="cancelButton" class="button">
								<span>Cancel</span>
							</div>
							<div id=submitButton class="button left">
								<span>Register</span>
							</div>
							<div style="clear:both"></div>
						</div>
					</div>
    			</form>
    		</div>
    		<div style="clear:both"></div>
		</div>
		<div style="clear:both"></div>
	</div>
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