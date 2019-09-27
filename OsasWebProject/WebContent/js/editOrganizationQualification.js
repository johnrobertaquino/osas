$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		$("#cancelOrganizationQualificationForm").submit();
	});
	
	$('#submitButton').click(function(event) {	
		
		var errorMessage = '';
		
		if (errorMessage == '') {
			popUpOkCancel("Do you want to save changes to this organization qualification?", function() {
				$("#editOrganzationQualificationForm").submit();
			});
		}
		else {
			popUp(errorMessage);
		}
	});
	
	$('#addAttachment').click(function(event) {
		if ($(this).prop("checked") == true) {
			$('#fileNameHolder').show();
		} else {
			$('#fileNameHolder').hide();
		}
	});
	
	$('#fileNameHolder').hide();
	
});