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
});

