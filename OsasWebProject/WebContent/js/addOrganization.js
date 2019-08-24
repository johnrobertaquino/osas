$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayOrganizationList";
	});
	
	$('#submitButton').click(function(event) {
		var errorMessage = '';
		
		if($('#organizationName').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Organization name can\'t be blank.";
		}
		if($('#organizationTypeCode').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Organization Type can\'t be blank.";
		}
		if($('#Program').val() === '')
		{
			if (errorMessage != '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Program can\'t be blank.";
		}
		if($('#Adviser').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Adviser can\'t be blank.";
		}
		if (errorMessage == '') {
			popUpOkCancel("Do you want to add this organization?", function() {
				$("#organizationForm").submit();
			});
		}
		else {
			popUp(errorMessage);
		}
	});
	
});