<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SASS</title>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" type="text/css" href="css/main.css?${dateTimeStamp}">
<link rel="stylesheet" type="text/css" href="css/organizationList.css?${dateTimeStamp}">
<link rel="shortcut icon" type="image/png" href="images/PUPLogo.png" />
<script type="text/javascript" src="js/jquery-3.4.1.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/common.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/organizationList.js?${dateTimeStamp}"></script>
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
		<s:if test="%{pageName!=null}"><div id="pageNameIcon"><img src="images/organizationIconURL.png"/></div><div id="pageName"><span>${pageName}</span></div></s:if>
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
	<form id="deleteOrganizationForm" action="deleteOrganization" method="POST">
  		<input type="hidden" id="organizationId" name="organizationId" />
	</form>
	<form id="showOrganizationRequirementForm" action="displayOrganizationRequirementList" method="POST">
  		<input type="hidden" id="organizationId" name="organizationId" />
	</form>
	<form id="editOrganizationForm" action="displayEditOrganization" method="POST">
  		<input type="hidden" id="organizationId" name="organizationId" />
	</form>
	<form id="showOrganizationQualificationForm" action="displayOrganizationQualificationList" method="POST">
  		<input type="hidden" id="organizationId" name="organizationId" />
	</form>
	<div id="organizationListContentBody" class="featureContent" >
	<div id="contentBodyHolder">
		<div id="contentBodyLeftPane">
			<div id="icon"><img src="images/organizationIcon.png"/></div>
			<div id="title">LIST OF ORGANIZATION</div>
		</div>
		<div id="contentBodyRightPane">
			<div style="clear:both"></div>
			<div id="searchOrganization">
				<img src="images/Search_Magnifying_Glass_Find-512.png">
				<form action="searchOrganization" method="POST" id="searchOrganizationForm">
					<input type="text" id="organizationSearchText" name="organizationSearchText" placeholder="Search Organization Name">
				</form>
				<div class="button" id="searchOrganizationButton">SEARCH</div>
				<div class="button" id="addOrganizationButton">ADD ORGANIZATION</div>
    			<div style="clear:both"></div>
			</div>
			<div id="tableHolder">
			<table>
				<tr>
					<th>Logo</th>
					<th>Organization name</th>
					<th>Organization Type</th>
					<th>Program </th>
					<th>Adviser</th>
					<th>Action</th>
				</tr>
				<s:iterator value="organizationList" status="rowStatus" var="organization">
					<tr <s:if test="#rowStatus.odd == true ">class="odd"</s:if>>
						<td>
							<s:if test='#organization.logoFileName != null && #organization.logoFileName != ""'>
								<a href="javascript:void(0);" class="showPicture"><s:property value="logoFileName" /></a>
							</s:if>
						</td>
						<td><s:property value="organizationName" /></td>
						<td><s:property value="organizationType.organizationTypeName" /></td>
						<td><s:property value="program.programCode" /></td>
 						<td><s:property value="adviser" /></td>
						<td>
							<div class="w3-dropdown-click tableMenu">
  								<div class="tableMenuButton">
  									<img src="images/setting_game_configuration_option-512.png" />
  									<img src="images/arrow-down-01-512.png" />
  								</div>
  								<div class="tableMenuDropdown w3-dropdown-content w3-bar-block w3-border">	
  									<a onclick="displayOrganizationQualification('<s:property value="organizationId" />')" class="w3-bar-item w3-button"><img src="images/view_icon.png" class="dropdownicon"/> View Requirements</a>	
	    							<a onclick="displayEditOrganization('<s:property value="organizationId" />')" class="w3-bar-item w3-button"><img src="images/edit_icon.png" class="dropdownicon"/> Edit</a>
    									<a onclick="showOrganizationDeletePopup('<s:property value="organizationId" />')" class="w3-bar-item w3-button"><img src="images/delete_icon.png" class="dropdownicon"/> Delete</a>
  								</div>
							</div>
						</td>
					</tr>
				</s:iterator>
			</table>
			</div>
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