$( document ).ready(function() {
/*	$(document).on('click', '#kiemTra', function(){
		var idThanhVien = $("#idThanhVien").val();
		var idSachTemp = $("#text").val();
		console.log(idSachTemp);
		var listIdSachTemp = idSachTemp.split(/\r\n|\r|\n/g);
		console.log(listIdSachTemp[0] + ' + ' + listIdSachTemp[1]);
		var listIdSach = new Array();
		$.each(listIdSachTemp, function( index, value ) {
			listIdSach.push($.trim(value));
		});
		$("#error").text("Phải nhập id thành viên hoặc id sách trước khi kiểm tra!");
		console.log(listIdSach[0] + ' + ' + listIdSach[1]);
		$.ajax({
	 		type: 'GET', 
	 		url: 'kiemtratrasachajax.html',
	 		contentType: 'application/json; charset=UTF-8',
	 		dataType: 'json',
	 		data: { "idThanhVien": idThanhVien, "listIdSach": listIdSach },
	 		success: function (results) {
	 			if(results != null){
	 				if(results == "error"){
	 					$("#error").text("Phải nhập id thành viên hoặc id sách trước khi kiểm tra!");
	 				}else{
	 					results = "Các id sách sau không hợp lệ:<br>" + results;
		 				$("#error").text(results);
	 				}
	 			}else{
	 				$("#success").text("Check successfully with no error!");
	 				$("#btnForm").html("<button id='kiemTra' class='btn btn-success' type='submit'>Hoàn Tất</button>");
	 			}
	 		}
		 });
	});*/
	$(document).on('click', '#idSach', function(){
		$("#success").text('');
		$("#error").text('');
	 });
	$(document).on('click', '#idThanhVien', function(){
		$("#success").text('');
		$("#error").text('');
	 });
	$(document).on('click', '#text', function(){
		$("#success").text('');
		$("#error").text('');
	 });
});










