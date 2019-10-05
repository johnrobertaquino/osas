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
		var errorMessage = '';
		
		if($('#studentNumber').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Student number can\'t be blank.";
		}
		
		var $result = $("#result");
		var email = $("#email").val();
		$result.text("");

		if (validateEmail(email)) {
		} else {
			if (errorMessage !== '') {
			errorMessage = errorMessage + "<br/>";
				}
			errorMessage = errorMessage + "You entered invalid email address.";
		}
			
		if($('#firstName').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "First name can\'t be blank.";
		}
		if($('#lastName').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Last name can\'t be blank.";
		}
		if($('#year').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Year can\'t be blank.";
		}
		if($('#section').val() === '')
		{
			if (errorMessage !== '') {
				errorMessage = errorMessage + "<br/>";
			}
			errorMessage = errorMessage + "Section can\'t be blank.";
		}
		if (errorMessage == '') {
			popUpOkCancel("Do you want to add this scholar?", function() {
				$("#scholarForm").submit();
			});
		}
		else {
			popUp(errorMessage);
		}
	});
	
	$('#addScholarButton').click(function() {
		location.href = "displayScholarList";
	});
	
});