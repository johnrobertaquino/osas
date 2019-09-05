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
	
	$('#searchMemberButton').click(function(event) {
		if($('#memberSearchText').val().trim() == '') {
			$('#searchMemberForm').attr("action","displayMemberList");
		}
		$('#searchMemberForm').submit();
	});
	
	$('#addMemberButton').click(function() {
		location.href = "displayAddMember";
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