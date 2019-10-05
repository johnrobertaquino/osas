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
<link rel="stylesheet" type="text/css" href="css/memberList.css?${dateTimeStamp}">
<link rel="stylesheet" type="text/css" href="css/addMember.css?${dateTimeStamp}">
<link rel="shortcut icon" type="image/png" href="images/PUPLogo.png" />
<script type="text/javascript" src="js/jquery-3.4.1.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/jquery-ui/jquery-ui.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/common.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/addMember.js?${dateTimeStamp}"></script>
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
	<div id="addMemberContentBody" class="featureContent">
		<div id="contentBodyLeftPane">
			<div id="icon"><img src="images/organizationIcon.png"/></div>
			<div id="title">ADD MEMBER</div>
		</div>
		<div id="contentBodyRightPane">
			<div id="rightPaneContentHolder">
				<form class="addMemberContent" id="memberForm" action="addMember" method="POST" enctype="multipart/form-data">
    				<div class="rightPaneElement withTitle">
    				    <span class="title">Organization</span>
	    				<br><br><div style="height: 200px; overflow-y: scroll;">
	    					<s:iterator value="organizationList" status="rowStatus" var="organization">
			    				<div id="roleDiv">
									<label for="organizationIdList">
										<s:set var="checked"></s:set>
										<s:iterator value="organizationIdList" status="rowStatus" var="organizationId">
											<s:if test="#organizationId == #organization.organizationId">
												<s:set var="checked">checked</s:set>
											</s:if>
										</s:iterator>
								    	<input type="checkbox" id="organizationIdList" name="organizationIdList" value="${organization.organizationId}" ${checked}/>
								    	${organization.organizationName}
									</label>
								</div>
							</s:iterator>
						</div>
					</div><br>
					<div class="rightPaneElement withTitle">
	    				<div>
	    					<span class="title">Student Number</span>
	    					<div><input id="studentNumber" name="studentNumber" type="text" value="${studentNumber}"></div>
	    				</div>
	    			</div>
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
    					<span class="title">Program</span>
    					<div>
    						<select name="program">
		    					<s:iterator value="programList" status="rowStatus" var="programItem">
		    						<option value="${programItem.programCode}">${programItem.programName}</option>
		    					</s:iterator>
							</select>
						</div>
    				</div>
    				<div class="rightPaneElement withTitle">
						<div id="roleDiv">
							<label for="chkOfficer">
							    <input type="checkbox" id="chkOfficer" name="officer" <s:if test='officer == "on"'>checked</s:if>/>
							    Officer
							</label>
						</div>
    				</div>
    				<br><div class="rightPaneElement withTitle" id="divOfficer" <s:if test='!(officer == "on")'>style="display: none"</s:if>>
    					<div>
	    					<div>
	    						<label class="title">Upload Photo</label>		 
		    					<input id="officerInput" name="officerPhoto" type="file" accept="image/*">
		    				</div><br>
	    					<div>
		    					<span class="title">Position</span>
		    					<s:if test='officer == "on"'>
		    						<div><input id="position" name="position" type="text" value="${position}"></div>
		    					</s:if>
		    					<s:else>
		    						<div><input id="position" name="position" type="text"></div>
		    					</s:else>
	    					</div>
    					</div>
    				</div>
   					<div class="rightPaneElement withTitle">
    					<span class="title">Gender</span>
	    				<div id="roleDiv">
		    				<input type="radio" id="gender" name="gender" value="M" checked>
		    				<span>Male</span>
		    				<input type="radio" id="gender" name="gender" value="F">
		    				<span>Female</span>
		    			</div>
    				</div>
    				<div class="rightPaneElement withTitle">
    					<span class="title">Year</span>
    					<div><input id="year" name="year" type="text" value="${year}"  maxlength="1"></div>
    				</div>
    			   <div class="rightPaneElement withTitle">
    					<span class="title">Section</span>
    					<div><input id="section" name="section" type="text" value="${section}"  maxlength="1"></div>
    				</div>
    				<div class="rightPaneElement withTitle">
    					<span class="title">Contact Number</span>
    					<div><input id="contactNumber" name="contactNumber" type="text" maxlength="11" value="${contactNumber}"></div>
    				</div>
    				<div class="rightPaneElement withTitle">
						<div id="buttonHolder">
							<div id="cancelButton" class="button">
								<span>CANCEL</span>
							</div>
							<div id=submitButton class="button left">
								<span>ADD MEMBER</span>
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