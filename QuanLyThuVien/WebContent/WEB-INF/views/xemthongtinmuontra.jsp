<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/xemsach.css" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/calculate.date.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xem Thông Tin Mượn Trả</title>
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
			<div class="col-md-4">
				<label class="label2">${thongTinMuonTra.thanhVien.idThanhVien}</label>
			</div>
			<div class="col-md-2">
				<label class="label1">Tên Thành Viên:</label>
			</div>
			<div class="col-md-4">
				<label class="label2">${thongTinMuonTra.thanhVien.tenThanhVien}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">ID Sách:</label>
			</div>
			<div class="col-md-4">
				<label class="label2">${thongTinMuonTra.sach.idSach}</label>
			</div>
			<div class="col-md-2">
				<label class="label1">Tên Sách:</label>
			</div>
			<div class="col-md-4">
				<label class="label2">${thongTinMuonTra.sach.tenSach}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Ngày Mượn:</label>
			</div>
			<div class="col-md-4">
				<label class="label2"><fmt:formatDate value="${thongTinMuonTra.ngayMuon}" pattern="dd / MM / yyyy" /></label>
			</div>
			<div class="col-md-2">
				<label class="label1">Ngày Hết Hạn:</label>
			</div>
			<div class="col-md-4">
				<label class="label2"><fmt:formatDate value="${thongTinMuonTra.ngayHetHan}" pattern="dd / MM / yyyy" /></label>
				<input id="ngayHetHan" hidden="hidden" value="${thongTinMuonTra.ngayHetHan}" />
			</div>
		</div>
		<c:if test = "${thongTinMuonTra.ngayTra != null}">
	   		<div class="row">
	   			<div class="col-md-2">
					<label class="label1">Ngày Trả:</label>
				</div>
				<div class="col-md-4">
					<label class="label2"><fmt:formatDate value="${thongTinMuonTra.ngayTra}" pattern="dd / MM / yyyy" /></label>
					<input id="ngayTra" hidden="hidden" value="${thongTinMuonTra.ngayTra}" />
				</div>
				<div class="col-md-2">
					<label class="label1">Quá Hạn:</label>
				</div>
				<div class="col-md-4">
					<label id="quaHan" class="label2"></label>
				</div>
			</div>
		</c:if>
		<div class="row">
			<div class="col-md-2">
				<label class="label1">Trạng Thái:</label>
			</div>
			<div class="col-md-4">
				<label class="label2">${thongTinMuonTra.trangThai}</label>
			</div>
			<c:if test = "${thongTinMuonTra.phat != null}">
				<div class="col-md-2">
					<label class="label1">Phạt:</label>
				</div>
				<div class="col-md-4">
					<label class="label2">${thongTinMuonTra.phat}</label>
				</div>
			</c:if>
		</div>
	</div>
	<div class="footer">
		<%@ include file="common/footer.jsp" %>
	</div>
</body>
</html>