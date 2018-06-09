<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/xemsach.css" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xem Sách</title>
</head>
<body>
	<div class="header col-md-12 navbar-fixed-top">
		<%@ include file="common/header.jsp" %>
	</div>
	<!-- body go here -->
	<div class="fist container">
		<div class="row">
			<div class="col-md-2">
				<label class="label1">ID Sách:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${sach.idSach}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Tên Sách:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${sach.tenSach}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Tác Giả:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${sach.tacGia}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Số lượng:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${sach.soLuong}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Giá:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${sach.gia}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Ngày thêm:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${sach.ngayThem}</label>
			</div>
		</div>
		<c:if test = "${sach.ngayCapNhat != null}">
	   		<div class="row">
	   			<div class="col-md-2">
					<label class="label1">Ngày cập nhật:</label>
				</div>
				<div class="col-md-10">
				<label class="label2">${sach.ngayCapNhat}</label>
			</div>
			</div>
		</c:if>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Loại:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${sach.loai}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Hạn mượn:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${sach.thoiHanMuon}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Mô tả</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${sach.moTa}</label>
			</div>
		</div>
	</div>
	<div class="footer">
		<%@ include file="common/footer.jsp" %>
	</div>
</body>
</html>