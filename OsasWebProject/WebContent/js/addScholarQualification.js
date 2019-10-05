$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		$("#cancelScholarQualificationForm").submit();
	});
	
	
	$(function() {
		  $( "#dateSubmitted" ).datepicker({  maxDate: 0 });
		});
	
	$('#submitButton').click(function(event) {
		var errorMessage = '';
	
		if (errorMessage == '') {
			popUpOkCancel("Do you want to add this scholarship qualification?", function() {
				$("#addScholarQualificationForm").submit();
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
