$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayScholarshipProgramList";
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
<<<<<<< HEAD
	
		if($('#scholarshipProgram').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Scholarship Program can\'t be blank.";
		}
		if($('#agencyId').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Agency name can\'t be blank.";
		}
		if (errorMessage == '') {
			popUpOkCancel("Do you want to add this scholarship program?", function() {
				$("#scholarshipProgramForm").submit();
			});
		}
		else {
			popUp(errorMessage);
		}
	});
});


=======
		
		if($('#scholarshipProgramName').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Scholarship Program name can\'t be blank.";
		}
		if($('#agencyId').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Agency Id can\'t be blank.";
		}
		if (errorMessage == '') {
			popUpOkCancel("Do you want to add this scholarship program?", function() {
				$("#scholarshipProgramForm").submit();
			});
		}
		else {
			popUp(errorMessage);
		}
	});
	
	$('#addScholarshipProgramButton').click(function() {
		location.href = "displayScholarshipProgramList";
	});
	
});
>>>>>>> branch 'master' of https://github.com/johnrobertaquino/osas.git
