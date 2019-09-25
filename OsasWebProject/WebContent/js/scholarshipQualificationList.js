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
	
	$('#searchScholarshipQualificationButton').click(function(event) {
		if($('#scholarshipQualificationSearchText').val().trim() == '') {
			$('#searchScholarshipQualificationForm').attr("action","displayScholarshipQualificationList");
		}
		$('#searchScholarshipQualificationForm').submit();
	});
	
	$('#backScholarshipQualification').click(function(event) {
		$("#backScholarshipQualificationForm").submit();
	});
	
	$('#addScholarshipQualificationButton').click(displayAddScholarshipQualification);
	
});

function showScholarshipQualificationDeletePopup(scholarshipQualificationId) {
	popUpOkCancel("Do you want to delete this scholarship Qualification?", function() {
		$("#deleteScholarshipQualificationForm #scholarshipQualificationId").val(scholarshipQualificationId);
		$("#deleteScholarshipQualificationForm").submit();
	});
}


function displayAddScholarshipQualification() {
	$("#addScholarshipQualificationForm").submit();
}

function displayEditScholarshipQualification(scholarshipQualificationId) {
	$("#editScholarshipQualificationForm #scholarshipQualificationId").val(scholarshipQualificationId);
	$("#editScholarshipQualificationForm").submit();
}

function addScholarshipQualification(scholarshipQualificationId) {
	$('#addScholarshipQualificationSaveButton').click(function() {
		$("#addScholarshipQualificationForm #scholarshipQualificationId").val(scholarshipQualificationId);
		$("#addScholarshipQualificationForm").submit();
	}); 
}

