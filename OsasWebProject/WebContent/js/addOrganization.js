$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayOrganizationList";
	});
    $("#programDiv").hide();
    
	 $(function () {
	        $("#acadCheck").click(function () {
	            if ($(this).is(":checked")) {
	                $("#programDiv").show();
	            } else {
	                $("#programDiv").hide();
	            }
	        });
	    });
	 
	 $(function () {
	        $("#nonAcadCheck").click(function () {
	            if ($(this).is(":checked")) {
	                $("#programDiv").hide();
	            } else {
	            }
	        });
	    });
	 
		$("#organizationName").keypress(function (e) {
	        var keyCode = e.keyCode || e.which;

	        //Regex for Valid Characters i.e. Numbers.
	        var regex = /^[a-zA-Z\s]+$/;

	        //Validate TextBox value against the Regex.
	        var isValid = regex.test(String.fromCharCode(keyCode));
	        return isValid;
	    });
		
		$("#adviser").keypress(function (e) {
	        var keyCode = e.keyCode || e.which;

	        //Regex for Valid Characters i.e. Numbers.
	        var regex = /^[a-zA-Z\s]+$/;

	        //Validate TextBox value against the Regex.
	        var isValid = regex.test(String.fromCharCode(keyCode));
	        return isValid;
	    });
	
	$('#submitButton').click(function(event) {
	
		if($('#organizationName').val() === '')
		{
			$('#organizationNameError').show();
			$('#organizationNameError').html("Organization name can\'t be blank.")
		}
		else if($('#organizationName').val() !== '')
		{
			$('#organizationNameError').hide();
		}
		if($('#description').val() === '')
		{
			$('#descriptionError').show();
			$('#descriptionError').html("Description can\'t be blank.");
		}
		else if($('#description').val() !== '')
		{
			$('#descriptionError').hide();
		}
		if ($('#organizationName').val() !== '' && $('#description').val() !== '') {
			popUpOkCancel("Do you want to add this organization?", function() {
				$("#organizationForm").submit();
			});
		}
	});
	
});