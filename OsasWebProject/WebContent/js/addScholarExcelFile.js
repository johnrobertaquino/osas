$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayScholarList";
	});
	
	
	$('#submitButton').click(function(event) {
		var errorMessage = '';
		
		if ($('#file').val() === '')
		{
			$('#fileError').show();
			$('#fileError').html("Please select an excel file.");
		}
		else if($('#file').val() !== '')
		{
			$('#fileError').hide();
		}
		
		if ($('#file').val() !== '') {
			popUpOkCancel("Do you want to add the scholar/s from this file?", function() {
				$("#scholarExcelFileForm").submit();
			});
		}
	});
	
});