/**
 * 
 */
$(document).ready(function() {
	$('#logoutMenu').click(function() {
		$('#logoutForm').submit();
	});
});

function popUp(errorMessage) {
	$('#errorMessage').html(errorMessage);
	$('#overlay').show();
	$('#popupOk').click(function() {
		popUpClose();
	});
	$('#xButton').click(function() {
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