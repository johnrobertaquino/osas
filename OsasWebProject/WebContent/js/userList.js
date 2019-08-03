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
	
});

function showUserDeletePopup(userId) {
	popUpOkCancel("Do you want to delete this user?", function() {
		$("#deleteUserForm #userId").val(userId);
		$("#deleteUserForm").submit();
	});
}

$(document).ready(function() {
	$('#addUserButton').click(function() {
		event.stopPropagation();
		location.href = "addUser";
	});
});