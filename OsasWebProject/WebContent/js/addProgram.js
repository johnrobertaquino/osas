$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayProgramList";
	});
	
	$("#programCode").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[a-zA-Z\s]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });
	
	
	$("#programName").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[a-zA-Z\s]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });
	
	$("#highestYearLevel").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[0-9]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });
	
	$('#submitButton').click(function(event) {
		
		if($('#programCode').val() === '')
		{
			$('#programCodeError').show();
			$('#programCodeError').html("Program code can\'t be blank.")
		}
		else if($('#programCode').val() !== '')
		{
			$('#programCodeError').hide();			
		}
		if($('#programName').val() === '')
		{
			$('#programNameError').show();
			$('#programNameError').html("Program name can\'t be blank.")
		}
		else if($('#programName').val() !== '')
		{
			$('#programNameError').hide();			
		}
		if($('#highestYearLevel').val() === '')
		{
			$('#highestYearLevelError').show();
			$('#highestYearLevelError').html("Highest Year Level can\'t be blank.")
		}
		else if($('#highestYearLevel').val() !== '')
		{
			$('#highestYearLevelError').hide();			
		}
		if ($('#programCode').val() !== '' && $('#programName').val() !== '' && $('#highestYearLevel').val() !== '') {
			popUpOkCancel("Do you want to add this program?", function() {
				$("#programForm").submit();
			});
		}
	});
	
});