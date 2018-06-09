<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<title>Thông Tin Mượn Trả</title>
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
					<th class="col-md-1 tdCenter">Tên thành viên</th>
					<th class="col-md-5 tdCenter">Tên sách</th>
					<th class="col-md-1 tdCenter">Ngày mượn</th>
					<th class="col-md-1 tdCenter">Ngày hết hạn</th>
					<th class="col-md-2 tdCenter">Tình trạng</th>
					<th class="col-md-2 tdCenter">Hành Động</th>
				</tr>
				<tr>
					<td></td>
					<td class="tdCenter">Không tìm thấy thông tin mượn trả!</td>
					<td></td><td></td><td></td><td></td>
				</tr>
			</table>
		</c:set>
		<display:table class="table table-bordered" name="listThongTinMuonTra" sort="external" defaultsort="1" pagesize="10" partialList="true" 
			size="resultSize" requestURI="/thongtinmuontra.html" id="row">
			<display:column class="col-md-2 tdTenSach" title="Tên thành viên" sortable="true" sortName="tenthanhvien">
				<c:out value="${row.thanhVien.tenThanhVien}"/> 
			</display:column>
			<display:column class="col-md-3 tdTenSach" title="Tên sách" sortable="true" sortName="tensach">
				<c:out value="${row.sach.tenSach}"/> 
			</display:column>
			<display:column class="col-md-2 tdCenter" sortable="true" sortName="ngaymuon" title="Ngày mượn">
				<fmt:formatDate value="${row.ngayMuon}" pattern="dd / MM / yyyy" />
			</display:column>
			<display:column class="col-md-2 tdCenter" sortable="true" sortName="ngayhethan" title="Ngày hết hạn">
				<fmt:formatDate value="${row.ngayHetHan}" pattern="dd / MM / yyyy" />
			</display:column>
			<display:column class="col-md-2 tdCenter" property="trangThai" sortable="true" sortName="trangthai" title="Trạng Thái"/>
			<display:column class="col-md-2 tdCenter" title="Xem">
				<a style="margin-right: 8px;" href="xemthongtinmuontra.html?idThongTinMuonTra=${row.idThongTinMuonTra}">Chi Tiết</a> 
			</display:column>
			<display:setProperty name="basic.msg.empty_list" value="${emptyList}" />
		</display:table>
		<div style="color: red;">${error}</div>
	</div>
	<div class="footer">
	<%@ include file="common/footer.jsp" %>
	</div>
</body>
</html>