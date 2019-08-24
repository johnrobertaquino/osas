<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SASS</title>
<link rel="stylesheet" type="text/css" href="js/jquery-ui/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/scholarshipProgramList.css">
<link rel="stylesheet" type="text/css" href="css/addScholarshipProgram.css">
<link rel="shortcut icon" type="image/png" href="images/PUPLogo.png" />
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="js/jquery-ui/jquery-ui.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/addScholarshipProgram.js"></script>
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
	<div id="addScholarshipProgramContentBody" class="featureContent">
		<div id="contentBodyLeftPane">
			<div id="icon"><img src="images/list.png"/></div>
			<div id="title">ADD SCHOLARSHIP PROGRAM</div>
		</div>
		<div id="contentBodyRightPane">
			<div id="rightPaneContentHolder">
				<form class="addScholarhipProgramContent" id="scholarshipProgramForm" action="addScholarshipProgram" method="POST">
    				<div class="rightPaneElement withTitle">
    				    <span>Agency</span>
	    				<div>
		    				<select name="agencyId">
		    					<s:iterator value="agencyList" status="rowStatus" var="agency">
		    						<option value="${agency.agencyId}">${agency.agencyName}</option>
		    					</s:iterator>
							</select>
						</div>
					</div>
    				<div class="rightPaneElement withTitle">
    					<span>Scholarship Program</span>
    					<div><input id="scholarshipProgram" name="scholarshipProgramName" type="text"></div>
    				</div>
    				<table>
						<tr>
							<th>Qualification Name</th>
						</tr>
						<s:iterator value="scholarshipQualification" status="rowStatus" var="scholarshipQualification">
							<tr <s:if test="#rowStatus.odd == true ">class="odd"</s:if>>
								<td><s:property value="scholarshipQualificationName" /></td>
								<td>Birth Certificate</td>
								<td>
									<div class="w3-dropdown-click tableMenu">
		  								<div class="tableMenuButton">
		  									<img src="images/setting_game_configuration_option-512.png" />
		  									<img src="images/arrow-down-01-512.png" />
		  								</div>
		  								<div class="tableMenuDropdown w3-dropdown-content w3-bar-block w3-border">	
			    							<a onclick="displayEditScholar('<s:property value="scholarId" />')" class="w3-bar-item w3-button">Edit</a>
		    									<a onclick="showScholarDeletePopup('<s:property value="scholarId" />')" class="w3-bar-item w3-button">Delete</a>
		  								</div>
									</div>
								</td>
							</tr>
						</s:iterator>
					</table>
    				<div class="rightPaneElement withTitle">
						<div id="buttonHolder">
							<div id="cancelButton" class="button">
								<span>Cancel</span>
							</div>
							<div id=submitButton class="button left">
								<span>Add Scholarship Program</span>
							</div>
							<div style="clear:both"></div>
						</div>
					</div>
    			</form>
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