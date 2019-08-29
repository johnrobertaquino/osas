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
<link rel="stylesheet" type="text/css" href="css/scholarshipProgramList.css">
<link rel="shortcut icon" type="image/png" href="images/PUPLogo.png" />
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/scholarshipProgramList.js"></script>
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
		<s:if test="%{pageName!=null}"><div id="pageNameIcon"><img src="images/manageAccount_white.png"/></div><div id="pageName"><span>${pageName}</span></div></s:if>
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
	<form id="deleteScholarshipProgramForm" action="deleteScholarshipProgram" method="POST">
  		<input type="hidden" id="scholarshipProgramId" name="scholarshipProgramId" />
	</form>
	<form id="scholarshipQualificationForm" action="displayScholarshipQualification" method="POST">
  		<input type="hidden" id="scholarshipProgramId" name="scholarshipProgramId" />
	</form>
	<form id="editScholarshipProgramForm" action="displayEditScholarshipProgram" method="POST">
  		<input type="hidden" id="scholarshipProgramId" name="scholarshipProgramId" />
	</form>
	<div id="scholarshipProgramListContentBody" class="featureContent" >
	<div id="contentBodyHolder">
		<div id="contentBodyLeftPane">
			<div id="icon"><img src="images/editAccount.png"/></div>
			<div id="title">LIST OF SCHOLARSHIP</div>
		</div>
		<div id="contentBodyRightPane">
			<div id="searchScholarshipProgram">
				<img src="images/Search_Magnifying_Glass_Find-512.png">
				<form action="searchScholarshipProgram" method="POST" id="searchScholarshipProgramForm">
					<input type="text" id="scholarshipProgramSearchText" name="scholarshipProgramSearchText" placeholder="Search Scholarship Program">
				</form>
				<div class="button" id="searchScholarshipProgramButton">SEARCH</div>
				<div class="button" id="addScholarshipProgramButton">ADD SCHOLARSHIP PROGRAM</div>
    			<div style="clear:both"></div>
			</div>
			<table>
				<tr>
					<th>Agency Name</th>
					<th>Scholarship Program Name</th>
				</tr>
				<s:iterator value="scholarshipProgramList" status="rowStatus" var="scholarshipProgram">
					<tr <s:if test="#rowStatus.odd == true ">class="odd"</s:if>>
						<td><s:property value="agency.agencyName" /></td>
						<td><s:property value="scholarshipProgramName" /></td>
						<td>
							<div class="w3-dropdown-click tableMenu">
  								<div class="tableMenuButton">
  									<img src="images/setting_game_configuration_option-512.png" />
  									<img src="images/arrow-down-01-512.png" />
  								</div>
  								<div class="tableMenuDropdown w3-dropdown-content w3-bar-block w3-border">
  									<a onclick="displayScholarshipQualification('<s:property value="scholarshipProgramId" />')" class="w3-bar-item w3-button">View Qualifications</a>	
	    							<a onclick="displayEditScholarshipProgram('<s:property value="scholarshipProgramId" />')" class="w3-bar-item w3-button">Edit</a>
    									<a onclick="showScholarshipProgramDeletePopup('<s:property value="scholarshipProgramId" />')" class="w3-bar-item w3-button">Delete</a>
  								</div>
							</div>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<div style="clear:both"></div>
	</div>
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