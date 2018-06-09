$(document).ready(function(){
	var startDay = $("#ngayTra").val();
	var endDay = $("#ngayHetHan").val();
	var sDateTmp = startDay.split("-");
	var eDateTmp = endDay.split("-");
	var sDate = new Date(sDateTmp[0], sDateTmp[1] - 1, sDateTmp[2]);
	var eDate = new Date(eDateTmp[0], eDateTmp[1] - 1, eDateTmp[2]);
	
	var diff = eDate - sDate;
	//Từ milliseconds đổi lại qua ngày
	var days = diff / 1000 / 60 / 60 / 24;
	console.log(startDay + 'here');
	console.log(endDay + 'here');
	$('#quaHan').text(days + ' ngày.');
});