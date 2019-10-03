/**
 * 
 */
$(document).ready(function() {

	$('#cancelButton').click(function(event) {
		location.href = "home";
	});
	
	$('#submitButton').click(function(event) {
		$('#organizationReportForm').submit();
	});
	
	$("#yearlyTermId").change(function () {
		/*$.ajax({
	        url: "/getSemTermListRestWS?yearlyTermId=" + $('#yearlyTermId option:selected').val()
	    }).then(function(data) {
	    	$('#semTermId').empty();
	    	if(data.error) {
	    	  
	    	} else {
	    		if(data.result) {
	    			for (key in data.result) {  
	    				var semTerm = data.result[key];
	    				$('#semTermId').append('<option value="' + semTerm.semTermId + '">' + semTerm.semTermName + '</option>');
	    			}
	    		}
	       }
	    });*/
		
		$.ajax({
	        url: "/getSemTermListRestWS?yearlyTermId=" + $('#yearlyTermId option:selected').val()
	    }).then(function(data) {
	    	$('#semTerm').empty();
	    	if(data.error) {
	    	  
	    	} else {
	    		if(data.result) {
	    			for (key in data.result) {  
	    				var semTerm = data.result[key];
	    				$('#semTerm').append('<option value="' + semTerm.semTermId + '">' + semTerm.semTermName + '</option>');
	    			}
	    		}
	       }
	    });
     });
	
	$("#yearlyTermId").trigger('change');

});