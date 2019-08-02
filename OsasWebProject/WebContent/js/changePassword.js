/**
 * 
 **/
$(document).ready(function() {
	
	$('#passwordButtonDiv').click(function() {
		if($('#oldPassword').val() === '' && $('#password').val() === '' && $('#confirmPassword').val() === '') {
			popUp('Old password, password and confirm password can\'t be blank.');
		}
		else if($('#oldPassword').val() === '')
		{
			popUp('Old password can\'t be blank.');
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
			$("#changePasswordForm").submit();
		}
		
	});
});