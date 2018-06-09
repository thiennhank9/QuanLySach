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
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/suasach.js"></script>
<script src="${pageContext.request.contextPath}/js/kiemtratrasach.js"></script>
<title>Mượn sách</title>
</head>
<body onload="init()">
	<div class="header col-md-12 navbar-fixed-top">
		<%@ include file="common/header.jsp" %>
	</div>
	<!-- body go here -->
	<div class="container fist" style="text-align: center;">
		<form action="xacnhantrasach.html" method="POST">
			<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
			<div class="row">
				<label class="label1">ID Thành Viên:</label>
				<input pattern="^[A-Za-z0-9\[\]/!$%^&*()\-_+{};:'£@#.?]*$" required id="idThanhVien" 
					name="idThanhVien" onclick="disappear()" maxlength="45" class="form-control" value="" />
			</div>
			<div class="row">
				<label class="label1">ID Sách:</label>
				<input pattern="^[A-Za-z0-9\[\]/!$%^&*()\-_+{};:'£@#.?]*$" required id="idSach" name="idSach"
					class="form-control thoiHanMuon" />
			</div>
			<div class="row">
				<label class="label1">Phạt:</label>
				<textarea id="text" maxlength="200"
					name="phat" maxlength="45" class="form-control"></textarea>
			</div>
			<div style="color: green;" id="success" class="row">${success}</div>
			<div style="color: red;" id="error" class="row">${error}</div>
			<div id="btnForm" style="margin-top: 20px;" class="row">
				<button id="kiemTra" class="btn btn-success" type="submit">Trả Sách</button>
			</div>
		</form>
	</div>	
	<div class="footer">
		<%@ include file="common/footer.jsp" %>
	</div>
</body>
</html>