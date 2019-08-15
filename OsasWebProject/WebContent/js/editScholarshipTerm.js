$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayScholarshipTermList";
	});
	
	$("#contactNumber").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[0-9]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });
	
	$('#submitButton').click(function(event) {	
		
		var errorMessage = '';
		
		if($('#scholarshipTermName').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Scholarship Term name can\'t be blank.";
		}
		if($('#startDate').val() === '')
		{
			if (errorMessage != '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Start Date can\'t be blank.";
		}
		if($('#endDate').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "End Date can\'t be blank.";
		}
		if($('#active').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Active can\'t be blank.";
		}
		if (errorMessage == '') {
			popUpOkCancel("Do you want to save changes to this scholarship term?", function() {
				$("#editScholarshipTermForm").submit();
			});
		}
		else {
			popUp(errorMessage);
		}
	});
	
});