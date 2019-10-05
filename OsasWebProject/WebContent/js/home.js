/**
 * 
 */
$(document).ready(function() {
	$('#adminFunctionsManageAccounts').click(function() {
		event.stopPropagation();
		location.href = "displayUserList";
	});
	
	$('#adminFunctionsManageProgram').click(function() {
		event.stopPropagation();
		location.href = "displayProgramList";
	});
	
	$('#adminFunctionsManageSemester').click(function() {
		event.stopPropagation();
		location.href = "displayManageSemester";
	});
	
	$('#scholarshipManagementAgencyLink').click(function() {
		event.stopPropagation();
		location.href = "displayAgencyList";
	});
	$('#scholarshipManagementScholarshipLink').click(function() {
		event.stopPropagation();
		location.href = "displayScholarshipProgramList";
	});
	$('#scholarsLink').click(function() {
		event.stopPropagation();
		location.href = "displayScholarList";
	});
	
	$('#studentOrgTermManagementLink').click(function() {
		event.stopPropagation();
		location.href = "displayOrganizationList";
	});
	
	$('#studentOrgOrganizationManagementLink').click(function() {
		event.stopPropagation();
		location.href = "displayMemberList";
	});
	
	$('#studentScholarShipReportsLink').click(function() {
		event.stopPropagation();
		location.href = "displayScholarshipReport";
	});
	
	$('#studentOrgRequirementManagementLink').click(function() {
		event.stopPropagation();
		location.href = "displayOrganizationRequirementList";
	});
	
	
	$('#studentOrgReportsLink').click(function() {
		event.stopPropagation();
		location.href = "displayOrganizationReport";
	});
});

