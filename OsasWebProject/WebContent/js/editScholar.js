$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayScholarList";
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
		
		var errorMessage = '';
		
		if($('#studentNumber').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Student number can\'t be blank.";
		}
		if($('#firstName').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "First can\'t be blank.";
		}
		if($('#middleName').val() === '')
		{
			if (errorMessage != '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Middle name can\'t be blank.";
		}
		if($('#lastName').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Last name can\'t be blank.";
			}
		if($('#email').val() === '')
		{
				if (errorMessage !== '') {
					errorMessage = errorMessage + "<br/>";
				}
				errorMessage = errorMessage + "Email can\'t be blank.";
		}
		if($('#contactNumber').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Contact number can\'t be blank.";
		}
		if (errorMessage == '') {
			popUpOkCancel("Do you want to save changes to this scholar?", function() {
				$("#editScholarForm").submit();
			});
		}
		else {
			popUp(errorMessage);
		}
	});
	
});