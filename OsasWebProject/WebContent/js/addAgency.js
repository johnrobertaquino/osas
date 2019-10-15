$(document).ready(function() {
	$('#cancelButton').click(function(event) {
		location.href = "displayAgencyList";
	});
	
	$("#contactNumber").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[0-9]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });
	
	$("#contactPerson").keypress(function (e) {
        var keyCode = e.keyCode || e.which;

        //Regex for Valid Characters i.e. Numbers.
        var regex = /^[a-zA-Z\s]+$/;

        //Validate TextBox value against the Regex.
        var isValid = regex.test(String.fromCharCode(keyCode));
        return isValid;
    });

	
	$('#submitButton').click(function(event) {
		
		if($('#agencyName').val() === '')
		{
			$('#agencyNameError').show();
			$('#agencyNameError').html("Agency name can\'t be blank.")
		}
		else if($('#agencyName').val() !== '')
		{
			$('#agencyNameError').hide();			
		}
		if($('#address').val() === '')
		{
			$('#addressError').show();
			$('#addressError').html("Addres can\'t be blank.")
		}
		else if ($('#address').val() !== '')
		{
			$('#addressError').hide();	
		}
		if($('#contactPerson').val() === '')
		{
			$('#contactPersonError').show();
			$('#contactPersonError').html("Contact Person can\'t be blank.")
		}
		else if ($('#contactPerson').val() !== '')
		{
			$('#contactPersonError').hide();	
		}
		if($('#contactNumber').val() === '')
		{
			$('#contactNumberError').show();
			$('#contactNumberError').html("Contact Number can\'t be blank.")
		}
		else if ($('#contactNumber').val() !== '')
		{
			$('#contactNumberError').hide();	
		}
		if ($('#agencyName').val() !== '' && $('#address').val() !== '' && $('#contactPerson').val() !== '' && $('#contactNumber').val() !== '') {
			popUpOkCancel("Do you want to add this agency?", function() {
				$("#agencyForm").submit();
			});
		}
	});
	
});