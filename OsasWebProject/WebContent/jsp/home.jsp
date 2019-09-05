<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SASS</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="shortcut icon" type="image/png" href="images/PUPLogo.png" />
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/home.js"></script>
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
	<div id="homeContentBody">
		<div id="contentBodyLeftPane">
			<div class="linkHolder">
				<div class="linkHeader">
					<span>Student Scholarship</span>
					<img alt="image" src="images/studentScholarship.png">
				</div>
				<div class ="menuLinks">
					<div class="linkItemHolder">
						<div class="linkIcon"><img src="images/arrow.png"></div><div class="link" id="scholarshipManagementAgencyLink">Manage Scholarship Agency</div>
						<div style="clear:both"></div>
					</div>
				</div>
				<div class="menuLinks">
					<div class="linkItemHolder">
						<div class="linkIcon"><img src="images/arrow.png"></div><div class="link" id="scholarshipManagementScholarshipLink">Manage Scholarship</div>
						<div style="clear:both"></div>
					</div>
				</div>
				<div class ="menuLinks">
					<div class="linkItemHolder">
						<div class="linkIcon"><img src="images/arrow.png"></div><div class="link" id="scholarsLink">Manage Scholars</div>
						<div style="clear:both"></div>
					</div>
				</div>
				<div class ="menuLinks">
					<div class="linkItemHolder">
						<div class="linkIcon"><img src="images/arrow.png"></div><div class="link" id="studentScholarShipReportsLink">Reports</div>
						<div style="clear:both"></div>
					</div>
				</div>
				<div style="clear:both"></div>
				<!-- Admin Function -->
				<s:if test="%{#session.USER.admin}">
					<div class="linkHeader">
						<span>Administrator Functions</span>
						<img alt="image" src="images/manageAccount.png">
					</div>
					<div class ="menuLinks">
						<div class="linkItemHolder">
							<div class="linkIcon"><img src="images/arrow.png"></div><div class="link" id="adminFunctionsManageAccounts">Manage Accounts</div>
							<div style="clear:both"></div>
						</div>
					</div>
				</s:if>
			</div>
			<div style="clear:both"></div>
		</div>
		<div id="contentBodyRightPane">
			<div class="linkHolder">
				<div class="linkHeader">
					<span>Student Organization</span>
					<img alt="image" src="images/studentOrganization.png">
				</div>
				<div class ="menuLinks">
					<div class="linkItemHolder">
						<div class="linkIcon"><img src="images/arrow.png"></div><div class="link" id="studentOrgTermManagementLink">Manage Organization</div>
						<div style="clear:both"></div>
					</div>
				</div>
				<div class="menuLinks">
					<div class="linkItemHolder">
						<div class="linkIcon"><img src="images/arrow.png"></div><div class="link" id="studentOrgRequirementsSubmissionLink">Manage Requirements Submission/Reviews</div>
						<div style="clear:both"></div>
					</div>
				</div>
				<div class ="menuLinks">
					<div class="linkItemHolder">
						<div class="linkIcon"><img src="images/arrow.png"></div><div class="link" id="studentOrgOrganizationManagementLink">Manage Members</div>
						<div style="clear:both"></div>
					</div>
				</div>
				<div class ="menuLinks">
					<div class="linkItemHolder">
						<div class="linkIcon"><img src="images/arrow.png"></div><div class="link" id="studentOrgReportsLink">Reports</div>
						<div style="clear:both"></div>
					</div>
				</div>
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