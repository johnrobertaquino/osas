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
	
	$('#backOrganizationQualification').click(function(event) {
		$("#backOrganizationQualificationForm").submit();
	});
	
});

function showOrganizationQualificationApprovePopup(organizationQualificationId) {
	popUpOkCancel("Do you want to approve this organization requirement?", function() {
		$("#approveOrganizationQualificationForm #organizationQualificationId").val(organizationRequirementId);
		$("#approveOrganizationQualificationForm").submit();
	});
}

function displayEditOrganizationQualification(organizationQualificationId) {
	$("#editOrganizationQualificationForm #organizationQualificationId").val(organizationRequirementId);
	$("#editOrganizationQualificationForm").submit();
}

function showAddOrganizationQualification(organizationRequirementId) {
		$("#showAddOrganizationQualificationForm #organizationRequirementId").val(organizationRequirementId);
		$("#showAddOrganizationQualificationForm").submit();
}

function addOrganizationQualification(OrganizationQualificationId) {
	$('#addOrganizationQualificationSaveButton').click(function() {
		$("#addOrganizationQualificationForm #organizationQualificationId").val(organizationQualificationId);
		$("#addOrganizationQualificationForm").submit();
	}); 
}



