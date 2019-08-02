$(document).ready(function() {
	$('#editUserCancelButton').click(function(event) {
		location.href = "displayUserList";
	});
	
	$('#editUserSaveButton').click(function(event) {
		var selectedRoleCount = 0;
		var isUserRoleSelected = false;
		$.each($("input[name='roleReferenceCodeList']:checked"), function(){
			selectedRoleCount++;
			if($(this).val() == 'US') {
				isUserRoleSelected = true;
			}
        });
		
		if (selectedRoleCount > 1 && isUserRoleSelected) {
			popUp("Administrator/Approver role can't be selected if User role is already selected.");
		}
		else {
			popUpOkCancel("Do you want to save changes to this user?", function() {
				$("#editUserForm").submit();
			});
		}
	});
	
});