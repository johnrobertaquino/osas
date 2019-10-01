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
<link rel="stylesheet" type="text/css" href="css/agencyList.css?${dateTimeStamp}">
<link rel="shortcut icon" type="image/png" href="images/PUPLogo.png" />
<script type="text/javascript" src="js/jquery-3.4.1.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/common.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/agencyList.js?${dateTimeStamp}"></script>
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
	<form id="deleteAgencyForm" action="deleteAgency" method="POST">
  		<input type="hidden" id="agencyId" name="agencyId" />
	</form>
	<form id="editAgencyForm" action="displayEditAgency" method="POST">
  		<input type="hidden" id="agencyId" name="agencyId" />
	</form>
	<div id="agencyListContentBody" class="featureContent" >
	<div id="contentBodyHolder">
		<div id="contentBodyLeftPane">
			<div id="icon"><img src="images/scholarshipIcon.png"/></div>
			<div id="title">LIST OF AGENCY</div>
		</div>
		<div id="contentBodyRightPane">
			<div style="clear:both"></div>
			<div id="searchAgency">
				<img src="images/Search_Magnifying_Glass_Find-512.png">
				<form action="searchAgency" method="POST" id="searchAgencyForm">
					<input type="text" id="agencySearchText" name="agencySearchText" placeholder="Search Agency">
					<!-- <input type="hidden" name="agency.semTermId" value="${agency.semTermId}"/>  -->
				</form>
				<div class="button" id="searchAgencyButton">SEARCH</div>
				<div class="button" id="addAgencyButton">ADD AGENCY</div>
    			<div style="clear:both"></div>
			</div>
			<div id="tableHolder">
			<table class="contentTable">
				<tr>
					<th>Agency name</th>
					<th>Address</th>
					<th>Contact number</th>
					<th>Contact person</th>
					<th class="tdAction">Action</th>
				</tr>
				<s:iterator value="agencyList" status="rowStatus" var="agency">
					<tr <s:if test="#rowStatus.odd == true ">class="odd"</s:if>>
						<td><s:property value="agencyName" /></td>
						<td><s:property value="address" /></td>
						<td><s:property value="contactNumber" /></td>
						<td><s:property value="contactPerson" /></td>
						<td class="tdAction">
							<div class="w3-dropdown-click tableMenu">
  								<div class="tableMenuButton">
  									<img src="images/setting_game_configuration_option-512.png" />
  									<img src="images/arrow-down-01-512.png" />
  								</div>
  								<div class="tableMenuDropdown w3-dropdown-content w3-bar-block w3-border">	
	    							<a onclick="displayEditAgency('<s:property value="agencyId" />')" class="w3-bar-item w3-button"><img src="images/edit_icon.png" class="dropdownicon"/> Edit</a>
    									<a onclick="showAgencyDeletePopup('<s:property value="agencyId" />')" class="w3-bar-item w3-button"><img src="images/delete_icon.png" class="dropdownicon"/> Delete</a>
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