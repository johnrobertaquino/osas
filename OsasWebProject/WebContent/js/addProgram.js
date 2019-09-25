$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayProgramList";
	});
	
	$('#submitButton').click(function(event) {
		var errorMessage = '';
		
		if($('#programCode').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Program code can\'t be blank.";
		}
		if($('#programName').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Program name can\'t be blank.";
		}
		if (errorMessage == '') {
			popUpOkCancel("Do you want to add this program?", function() {
				$("#programForm").submit();
			});
		}
		else {
			popUp(errorMessage);
		}
	});
	
});