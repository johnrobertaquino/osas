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
	
	$('#searchUserButton').click(function(event) {
		if($('#userSearchText').val().trim() == '') {
			$('#searchUserForm').attr("action","displayUserList");
		}
		$('#searchUserForm').submit();
	});
	
	$('#addUserButton').click(function() {
		location.href = "displayAddUser";
	});
});

function showUserDeletePopup(userId) {
	popUpOkCancel("Do you want to delete this user?", function() {
		$("#deleteUserForm #userId").val(userId);
		$("#deleteUserForm").submit();
	});
}

function displayEditUser(userId) {
	$("#editUserForm #userId").val(userId);
	$("#editUserForm").submit();
}

function addUser(userId) {
	$('#addUserSaveButton').click(function() {
		$("#addUserForm #userId").val(userId);
		$("#addUserForm").submit();
	});
}