$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayUserList";
	});
	
	$(function() {
		  $( "#birthday" ).datepicker({  maxDate: 0 });
		});
	
	$("#contactNumber").keypress(function (e) {
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
	
	$("#position").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[a-zA-Z\s]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });
	
	
	$('#submitButton').click(function(event) {
		var selectedRoleCount = 0;
		var isUserRoleSelected = false;
		$.each($("input[name='roleReferenceCodeList']:checked"), function(){
			selectedRoleCount++;
			if($(this).val() == 'US') {
				isUserRoleSelected = true;
			}
        });
		
		if (selectedRoleCount > 1 && isUserRoleSelected) {
			$('#roleError').show();
			$('#roleError').html("Administrator/Approver role can't be selected if User role is already selected.");
		}
		else if (!(selectedRoleCount > 1 && isUserRoleSelected)) {
			$('#roleError').hide();
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
		if($('#birthday').val() === '')
		{
			$('#birthdayError').show();
			$('#birthdayError').html("Birthday can\'t be blank.");
		}
		else if($('#birthday').val() !== '')
		{
			$('#birthdayError').hide();
		}
		if($('#contactNumber').val() === '')
		{
			$('#contactNumberError').show();
			$('#contactNumberError').html("Contact number can\'t be blank.");
		}
		else if($('#contactNumber').val() !== '')
		{
			$('#contactNumberError').hide();
		}
		if($('#position').val() === '')
		{
			$('#positionError').show();
			$('#positionError').html("Position can\'t be blank.");
		}
		else if($('#position').val() !== '')
		{
			$('#positionError').hide();
		}
		if(selectedRoleCount === 0)
		{
			$('#roleError').show();
			$('#roleError').html("No User role selected.");
		}
		else if(selectedRoleCount !== 0)
		{
			$('#fileError').hide();
		}
		if (!(selectedRoleCount > 1 && isUserRoleSelected) && $('#firstName').val() !== '' && $('#lastName').val() !== '' && $('#birthday').val() !== '' && $('#contactNumber').val() !== '' && $('#position').val() !== '' && selectedRoleCount !== 0) {
			popUpOkCancel("Do you want to add this user?", function() {
				$("#addUserForm").submit();
			});
		}
	});
	
});