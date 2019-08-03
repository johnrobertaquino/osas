/**
 * 
 **/
$(document).ready(function() {
	
	$('#passwordButtonDiv').click(function() {
		if($('#password').val() === '' && $('#confirmPassword').val() === '') {
			popUp('Password and confirm password can\'t be blank.');
		}
		else if($('#password').val() === '')
		{
			popUp('Password can\'t be blank.');
		}
		else if($('#confirmPassword').val() === '')
		{
			popUp('Confirm Password can\'t be blank.');
		}
		else if($("#password").val() != $("#confirmPassword").val()){
			popUp('Password and Confirm Password are not equal.');
		}
		else
		{
			$("#passwordResetForm").submit();
		}
		
	});
});