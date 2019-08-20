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
	
	$('#searchAgencyButton').click(function(event) {
		if($('#agencySearchText').val().trim() == '') {
			$('#searchAgencyForm').attr("action","displayAgencyList");
		}
		$('#searchAgencyForm').submit();
	});
	
	$('#addAgencyButton').click(function() {
		location.href = "displayAddAgency";
	});
	
	$('#scholarshipTermButton').click(function() {
		location.href = "displayScholarshipTermList";
	});
});

function showAgencyDeletePopup(agencyId) {
	popUpOkCancel("Do you want to delete this agency?", function() {
		$("#deleteAgencyForm #agencyId").val(agencyId);
		$("#deleteAgencyForm").submit();
	});
}

function showUserResetPasswordPopup(userId) {
	popUpOkCancel("Do you want to reset password of this user?", function() {
		$("#resetPasswordForm #userId").val(userId);
		$("#resetPasswordForm").submit();
	});
}

function displayEditAgency(agencyId) {
	$("#editAgencyForm #agencyId").val(agencyId);
	$("#editAgencyForm").submit();
}

function addAgency(agencyId) {
	$('#addAgencySaveButton').click(function() {
		$("#addAgencyForm #agencyId").val(agencyId);
		$("#addAgencyForm").submit();
	});
}