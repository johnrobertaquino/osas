$(document).ready(function() {
	
	$('#submitButton').click(function() {
		popUpOkCancel("If you are in 1st Semester and you have scholars/organizations qualifications that are being checked yearly, requirements submitted will be retained. Otherwise, all requirements submitted will be deleted.", function() {
			$("#manageSemesterForm").submit();
		});
	});
	
	$('#cancelButton').click(function() {
		location.href = "home";
	});
});