/**
 * 
 */
$(document).ready(function() {
	$('#adminFunctionsManageAccounts').click(function() {
		event.stopPropagation();
		location.href = "displayUserList";
	});
});

$(document).ready(function() {
	$('#changePasswordMenu').click(function() {
		event.stopPropagation();
		location.href = "changePassword";
	});
});
