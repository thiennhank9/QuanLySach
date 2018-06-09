<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/suasach.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datepicker.css" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/suasach.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.vi.min.js"></script>
<title>Sửa Thành Viên</title>
<style type="text/css">
.input-group-addon:HOVER {
	cursor: pointer;
}
</style>
<script type="text/javascript">
$( document ).ready(function() {
	$.fn.datepicker.defaults.format = "dd / mm / yyyy";
	$('.datepicker').datepicker({
	});
});
</script>
</head>
<body onload="init()">
	<div class="header col-md-12 navbar-fixed-top">
		<%@ include file="common/header.jsp" %>
	</div>
	<!-- body go here -->
	<div class="container fist">
		<form action="xacnhansuathanhvien.html" method="POST">
			<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
			<div id="error" style="color: red; margin-bottom: 3px;">
				${error}
			</div>
			
			<div class="row">
				<div class="col-md-2">
					<label class="label1">ID Thành Viên:</label>
				</div>
				<div class="col-md-4">
					<input pattern="^[A-Za-z0-9\[\]/!$%^&*()\-_+{};:'£@#.?]*$" required name="idThanhVien" 
						onclick="disappear()" maxlength="45" class="form-control" value="${thanhVien.idThanhVien}" />
					<input type="hidden" value="${oldId}" name="oldId" />
				</div>
				<div class="col-md-2">
					<label class="label1">Tên Thành Viên:</label>
				</div>
				<div class="col-md-4">
					<input required maxlength="45" name="tenThanhVien" class="form-control thoiHanMuon" 
						value="${thanhVien.tenThanhVien}" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label class="label1">Email:</label>
				</div>
				<div class="col-md-4">
					<input id="email" required name="email" maxlength="45" class="form-control" 
						type="email" value="${thanhVien.email}" />
				</div>
				<div class="col-md-2">
					<label class="label1">Ngày sinh:</label>
				</div>
				<jsp:useBean id="now" class="java.util.Date"/>
				<div class="col-md-4 input-group date" data-provide="datepicker" 
					data-date-end-date="<fmt:formatDate value="${now}" pattern="dd/MM/yyyy" />">
					<input type="text" required name="ngaySinhTmp" class="form-control" 
						value="<fmt:formatDate value="${thanhVien.ngaySinh}" pattern="dd / MM / yyyy" />"/>
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-th"></span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label class="label1">Ngày cập nhật:</label>
				</div>
				<div class="col-md-4">
					<input class="form-control" disabled
						value="<fmt:formatDate value="${now}" pattern="dd / MM / yyyy" />" />
				</div>
				<div class="col-md-2">
					<label class="label1">Giới Tính:</label>
				</div>
				<div class="col-md-4">
					<select id="mySelect" class="form-control" name="gioiTinh">
						<c:if test="${not empty thanhVien.gioiTinh}">
							<option>${thanhVien.gioiTinh}</option>
						</c:if>
						<c:if test="${thanhVien.gioiTinh != 'Nam'}">
							<option>Nam</option>
						</c:if>
						<c:if test="${thanhVien.gioiTinh != 'Nữ'}">
							<option>Nữ</option>
						</c:if>
					</select>
				</div>
			</div>			
			
			<div style="margin-top: 30px;" class="row">
				<div class="col-md-12">
					<div style="text-align: center;">
						<button class="btn btn-success" type="submit">Sửa</button>
						<button type="button" class="btn btn-warning" onclick="location.href='quanlythanhvien.html'">Hủy bỏ</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="footer">
		<%@ include file="common/footer.jsp" %>
	</div>
</body>
</html>