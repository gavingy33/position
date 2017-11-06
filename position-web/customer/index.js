var customerIndex = function() {

	function customerDetail() {
		$.ajax({
			url : "/position-app/customer/query",
			type : "GET",
			data : undefined,
			success : function(mutualDTO) {
				alert(JSON.stringify(mutualDTO));
			}
		});
		$.ajax({
			url : "/position-app/customer/query",
			type : "GET",
			data : undefined,
			success : function(mutualDTO) {
				alert(JSON.stringify(mutualDTO));
			}
		});
	}


	return {
		onload : function() {
			customerDetail();
		}
	}
}();

$(function() {
	customerIndex.onload();
});