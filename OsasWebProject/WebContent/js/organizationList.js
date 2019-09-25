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
	
	$('.showPicture').click(function(event) {
		event.stopPropagation();
		var imageUrl = "download?type=OL&fileName=" + $(this).text();
		
		var center_left = (screen.width / 2) - (100 / 2);
		var center_top = (screen.height / 2) - (100 / 2);

		my_window = window.open(imageUrl, $(this).text(), "scrollbars=1, width=100, height=100, left="+center_left+", top="+center_top);
		my_window.focus();
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

