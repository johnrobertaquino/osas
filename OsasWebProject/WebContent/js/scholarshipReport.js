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
	
	$("#semTermId").change(function () {
		$.ajax({
	        url: "/getScholarshipProgramListRestWS?semTermId=" + $('#semTermId option:selected').val()
	    }).then(function(data) {
	    	$('#scholarshipProgramId').empty();
	    	if(data.error) {
	    	  
	    	} else {
	    		if(data.result) {
	    			for (key in data.result) {  
	    				var scholarshipProgram = data.result[key];
	    				$('#scholarshipProgramId').append('<option value="' + scholarshipProgram.scholarshipProgramId + '">' + scholarshipProgram.scholarshipProgramName + '</option>');
	    			}
	    		}
	       }
	    });
		
		$.ajax({
	        url: "/getProgramListRestWS?semTermId=" + $('#semTermId option:selected').val()
	    }).then(function(data) {
	    	$('#program').empty();
	    	if(data.error) {
	    	  
	    	} else {
	    		if(data.result) {
	    			for (key in data.result) {  
	    				var program = data.result[key];
	    				$('#program').append('<option value="' + program.programCode + '">' + program.programName + '</option>');
	    			}
	    		}
	       }
	    });
     });
	
	$("#semTermId").trigger('change');

});