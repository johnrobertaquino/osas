/**
 * 
 */
$(document).ready(function() {
	
	
	$('#loginButtonDiv').click(function() {
		$('#loginForm').submit();
	});
	
	$('#xButton').click(function() {
		popUpClose();
	});
});

function popUp(errorMessage) {
	$('#errorMessage').html(errorMessage);
	$('#overlay').show();
}

function popUpClose() {
	$('#errorMessage').html('');
	$('#overlay').hide();
}