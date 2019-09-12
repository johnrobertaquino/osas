$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayScholarList";
	});
	
	
	$('#submitButton').click(function(event) {
		var errorMessage = '';
		
		if ($('#file').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Please select an excel file.";
		}
		
		if (errorMessage == '') {
			popUpOkCancel("Do you want to add the scholar/s from this file?", function() {
				$("#scholarExcelFileForm").submit();
			});
		}
		else {
			popUp(errorMessage);
		}
	});
	
});