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
	
	$('#searchScholarshipProgramButton').click(function(event) {
		if($('#scholarshipProgramSearchText').val().trim() == '') {
			$('#searchScholarshipProgramForm').attr("action","displayScholarshipProgramList");
		}
		$('#searchScholarshipProgramForm').submit();
	});
	
	$('#addScholarshipProgramButton').click(function() {
		location.href = "displayAddScholarshipProgram";
	});
	
	$('#displayScholarshipQualification').click(function() {
		location.href = "displayScholarshipQualificationList";
	});
});

function displayScholarshipQualification(scholarshipProgramId) {
	location.href = "displayScholarshipQualificationList";
}

function showScholarshipProgramDeletePopup(scholarshipProgramId) {
	popUpOkCancel("Do you want to delete this scholarship program?", function() {
		$("#deleteScholarshipProgramForm #scholarshipProgramId").val(scholarshipProgramId);
		$("#deleteScholarshipProgramForm").submit();
	});
}

function displayEditScholarshipProgram(scholarshipProgramId) {
	$("#editScholarshipProgramForm #scholarshipProgramId").val(scholarshipProgramId);
	$("#editScholarshipProgramForm").submit();
}

function addScholarshipProgram(scholarshipProgramId) {
	$('#addScholarshipProgramSaveButton').click(function() {
		$("#addScholarshipProgramForm #scholarshipProgramId").val(scholarshipProgramId);
		$("#addScholarshipProgramForm").submit();
	}); 
}

