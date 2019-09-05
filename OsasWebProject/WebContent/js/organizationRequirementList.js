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
	
	$('#searchOrganizationRequirementButton').click(function(event) {
		if($('#organizationRequirementSearchText').val().trim() == '') {
			$('#searchOrganizationRequirementForm').attr("action","displayOrganizationRequirementList");
		}
		$('#searchOrganizationRequirementForm').submit();
	});
	
	$('#addOrganizationRequirementButton').click(function() {
		location.href = "displayAddOrganizationRequirement";
	});
	
});

function showOrganizationRequirementDeletePopup(organizationRequirementId) {
	popUpOkCancel("Do you want to delete this organization requirement?", function() {
		$("#deleteOrganizationRequirementForm #organizationRequirementId").val(organizationRequirementId);
		$("#deleteOrganizationRequirementForm").submit();
	});
}


function displayEditOrganizationRequirement(organizationRequirementId) {
	$("#editOrganizationRequirementForm #organizationRequirementId").val(organizationRequirementId);
	$("#editOrganizationRequirementForm").submit();
}

function addOrganizationRequirement(organizationRequirementId) {
	$('#addOrganizationRequirementSaveButton').click(function() {
		$("#addOrganizationRequirementForm #organizationRequirementId").val(organizationRequirementId);
		$("#addOrganizationRequirementForm").submit();
	}); 
}

