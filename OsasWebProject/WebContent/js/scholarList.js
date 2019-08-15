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
	
	$('#searchScholarButton').click(function(event) {
		if($('#scholarSearchText').val().trim() == '') {
			$('#searchScholarForm').attr("action","displayScholarList");
		}
		$('#searchScholarForm').submit();
	});
	
	$('#addScholarButton').click(function() {
		location.href = "displayAddScholar";
	});
});

function showScholarDeletePopup(scholarId) {
	popUpOkCancel("Do you want to delete this scholar?", function() {
		$("#deleteScholarForm #scholarId").val(scholarId);
		$("#deleteScholarForm").submit();
	});
}

function displayEditScholar(scholarId) {
	$("#editScholarForm #scholarId").val(scholarId);
	$("#editScholarForm").submit();
}

function addScholar(scholarId) {
	$('#addScholarSaveButton').click(function() {
		$("#addScholarForm #scholarId").val(scholarId);
		$("#addScholarForm").submit();
	});
}