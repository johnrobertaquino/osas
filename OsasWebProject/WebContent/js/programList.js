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
		if($('#ProgramSearchText').val().trim() == '') {
			$('#searchProgramForm').attr("action","displayProgramList");
		}
		$('#searchProgramForm').submit();
	});
	
	$('#addProgramButton').click(function() {
		location.href = "displayAddProgram";
	});

});

function showProgramDeletePopup(programId) {
	popUpOkCancel("Do you want to delete this Program?", function() {
		$("#deleteProgramForm #programId").val(programId);
		$("#deleteProgramForm").submit();
	});
}

function displayEditProgram(programId) {
	$("#editProgramForm #programId").val(programId);
	$("#editProgramForm").submit();
}

function addProgram(programId) {
	$('#addProgramSaveButton').click(function() {
		$("#addProgramForm #programId").val(programId);
		$("#addProgramForm").submit();
	});
}