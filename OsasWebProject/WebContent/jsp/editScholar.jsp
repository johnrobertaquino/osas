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
<link rel="stylesheet" type="text/css" href="css/editScholar.css?${dateTimeStamp}">
<link rel="shortcut icon" type="image/png" href="images/PUPLogo.png" />
<script type="text/javascript" src="js/jquery-3.4.1.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/jquery-ui/jquery-ui.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/common.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/editScholar.js?${dateTimeStamp}"></script>
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
		<s:if test="%{pageName!=null}"><div id="pageNameIcon"><img src="images/scholarshipIconURL.png"/></div><div id="pageName"><span>${pageName}</span></div></s:if>
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
	<div id="editScholarContentBody" class="featureContent">
		<div id="contentBodyLeftPane">
			<div id="icon"><img src="images/scholarshipIcon.png"/></div>
			<div id="title">EDIT SCHOLAR</div>
		</div>
		<div id="contentBodyRightPane">
			<div id="rightPaneContentHolder">
				<form class="editScholarContent" id="editScholarForm" action="editScholar" method="POST">
					<input name="scholarId" type="hidden" value="${scholar.scholarId}">
    				<div class="rightPaneElement withTitle">
    					<span>Student Number</span>
    					<div><input id="studentNumber" name="studentNumber" type="text" value="${scholar.studentNumber}"></div>
    				</div>
    				<div class="rightPaneElement withTitle">
    					<span>First Name</span>
    					<div><input id="firstName" name="firstName" type="text" value="${scholar.firstName}"></div>
    				</div>
    				
    				<div class="rightPaneElement withTitle">
					<span>Middle Name</span>
    					<div><input id="middleName" name="middleName" type="text" value="${scholar.middleName}"></div>
    				</div>
    				
    				<div class="rightPaneElement withTitle">
					<span>Last Name</span>
    					<div><input id="lastName" name="lastName" type="text" value="${scholar.lastName}"></div>
    				</div>
    				
    				<div class="rightPaneElement withTitle">
					<span>Email</span>
    					<div><input id="email" name="email" type="text" value="${scholar.email}"></div>
    				</div>
    				
    				<div class="rightPaneElement withTitle">
    					<span>Contact Number</span>
    					<div><input id="contactNumber" name="contactNumber" type="text" maxlength="11" value="${scholar.contactNumber}" placeholder="+63"></div>
    				</div>
    				<div class="rightPaneElement withTitle">
    					<span>Program</span>
    					<div><input id="program" name="program" type="text" value="${scholar.program}"></div>
    				</div>
    				<div class="rightPaneElement withTitle">
    					<span>Year</span>
    					<div><input id="year" name="year" type="text" value="${scholar.year}"></div>
    				</div>
    			   	<div class="rightPaneElement withTitle">
    					<span>Section</span>
    					<div><input id="section" name="section" type="text" value="${scholar.section}"></div>
    				</div>
    			    <div class="rightPaneElement withTitle">
    					<span>GWA</span>
    					<div><input id="gwa" name="gwa" type="text" value="${scholar.gwa}"></div>
    				</div>
    				
    				<div class="rightPaneElement withTitle">
						<div id="buttonHolder">
							<div id="cancelButton" class="button">
								<span>Cancel</span>
							</div>
							<div id="submitButton" class="button left">
								<span>Save</span>
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