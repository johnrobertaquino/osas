/**
 * 
 */
$(document).ready(function() {
	$('#logoutMenu').click(function(event) {
		$('#logoutForm').submit();
	});
	
	$('#homeLink').click(function(event) {
		location.href = "home";
	});
	
	$('#changePasswordMenu').click(function() {
		location.href = "displayChangePassword";
	});
	
	$('#submitButton').click(function() {
		popUpOkCancel("If you are in 1st Semester and you have scholars/organizations qualifications that are being checked yearly, requirements submitted will be retained. Otherwise, all requirements submitted will be deleted.", function() {
			$("#manageSemesterForm").submit();
		});
	});
	
	$('#cancelButton').click(function() {
		location.href = "home";
	});
	
	
});

function popUp(errorMessage) {
	$('#errorMessage').html(errorMessage);
	$('#overlay').show();
	$('#popupOk').off().click(function(event) {
		popUpClose();
	});
	$('#popupCancel').hide();
	$('#xButton').off().click(function(event) {
		popUpClose();
	});
}

function popUpOk(errorMessage, okFunction) {
	$('#errorMessage').html(errorMessage);
	$('#overlay').show();
	$('#popupOk').off().click(function(event) {
		okFunction();
		popUpClose();
	});
	$('#popupCancel').hide();
	$('#xButton').off().click(function() {
		popUpClose();
	});
}

function popUpOkCancel(errorMessage, okFunction) {
	$('#errorMessage').html(errorMessage);
	$('#overlay').show();
	$('#popupOk').off().click(function(event) {
		okFunction();
		popUpClose();
	});
	$('#popupCancel').show();
	$('#popupCancel').off().click(function(event) {
		popUpClose();
	});
	$('#xButton').off().click(function(event) {
		popUpClose();
	});
}

function popUpClose() {
	$('#errorMessage').html('');
	$('#overlay').hide();
}