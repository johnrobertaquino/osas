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
	
	
	 $("#filterSelect").change(function () {
		$("#filterMemberForm #filter").val($('#filterSelect option:selected').val());
		$("#filterMemberForm").submit();
   });
	
	$('#searchMemberButton').click(function(event) {
		if($('#memberSearchText').val().trim() == '') {
			$('#searchMemberForm').attr("action","displayMemberList");
		}
		$('#searchMemberForm').submit();
	});
	
	$('#addMemberButton').click(function() {
		location.href = "displayAddMember";
	});
	
	$('#addMemberExcelFileButton').click(function() {
		location.href = "displayAddMemberExcelFile";
	});
	
	$('.showPicture').click(function(event) {
		event.stopPropagation();
		var imageUrl = "download?type=OF&fileName=" + $(this).text();
		
		var center_left = (screen.width / 2) - (100 / 2);
		var center_top = (screen.height / 2) - (100 / 2);

		my_window = window.open(imageUrl, $(this).text(), "scrollbars=1, width=100, height=100, left="+center_left+", top="+center_top);
		my_window.focus();
	});
});

function showMemberDeletePopup(memberId) {
	popUpOkCancel("Do you want to delete this member?", function() {
		$("#deleteMemberForm #memberId").val(memberId);
		$("#deleteMemberForm").submit();
	});
}

function displayEditMember(memberId) {
	$("#editMemberForm #memberId").val(memberId);
	$("#editMemberForm").submit();
}

function addMember(memberId) {
	$('#addMemberSaveButton').click(function() {
		$("#addMemberForm #memberId").val(memberId);
		$("#addMemberForm").submit();
	});
}

function addMemberExcelFile(memberId) {
	$('#addMemberExcelFileSaveButton').click(function() {
		$("#addMemberExcelFileForm #memberId").val(memberId);
		$("#addMemberExcelFileForm").submit();
	});
}