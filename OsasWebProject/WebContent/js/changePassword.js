/**
 * 
 */
$(document).ready(function() {
	$('#passwordButtonDiv').click(function() {
	if(document.getElementById('password').value == document.getElementbyId('confirmPassword').value)
	{
			$("#changePasswordForm #userId").val(userId);
			$("#changePasswordForm").submit();
	}
	else
		{
			popUp('Please check your password!');
		}
	});
});