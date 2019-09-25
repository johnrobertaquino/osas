/**
 * 
 */
$(document).ready(function() {

	$('#cancelButton').click(function(event) {
		location.href = "home";
	});
	
	$('#submitButton').click(function(event) {
		$('#scholarshipReportForm').submit();
	});
	

});