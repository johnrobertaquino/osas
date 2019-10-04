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
<link rel="stylesheet" type="text/css" href="css/editOrganization.css?${dateTimeStamp}">
<link rel="shortcut icon" type="image/png" href="images/PUPLogo.png" />
<script type="text/javascript" src="js/jquery-3.4.1.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/jquery-ui/jquery-ui.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/common.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/editOrganization.js?${dateTimeStamp}"></script>
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
	<div id="editOrganizationContentBody" class="featureContent">
		<div id="contentBodyLeftPane">
			<div id="icon"><img src="images/organizationIcon.png"/></div>
			<div id="title">EDIT ORGANIZATION</div>
		</div>
		<div id="contentBodyRightPane">
			<div id="rightPaneContentHolder">
				<form class="editOrganizationContent" id="editOrganizationForm" action="editOrganization" method="POST" enctype="multipart/form-data">
					<input name="organizationId" type="hidden" value="${organization.organizationId}">
    				 <div class="rightPaneElement withTitle">
    					<div>
    						<s:if test='organization.logoFileName != null && organization.logoFileName != ""'>
    							<div id="orglogo"><img src="download?type=OL&fileName=${organization.logoFileName}" alt="logo"/></div>
    						</s:if>    						
    						<div id="orglogoInput"><span>Logo</span><input id="organizationLogo" name="logoFileName" type="file" accept="image/*"></div>
    					</div>
    				</div>
    				<div class="rightPaneElement withTitle">
    					<span class="title">Organization Code</span>
    					<div><input id="organizationName" name="organizationName" type="text" value="${organization.organizationName}"></div>
    				</div>
    				<div class="rightPaneElement withTitle">
	    				<div>
	    					<span class="title">Description</span>
	    					<div><input id="description" name="description" type="text" value="${organization.description}"></div>
	    				</div>
	    			</div>
    				<div class="rightPaneElement withTitle">
    					<span class="title">Organization Type</span>
	    				<div id="roleDiv">
		    				<input type="radio" id="acadCheck" name="organizationTypeCode" value="A" <s:if test='organization.organizationType.organizationTypeCode == "A"'>checked</s:if>>
		    				<span>Academic</span>
		    				<input type="radio" id="nonAcadCheck" name="organizationTypeCode" value="N" <s:if test='organization.organizationType.organizationTypeCode == "N"'>checked</s:if>>
		    				<span>Non-Academic</span>
		    			</div>
    				</div>
    				<div class="rightPaneElement withTitle">
    				<div id="programDiv" <s:if test='organization.organizationType.organizationTypeCode == "N"'>style="display: none;"</s:if>>
    					<span class="title">Program</span>
    					<div>
    						<select name="program">
		    					<s:iterator value="programList" status="rowStatus" var="programItem">
		    						<option value="${programItem.programCode}" <s:if test="#program.programCode == organization.program.programCode">selected</s:if>>${programItem.programName}</option>
		    					</s:iterator>
							</select>
						</div>
    				</div>
    				</div>
    				<div class="rightPaneElement withTitle">
    					<span class="title">Adviser</span>
    					<div><input id="adviser" name="adviser" type="text" value="${organization.adviser}"></div>
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