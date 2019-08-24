/**
 * 
 */
$(document).ready(function() {
	
	$(document).click(function(event){
		$(".tableMenuDropdown").each(function() {
			if($(this).hasClass("w3-show")) {
				$(this).toggleClass("w3-show");
			}
		});
	});
	
	
	$('.tableMenu .tableMenuButton').click(function(event) {
		event.stopPropagation();
		$(".tableMenuDropdown").each(function() {
			if($(this).hasClass("w3-show")) {
				$(this).toggleClass("w3-show");
			}
		});
		$(this).parent().find(".tableMenuDropdown").toggleClass("w3-show");
	});
	
	$('#searchScholarshipTermButton').click(function(event) {
		if($('#scholarshipTermSearchText').val().trim() == '') {
			$('#searchScholarshipTermForm').attr("action","displayScholarshipTermList");
		}
		$('#searchScholarshipTermForm').submit();
	});
	
	$('#addScholarshipTermButton').click(function() {
		location.href = "displayAddScholarshipTerm";
	});
});

function displayEditScholarshipTerm(scholarshipTermId) {
	$("#editScholarshipTermForm #scholarshipTermId").val(scholarshipTermId);
	$("#editScholarshipTermForm").submit();
}

function addScholarshipTerm(scholarshipTermId) {
	$('#addScholarshipTermSaveButton').click(function() {
		$("#addScholarshipTermForm #scholarshipTermId").val(scholarshipTermId);
		$("#addScholarshipTermForm").submit();
	});
}