$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayScholarshipProgramList";
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
		
		if($('#scholarshipProgramName').val() === '')
		{
			$('#scholarshipProgramError').show();
			$('#scholarshipProgramError').html("Scholarship Program name can\'t be blank.");
		}
		else if ($('#scholarshipProgramName').val() !== '')
		{
			$('#scholarshipProgramError').hide();
		}
		if ($('#scholarshipProgramName').val() !== '') {
			popUpOkCancel("Do you want to save changes to this scholarship program?", function() {
				$("#editScholarshipProgramForm").submit();
			});
		}
	});
	
});