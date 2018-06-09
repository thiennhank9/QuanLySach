<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/quanlysach.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>Quản lý sách</title>
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
					<th class="col-md-1 tdCenter">ID Sách</th>
					<th class="col-md-5 tdCenter">Tên sách</th>
					<th class="col-md-1 tdCenter">Số lượng</th>
					<th class="col-md-1 tdCenter">Giá</th>
					<th class="col-md-2 tdCenter">Đang mượn</th>
					<th class="col-md-2 tdCenter">Hành động</th>
				</tr>
				<tr>
					<td></td>
					<td class="tdCenter">Không tìm thấy sách!</td>
					<td></td><td></td><td></td><td></td>
				</tr>
			</table>
		</c:set>
		<display:table id="table1" class="table table-bordered" name="listQuanLySach" sort="external" defaultsort="1" pagesize="10" partialList="true" 
			size="resultSize" requestURI="/quanlysach.html">
			<display:column class="col-md-1 tdCenter" property="idSach" title="ID Sách" />
			<display:column class="col-md-5 tdTenSach" property="tenSach" title="Tên Sách" />
			<display:column class="col-md-1 tdCenter" property="soLuong" sortable="true" sortName="soLuong" title="Số Lượng" />
			<display:column class="col-md-1 tdCenter" property="gia" sortable="true" sortName="gia" title="Giá"/>
			<display:column class="col-md-2 tdCenter" property="dangMuon" sortable="true" sortName="dangMuon" title="Đang Mượn"/>
			<display:column class="col-md-2 tdCenter" title="Hành động">
				<a style="margin-right: 8px;" href="xemsach.html?idSach=${table1.idSach}">Xem</a> 
				<a style="margin-right: 8px;" href="suasach.html?idSach=${table1.idSach}">Sửa</a> 
				<a href="xoasach.html?idSach=${table1.idSach}">Xóa</a>
			</display:column>
			<display:setProperty name="basic.msg.empty_list" value="${emptyList}" />
		</display:table>
		<div style="color: red;">${error}</div>
		<button onclick="window.location='themsach.html'" class="btn btn-success">
			Thêm Sách
		</button>
		<c:if test="${fn:length(quanLySachForm.listQuanLySach) gt 0}">
			<a style="float: right; margin-right: 20px;" href="sachganday.html">Hoạt động gần đây</a>
		</c:if>
	</div>
	<div class="footer">
	<%@ include file="common/footer.jsp" %>
	</div>
</body>
</html>