<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/quanlysach.css" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hoạt động gần đây</title>
</head>
<body>
	<div class="header col-md-12 navbar-fixed-top">
		<%@ include file="common/header.jsp" %>
	</div>
	<!-- body go here -->
	<div class="container body">
		<c:set var="listSach" value="${quanLySachForm.listQuanLySach}"></c:set>
		<c:set var="resultSize" value="${fn:length(quanLySachForm.listQuanLySach)}"></c:set>
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
					<td class="tdCenter">Chưa có hoạt động nào gần đây cả!</td>
					<td></td><td></td><td></td><td></td>
				</tr>
			</table>
		</c:set>
		<display:table id="table1" class="table table-bordered" name="${listSach}" sort="external" defaultsort="1" 
			pagesize="10" partialList="true" size="${resultSize}" requestURI="/sachganday.html">
			<display:column class="col-md-1 tdCenter" property="idSach" sortable="true" sortName="idSach" title="ID Sách" />
			<display:column class="col-md-5 tdTenSach" property="tenSach" sortable="true" sortName="tenSach" title="Tên Sách" />
			<display:column class="col-md-1 tdCenter" property="soLuong" sortable="true" sortName="soLuong" title="Số Lượng" />
			<display:column class="col-md-1 tdCenter" property="gia" sortable="true" sortName="gia" title="Giá"/>
			<display:column class="col-md-2 tdCenter" property="dangMuon" sortable="true" sortName="dangMuon" title="Đang Mượn"/>
			<display:column class="col-md-2 tdCenter" title="Hành động">
				<a style="margin-right: 12px;" href="xemsachganday.html?idSach=${table1.idSach}">Xem</a> 
				<a href="khoiphucsach.html?idSach=${table1.idSach}">Khôi Phục</a> 
			</display:column>
			<display:setProperty name="basic.msg.empty_list" value="${emptyList}" />
		</display:table>
		<div style="color: red;">
			${error}
		</div>
	</div>
	<div class="footer">
	<%@ include file="common/footer.jsp" %>
	</div>
</body>
</html>