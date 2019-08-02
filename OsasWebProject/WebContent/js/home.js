/**
 * 
 */
$(document).ready(function() {
	$('#adminFunctionsManageAccounts').click(function() {
		event.stopPropagation();
		location.href = "displayUserList";
	});
});
