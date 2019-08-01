/**
 * 
 */
$(document).ready(function() {
	$('#logoutMenu').click(function() {
		event.stopPropagation();
		$('#logoutForm').submit();
	});
	
	$('#homeLink').click(function() {
		event.stopPropagation();
		location.href = "home";
	});
});

function popUp(errorMessage) {
	$('#errorMessage').html(errorMessage);
	$('#overlay').show();
	$('#popupOk').click(function() {
		event.stopPropagation();
		popUpClose();
	});
	$('#xButton').click(function() {
		event.stopPropagation();
		popUpClose();
	});
}

function popUpOk(errorMessage, okFunction) {
	$('#errorMessage').html(errorMessage);
	$('#overlay').show();
	$('#popupOk').click(function() {
		okFunction();
	});
	$('#xButton').click(function() {
		popUpClose();
	});
}

function popUpClose() {
	$('#errorMessage').html('');
	$('#overlay').hide();
}