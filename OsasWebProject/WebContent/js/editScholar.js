function validateEmail(email) {
  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(email);
}

$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayScholarList";
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
	
	$("#section").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[0-9]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });
	
	$("#gwa").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[0-9]*\.?[0-9]*$/;

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
	
	function ValidateEmail(mail) 
	{
	 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(myForm.emailAddr.value))
	  {
	    return (true)
	  }
	    alert("You have entered an invalid email address!")
	    return (false)
	}

	$('#submitButton').click(function(event) {	
		
		if($('#studentNumber').val() === '')
		{
			$('#studentNumberError').show();
			$('#studentNumberError').html("Student Number can\'t be blank.")
		}
		else if($('#studentNumber').val() !== '')
		{
			$('#studentNumberError').hide();
		}
		
		var $result = $("#result");
		var email = $("#email").val();
		$result.text("");

		if (validateEmail(email)) {
			$('#emailError').hide();
		} else {
			$('#emailError').show();
			$('#emailError').html("You entered invalid email address.")
		}
			
		if($('#firstName').val() === '')
		{
			$('#firstNameError').show();
			$('#firstNameError').html("First name can\'t be blank.")
		}
		else if($('#firstName').val() !== '')
		{
			$('#firstNameError').hide();
		}
		if($('#lastName').val() === '')
		{
			$('#lastNameError').show();
			$('#lastNameError').html("Last name can\'t be blank.")
		}
		else if($('#lastName').val() !== '')
		{
			$('#lastNameError').hide();
		}
		if($('#contactNumber').val() === '')
		{
			$('#contactNumberError').show();
			$('#contactNumberError').html("Contact number can\'t be blank.")
		}
		else if($('#contactNumber').val() !== '')
		{
			$('#contactNumberError').hide();
		}
		if($('#year').val() === '')
		{
			$('#yearError').show();
			$('#yearError').html("Year can\'t be blank.")
		}
		else if($('#year').val() !== '')
		{
			$('#yearError').hide();
		}
		if($('#section').val() === '')
		{
			$('#sectionError').show();
			$('#sectionError').html("Section can\'t be blank.")
		}
		else if($('#section').val() !== '')
		{
			$('#sectionError').hide();
		}
		if ($('#studentNumber').val() !== '' && $('#firstName').val() !== '' && $('#contactNumber').val() !== '' && validateEmail(email) && $('#lastName').val() !== '' && $('#year').val() !== '' && $('#section').val() !== '') {
			popUpOkCancel("Do you want to save changes to this scholar?", function() {
				$("#editScholarForm").submit();
			});
		}
	});
	
});