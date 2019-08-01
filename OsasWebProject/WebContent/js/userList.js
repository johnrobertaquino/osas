/**
 * 
 */
$(document).ready(function() {
	
	$(document).click(function(){
		$(".tableMenuDropdown").each(function() {
			if($(this).hasClass("w3-show")) {
				$(this).toggleClass("w3-show");
			}
		});
	});
	
	
	$('.tableMenu .tableMenuButton').click(function(event) {
		event.stopPropagation();
		$(this).parent().find(".tableMenuDropdown").toggleClass("w3-show");
	});
	
});