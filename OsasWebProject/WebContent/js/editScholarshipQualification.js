$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		$("#cancelScholarshipQualificationForm").submit();
	});
	
	$('#submitButton').click(function(event) {	
		
		var errorMessage = '';
		
		if (errorMessage == '') {
			popUpOkCancel("Do you want to save changes to this scholarship qualification?", function() {
				$("#editScholarQualificationForm").submit();
			});
		}
		else {
			popUp(errorMessage);
		}
	});
	
});