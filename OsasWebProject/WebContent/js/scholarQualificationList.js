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
	
	/*$('#searchScholarQualificationButton').click(function(event) {
		if($('#scholarQualificationSearchText').val().trim() == '') {
			$('#searchScholarQualificationForm').attr("action","displayScholarQualificationList");
		}
		$('#searchScholarshipQualificationForm').submit();
	});*/
});

function showScholarQualificationApprovePopup(scholarQualificationId) {
	popUpOkCancel("Do you want to approve this scholar requirement?", function() {
		$("#approveScholarQualificationForm #scholarQualificationId").val(scholarQualificationId);
		$("#approveScholarQualificationForm").submit();
	});
}

function displayEditScholarQualification(scholarQualificationId) {
	$("#editScholarQualificationForm #scholarQualificationId").val(scholarQualificationId);
	$("#editScholarQualificationForm").submit();
}

function showAddScholarQualification(scholarshipQualificationId) {
		$("#showAddScholarQualificationForm #scholarshipQualificationId").val(scholarshipQualificationId);
		$("#showAddScholarQualificationForm").submit();
}

function addScholarQualification(scholarQualificationId) {
	$('#addScholarQualificationSaveButton').click(function() {
		$("#addScholarQualificationForm #scholarQualificationId").val(scholarQualificationId);
		$("#addScholarQualificationForm").submit();
	}); 
}



