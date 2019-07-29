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
<script type="text/javascript" src="js/common.js"></script>
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
			<span>Home</span><span>|</span><span>Account Settings</span><span>|</span>
			<div id="userAccount">
				<div><span id="firstname">${session.USER.userName}</span></div>
				<div id="userTypeDiv">
					<span id="userType">
						<s:if test="%{#session.USER.userTypeId == 1}">
							Administrator
						</s:if>
						<s:elseif test="%{#session.USER.userTypeId == 2}">
							User			
						</s:elseif>
					</span>
				</div>
				<div style="clear:both"></div>
			</div>
		</div>		
		<div style="clear:both"></div>
	</div>
</div>
<div id="contentBody">
	<div id = Studentscholarship>
		<span>Student Scholarship</span>
		<span id = Studentscholarshipicon> <img alt="image" src="images/Scholarship.png"></span>
	</div>
		<div class ="Scholarshiplinks">
			<span id= ScholarshipManagementAgency>Scholarship Management-Agency</span>
	</div>
		<div class ="Scholarshiplinks">
			<span id= ScholarshipManagementScholarship>Scholarship Management-Scholarship</span>
	</div>
		<div class ="Scholarshiplinks">
			<span id=Scholars>Scholars Management</span>
	</div>
		<div class ="Scholarshiplinks">
			<span id=ApplicationStatus>Application Status</span>
	</div>
		<div class ="Scholarshiplinks">
			<span id=Reports>Reports</span>
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
		<div id="popupOk" class="button">OK</div>
	</div>
</div>
<s:if test="%{errorMessage!=null}"><script>popUp('${errorMessage}');</script></s:if>
</body>
</html>