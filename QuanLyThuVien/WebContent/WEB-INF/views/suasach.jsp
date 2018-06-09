<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/suasach.css" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/suasach.js"></script>
<title>Sửa Sách</title>
</head>
<body onload="init()">
	<div class="header col-md-12 navbar-fixed-top">
		<%@ include file="common/header.jsp" %>
	</div>
	<!-- body go here -->
	<div class="fist container">
		<form action="xacnhansuasach.html" method="POST">
			<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
			<div id="error" style="color: red; margin-bottom: 3px;">
				${error}
			</div>
			<div class="row">
				<div class="col-md-2">
					<label class="label1">ID Sách:</label>
				</div>
				<div class="col-md-4">
					<input pattern="^[A-Za-z0-9\[\]/!$%^&*()\-_+{};:'£@#.?]*$" required name="idSach" 
						onclick="disappear()" maxlength="45" class="form-control" value="${sach.idSach}" />
					<input type="hidden" value="${oldId}" name="oldId" />
				</div>
				<div class="col-md-2">
					<label class="label1">Thời Hạn mượn:</label>
				</div>
				<div class="col-md-4">
					<input required  min="1" max="2147483647" placeholder="Số ngày mượn tối đa"
						type="number" name="thoiHanMuon" class="form-control thoiHanMuon" value="${sach.thoiHanMuon}" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label class="label1">Tên Sách:</label>
				</div>
				<div class="col-md-4">
					<!--<input required name="tenSach" class="form-control" value="${sach.tenSach}" />-->
					<input id="tenSach" required name="tenSach" maxlength="450" 
						class="form-control" value="${sach.tenSach}" />
				</div>
				<div class="col-md-2">
					<label class="label1">Số lượng:</label>
				</div>
				<div class="col-md-4">
					<input required  min="1" max="2147483647" 
						type="number" name="soLuong" class="form-control" value="${sach.soLuong}" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label class="label1">Tác Giả:</label>
				</div>
				<div class="col-md-4">
					<input pattern="^(?!\s*$|\s).*$" required name="tacGia" class="form-control" 
						maxlength="450" value="${sach.tacGia}" />
				</div>
				<div class="col-md-2">
					<label class="label1">Giá:</label>
				</div>
				<div class="col-md-4">
					<input required  min="1" max="2147483647"
						type="number" name="gia" class="form-control" value="${sach.gia}" />
				</div>
			</div>			
	   		<div class="row">
	   			<div class="col-md-2">
	   				<jsp:useBean id="now" class="java.util.Date"/>    
					<label class="label1">Ngày cập nhật:</label>
				</div>
				<div class="col-md-4">
					<input class="form-control" disabled
						value="<fmt:formatDate value="${now}" pattern="dd / MM / yyyy" />" />
				</div>
				<div class="col-md-2">
					<label class="label1">Loại:</label>
				</div>
				<div class="col-md-4">
					<select id="mySelect" class="form-control" name="slLoai">
						<option>${sach.loai}</option>
						<c:forEach var="loaiSach" items="${listLoaiSach}">
							<c:if test="${sach.loai != loaiSach}">
								<option>${loaiSach}</option>
							</c:if>
						</c:forEach>
						<option style="color: green;">Tạo loại sách mới.</option>
					</select>
					<input pattern="^(?!\s*$|\s).*$" name="ipLoai" maxlength="45" 
						id="ipLoai" class="hidden ninja-input" value="" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label class="label1">Mô tả</label>
				</div>
				<div class="col-md-10">
					<textarea maxlength="5000" id="text" name="moTa" rows="5" 
						class="form-control" >${sach.moTa}</textarea>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-10">
					<div style="text-align: center;">
						<button class="btn btn-success" type="submit">Sửa</button>
						<button type="button" class="btn btn-warning" onclick="location.href='quanlysach.html'">Hủy bỏ</button>
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