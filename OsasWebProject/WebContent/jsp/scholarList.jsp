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
<link rel="stylesheet" type="text/css" href="css/scholarList.css?${dateTimeStamp}">
<link rel="shortcut icon" type="image/png" href="images/PUPLogo.png" />
<script type="text/javascript" src="js/jquery-3.4.1.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/common.js?${dateTimeStamp}"></script>
<script type="text/javascript" src="js/scholarList.js?${dateTimeStamp}"></script>
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
	<form id="deleteScholarForm" action="deleteScholar" method="POST">
  		<input type="hidden" id="scholarId" name="scholarId" />
	</form>
	<form id="editScholarForm" action="displayEditScholar" method="POST">
  		<input type="hidden" id="scholarId" name="scholarId" />
	</form>
	<form id="showScholarQualificationForm" action="displayScholarQualificationList" method="POST">
  		<input type="hidden" id="scholarId" name="scholarId" />
	</form>
	<form id="filterScholarForm" action="displayScholarList" method="POST">
  		<input type="hidden" id="filter" name="filter" />
	</form>
	<div id="scholarListContentBody" class="featureContent" >
	<div id="contentBodyHolder">
		<div id="contentBodyLeftPane">
			<div id="icon"><img src="images/scholarshipIcon.png"/></div>
			<div id="title">LIST OF SCHOLARS</div>
		</div>
		<div id="contentBodyRightPane">
			<div id="searchScholar">
				<img src="images/Search_Magnifying_Glass_Find-512.png">
				<form action="searchScholar" method="POST" id="searchScholarForm">
					<input type="text" id="scholarSearchText" name="scholarSearchText" placeholder="Search Scholar">
				</form>
				<div class="button" id="searchScholarButton">SEARCH</div>
				<div class="button" id="addScholarExcelFileButton">ADD SCHOLAR via EXCEL FILE <!--<img id="excelImage" src="images/excel.png">  --></div>
				<div class="button" id="addScholarButton">ADD SCHOLAR</div>
    			<div style="clear:both"></div><br><br>
    			   
    			<div class="rightPaneElement withTitle">
    			<div>
    				    <span>Filter Status:</span>
	    				<div>
		    				<select id="filterSelect">
		    						<option value="all" <s:if test='filter == "all"'>selected</s:if>>All</option>
		    						<option value="pending" <s:if test='filter == "pending"'>selected</s:if>>Pending Approval</option>
		    						<option value="approved" <s:if test='filter == "approved"'>selected</s:if>>Approved</option>
		    						<option value="incomplete" <s:if test='filter == "incomplete"'>selected</s:if>>Incomplete</option>
							</select>
						</div>
				</div>
				</div>
			    <div class="rightPaneElement withTitle">
				    <div id = searchByScholarshipProgramAgency>
		    			<span>Filter By Scholarship Program:</span>
			    				<div>
				    				<select id="filterSelect" name="scholarshipProgram.ScholarshipProgramName">
				    					<s:iterator value="scholarshipProgramList" status="rowStatus" var="scholarshipProgram">
				    						<option value="${scholarshipprogram.scholarshipProgramId}" <s:if test='filter == "scholarshipprogram.organizationListDisplay"'>selected</s:if>>${scholarshipprogram.ScholarshipProgramName}</option>
				    					</s:iterator>
									</select>
								</div>
						</div>
					</div>
				</div>
			<div id="tableHolder">
			<table class="contentTable">
				<tr>
					<th>Scholarship Program</th>
					<th>Student Number</th>
					<th>First Name</th>
					<th>Middle Name </th>
					<th>Last Name</th>
					<th>Gender</th>
					<th>Contact Number</th>
					<th>Program</th>
					<th>Status</th>
					<th class="tdAction">Action</th>
				</tr>
				<s:iterator value="scholarList" status="rowStatus" var="scholar">
					<tr <s:if test="#rowStatus.odd == true ">class="odd"</s:if>>
						<td><s:property value="scholarshipProgram.scholarshipProgramName" /></td>
						<td class="tdStudentNumber"><s:property value="studentNumber" /></td>
						<td><s:property value="firstName" /></td>
						<td><s:property value="middleName" /></td>
						<td><s:property value="lastName" /></td>
						<td><s:property value="gender" /></td>
						<td><s:property value="contactNumber" /></td>
						<td><s:property value="program.programCode" />&nbsp;<s:property value="year" />-<s:property value="section" /></td>
						<td><s:property value="statusText" /></td>
						<td class="tdAction">
							<div class="w3-dropdown-click tableMenu">
  								<div class="tableMenuButton">
  									<img src="images/setting_game_configuration_option-512.png" />
  									<img src="images/arrow-down-01-512.png" />
  								</div>
  								<div class="tableMenuDropdown w3-dropdown-content w3-bar-block w3-border">	
  									<a onclick="displayScholarQualification('<s:property value="scholarId" />')" class="w3-bar-item w3-button"><img src="images/view_icon.png" class="dropdownicon"/> View Qualifications</a>
	    							<a onclick="displayEditScholar('<s:property value="scholarId" />')" class="w3-bar-item w3-button"><img src="images/edit_icon.png" class="dropdownicon"/> Edit</a>
    								<a onclick="showScholarDeletePopup('<s:property value="scholarId" />')" class="w3-bar-item w3-button"><img src="images/delete_icon.png" class="dropdownicon"/> Delete</a>
  								</div>
							</div>
						</td>
					</tr>
				</s:iterator>
			</table>
			</div>
			<div style="clear:both"></div>
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