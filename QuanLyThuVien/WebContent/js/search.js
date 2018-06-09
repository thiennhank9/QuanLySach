$( document ).ready(function() {
	$(document).on('input', '#search', function(){
		var search = $("#search").val();
		var searchLength = search.length;
		if(searchLength == 0){
			$(".results").css('display', 'none');
		}
		if(searchLength > 3){
			$.ajax({
		 		type: 'GET', 
		 		url: 'searchajax.html',
		 		contentType: 'application/json; charset=UTF-8',
		 		dataType: 'json',
		 		data: { "search": search },
		 		success: function (results) {
		 			var $results = $('<ul class="results" ></ul>');
		 			var flag = 0;
		 			$.each(results, function(i, el) {
		 				var $li = $('<li>'+
		 								'<a href="xemsach.html?idSach='
		 									+el["id"]+'"><strong>'+el["id"]+" | "+el["tensach"]+'</strong><br />'+
		 									'<span>Mô tả: '+el["mota"]+'</span>'+
		 								'</a>'+
		 							'</li>');
		 				flag = flag + 1;
		 				$results.append($li);
		 		    });
		 			if(flag == 0){
		 				var $li = $('<li><a>Nothing found!</a></li>');
		 				$results.append($li);
		 			}
		 			$("#contain").html($results);
		 		}
			 }),'json';
		}
	});
	
	
	$("#search").focus(function(){
	    $(".results").css('display', 'block');
	});
	
	$("#search").blur(function(){
		var search = $("#search").val();
	    var searchLength = search.length;
	    if(searchLength <= 3){
	    	$("#contain").html("");
	    }
	});
	
	$(document).click(function(event) {
		var contain= $("#contain");
		var search= $("#search");
		if (!contain.is(event.target)){
			if (!search.is(event.target)){
			$(".results").css('display', 'none');
			}
		}
	});
});