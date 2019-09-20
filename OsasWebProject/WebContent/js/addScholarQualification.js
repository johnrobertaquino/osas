$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		$("#cancelScholarQualificationForm").submit();
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
});
