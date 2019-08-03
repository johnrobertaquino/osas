/**
 * 
 **/
$(document).ready(function() {
	
	$('#passwordButtonDiv').click(function() {
		if($('#userName').val() === '' && $('#password').val() === '' && $('#confirmPassword').val() === '') {
			popUp('Username, password and confirm password can\'t be blank.');
		}
		else if($('#userName').val() === '')
		{
			popUp('Username can\'t be blank.');
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
			$("#firstTimeLoginForm").submit();
		}
		
	});
});