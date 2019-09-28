/**
 * 
 */
$(document).ready(function() {
	
	
	$('#loginButtonDiv').click(function() {
		if($('#userName').val() === '' && $('#password').val() === '') {
			popUp('Username and password can\'t be blank.');
		}
		else if($('#userName').val() === '') {
			popUp('Username can\'t be blank.');
		}
		else if($('#password').val() === '') {
			popUp('Password can\'t be blank.');
		}
		else {
			$('#loginForm').submit();
		}
	});
	
	$(document).keypress(function (e) {
		var key = e.which;
		if(key == 13)  // the enter key code
		{
			$('#loginButtonDiv').trigger("click");
			return false;  
		}
	});   
	
});