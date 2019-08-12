$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayScholarshipProgram";
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
		
		if($('#scholarshipProgramName').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Scholarship Program name can\'t be blank.";
		}
		if($('#agencyId').val() === '')
		{
			if (errorMessage != '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Agency Id can\'t be blank.";
		}
		if (errorMessage == '') {
			popUpOkCancel("Do you want to save changes to this scholarship program?", function() {
				$("#editScholarshipProgramForm").submit();
			});
		}
		else {
			popUp(errorMessage);
		}
	});
	
});