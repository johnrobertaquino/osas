$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		$("#cancelOrganizationRequirementForm").submit();
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
		
		if($('#organizationRequirementName').val() === '')
		{
			$('#organizationRequirementNameError').show();
			$('#organizationRequirementNameError').html("Organization Requirement name can\'t be blank.")
		}
		if ($('#organizationRequirementName').val() !== '') {
			popUpOkCancel("Do you want to save changes to this organization requirement?", function() {
				$("#editOrganizationRequirementForm").submit();
			});
		}
	});
	
});