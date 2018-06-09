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
<title>Xem Thành Viên</title>
</head>
<body>
	<div class="header col-md-12 navbar-fixed-top">
		<%@ include file="common/header.jsp" %>
	</div>
	<!-- body go here -->
	<div class="fist container">
		<div class="row">
			<div class="col-md-2">
				<label class="label1">ID Thành Viên:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${thanhVien.idThanhVien}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Tên Thành Viên:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${thanhVien.tenThanhVien}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Email:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${thanhVien.email}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Ngày Sinh:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${thanhVien.ngaySinh}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Tình trạng:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${thanhVien.tinhTrang}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Ngày thêm:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${thanhVien.ngayThem}</label>
			</div>
		</div>
		<c:if test = "${sach.ngayCapNhat != null}">
	   		<div class="row">
	   			<div class="col-md-2">
					<label class="label1">Ngày cập nhật:</label>
				</div>
				<div class="col-md-10">
				<label class="label2">${thanhVien.ngayCapNhat}</label>
			</div>
			</div>
		</c:if>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Giới tính:</label>
			</div>
			<div class="col-md-10">
				<label class="label2">${thanhVien.gioiTinh}</label>
			</div>
		</div>
	</div>
	<div class="footer">
		<%@ include file="common/footer.jsp" %>
	</div>
</body>
</html>