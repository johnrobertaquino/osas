$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayMemberList";
	});
	
	
	$('#submitButton').click(function(event) {
		var errorMessage = '';
		
		if ($('#file').val() === '')
		{
			$('#fileError').show();
			$('#fileError').html("Please select an excel file.")
		}
		if ($('#file').val() !== '')
		{
			$('#fileError').hide();
		}
		
		if ($('#file').val() !== '') {
			popUpOkCancel("Do you want to add the member/s from this file?", function() {
				$("#memberExcelFileForm").submit();
			});
		}
	});
	
});