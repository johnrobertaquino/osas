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
	
	$('#searchProgramButton').click(function(event) {
		if($('#programSearchText').val().trim() == '') {
			$('#searchProgramForm').attr("action","displayProgramList");
		}
		$('#searchProgramForm').submit();
	});
	
	$('#addProgramButton').click(function() {
		location.href = "displayAddProgram";
	});

});

function showProgramDeletePopup(programCode) {
	popUpOkCancel("Do you want to delete this Program?", function() {
		$("#deleteProgramForm #programCode").val(programCode);
		$("#deleteProgramForm").submit();
	});
}
c
function displayEditProgram(programCode) {
	$("#editProgramForm #programCode").val(programCode);
	$("#editProgramForm").submit();
}

function addProgram(programCode) {
	$('#addProgramSaveButton').click(function() {
		$("#addProgramForm #programCode").val(programCode);
		$("#addProgramForm").submit();
	});
}