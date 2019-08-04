$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayUserList";
	});
	
	$("#contactNumber").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[0-9]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });
	
	$('#submitButton').click(function(event) {
		var selectedRoleCount = 0;
		var isUserRoleSelected = false;
		$.each($("input[name='roleReferenceCodeList']:checked"), function(){
			selectedRoleCount++;
			if($(this).val() == 'US') {
				isUserRoleSelected = true;
			}
        });
		
		var errorMessage = '';
		
		if (selectedRoleCount > 1 && isUserRoleSelected) {
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Administrator/Approver role can't be selected if User role is already selected.";
		}
		if($('#firstName').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "First name can\'t be blank.";
		}
		if($('#lastName').val() === '')
		{
			if (errorMessage != '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Last name can\'t be blank.";
		}
		if($('#birthday').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Birthday can\'t be blank.";
		}
		if($('#contactNumber').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Contact Number can\'t be blank.";
		}
		if($('#position').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Position can\'t be blank.";
		}
		if(selectedRoleCount === 0)
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "No User role selected.";
		}
		if (errorMessage == '') {
			popUpOkCancel("Do you want to save changes to this user?", function() {
				$("#editUserForm").submit();
			});
		}
		else {
			popUp(errorMessage);
		}
	});
	
});