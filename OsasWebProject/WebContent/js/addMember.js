$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayMemberList";
	});
	
	$("#contactNumber").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[0-9]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });
	
	$("#year").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[0-9]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });
	
	$("#firstName").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[a-zA-Z\s]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });

	$("#middleName").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[a-zA-Z\s]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });

	$("#lastName").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[a-zA-Z\s]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });
	 
	$("#chkOfficer").click(function () {
		if ($(this).is(":checked")) {
			$("#divOfficer").show();
		} else {
			$("#divOfficer").hide();
		}
	});
	
	$("#section").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[0-9]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });
	
	$('#submitButton').click(function(event) {
		
		if($('#studentNumber').val() === '')
		{
			$('#studentNumberError').show();
			$('#studentNumberError').html("Student Number can\'t be blank.");
		}
		else if($('#studentNumber').val() !== '')
		{
			$('#studentNumberError').hide();
		}
		if($('#firstName').val() === '')
		{
			$('#firstNameError').show();
			$('#firstNameError').html("First name can\'t be blank.");
		}
		else if($('#firstName').val() !== '')
		{
			$('#firstNameError').hide();
		}
		if($('#lastName').val() === '')
		{
			$('#lastNameError').show();
			$('#lastNameError').html("Last name can\'t be blank.");
		}
		else if($('#lastName').val() !== '')
		{
			$('#lastNameError').hide();
		}
		if($('#year').val() === '')
		{
			$('#yearError').show();
			$('#yearError').html("Year can\'t be blank.");
		}
		else if($('#year').val() !== '')
		{
			$('#yearError').hide();
		}
		if($('#section').val() === '')
		{
			$('#sectionError').show();
			$('#sectionError').html("Section can\'t be blank.");
		}
		else if($('#section').val() !== '')
		{
			$('#sectionError').hide();
		}
		if ($('#studentNumber').val() !== '' && $('#firstName').val() !== '' && $('#lastName').val() !== '' && $('#year').val() !== '' && $('#section').val() !== '') {
			popUpOkCancel("Do you want to add this Member?", function() {
				$("#memberForm").submit();
			});
		}
	});
	
	$('#addMemberButton').click(function() {
		location.href = "displayMemberList";
	});
	
});