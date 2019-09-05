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
	
	$('#searchOrganizationButton').click(function(event) {
		if($('#organizationSearchText').val().trim() == '') {
			$('#searchOrganizationForm').attr("action","displayOrganizationList");
		}
		$('#searchOrganizationForm').submit();
	});
	
	$('#addOrganizationButton').click(function() {
		location.href = "displayAddOrganization";
	});
});

function showOrganizationDeletePopup(organizationId) {
	popUpOkCancel("Do you want to delete this organization?", function() {
		$("#deleteOrganizationForm #organizationId").val(organizationId);
		$("#deleteOrganizationForm").submit();
	});
}

function displayOrganizationRequirementList(organizationId) {
	$("#showOrganizationRequirementForm #organizationId").val(organizationId);
	$("#showOrganizationRequirementForm").submit();
}

function displayEditOrganization(organizationId) {
	$("#editOrganizationForm #organizationId").val(organizationId);
	$("#editOrganizationForm").submit();
}

function addOrganization(organizationId) {
	$('#addOrganizationSaveButton').click(function() {
		$("#addOrganizationForm #organizationId").val(organizationId);
		$("#addOrganizationForm").submit();
	});
}