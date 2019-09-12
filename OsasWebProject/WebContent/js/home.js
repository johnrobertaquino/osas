/**
 * 
 */
$(document).ready(function() {
	$('#adminFunctionsManageAccounts').click(function() {
		event.stopPropagation();
		location.href = "displayUserList";
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
	
});

