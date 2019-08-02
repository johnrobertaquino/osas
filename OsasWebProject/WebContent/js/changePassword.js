/**
 * 
 **/
$(document).ready(function() {
	$('#passwordButtonDiv').click(function() {
		if($("#password").val() == $("#confirmPassword").val()){
			$("#changePasswordForm").submit();
		}
		else
		{
			popUp('Password and Confirm Password are not equal.');
		}
	});
});