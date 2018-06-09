<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/quanlysach.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý thành viên</title>
</head>
<body>
	<div class="header col-md-12 navbar-fixed-top">
		<%@ include file="common/header.jsp" %>
	</div>
	<!-- body go here -->
	<div class="container body">
		<c:set var="emptyList">
			<table id="table1" class="table table-bordered">
				<tr>
					<th class="col-md-1 tdCenter">ID User</th>
					<th class="col-md-5 tdCenter">Tên Thành Viên</th>
					<th class="col-md-1 tdCenter">Email</th>
					<th class="col-md-1 tdCenter">Giới Tính</th>
					<th class="col-md-2 tdCenter">Trạng Thái</th>
					<th class="col-md-2 tdCenter">Hành động</th>
				</tr>
				<tr>
					<td></td>
					<td class="tdCenter">Không tìm thấy thành viên!</td>
					<td></td><td></td><td></td><td></td>
				</tr>
			</table>
		</c:set>
		<display:table id="table1" class="table table-bordered" name="listThanhVien" sort="external" defaultsort="1" pagesize="10" partialList="true" 
			size="resultSize" requestURI="/quanlythanhvien.html">
			<display:column class="col-md-1 tdCenter" property="idThanhVien" title="ID User" />
			<display:column class="col-md-3 tdTenSach" property="tenThanhVien" sortable="true" sortName="name" title="Tên Thành Viên" />
			<display:column class="col-md-3 tdTenSach" property="email" title="Email" />
			<display:column class="col-md-2 tdCenter" property="gioiTinh" sortable="true" sortName="gioitinh" title="Giới Tính"/>
			<display:column class="col-md-1 tdCenter" property="tinhTrang" sortable="true" sortName="tinhtrang" title="Trạng Thái"/>
			<display:column class="col-md-2 tdCenter" title="Hành động">
				<a style="margin-right: 8px;" href="xemthanhvien.html?idThanhVien=${table1.idThanhVien}">Xem</a> 
				<a style="margin-right: 8px;" href="suathanhvien.html?idThanhVien=${table1.idThanhVien}">Sửa</a> 
				<a href="xoathanhvien.html?idThanhVien=${table1.idThanhVien}">Xóa</a>
			</display:column>
			<display:setProperty name="basic.msg.empty_list" value="${emptyList}" />
		</display:table>
		<div style="color: red;">${error}</div>
		<button onclick="window.location='themthanhvien.html'" class="btn btn-success">
			Thêm Thành Viên
		</button>
		<c:if test="${fn:length(thanhVienForm.listThanhVien) gt 0}">
			<a style="float: right; margin-right: 20px;" href="thanhvienganday.html">Hoạt động gần đây</a>
		</c:if>
	</div>
	<div class="footer">
	<%@ include file="common/footer.jsp" %>
	</div>
</body>
</html>