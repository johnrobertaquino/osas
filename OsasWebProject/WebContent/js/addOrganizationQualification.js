$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		$("#cancelOrganizationQualificationForm").submit();
	});
	
	$(function() {
		  $( "#dateSubmitted" ).datepicker({  maxDate: 0 });
		});
	
	$('#submitButton').click(function(event) {
		var errorMessage = '';
	
		if (errorMessage == '') {
			popUpOkCancel("Do you want to add this organization qualification?", function() {
				$("#addOrganizationQualificationForm").submit();
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
