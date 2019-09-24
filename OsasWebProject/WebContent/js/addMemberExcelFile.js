$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayMemberList";
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
			popUpOkCancel("Do you want to add the member/s from this file?", function() {
				$("#memberExcelFileForm").submit();
			});
		}
		else {
			popUp(errorMessage);
		}
	});
	
});