<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css" />
<script src="${pageContext.request.contextPath}/js/search.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
a.menu {
	color: black !important;
	text-decoration: none !important;
	padding-left: 10px !important;
}

a:HOVER{
	cursor:pointer;
	text-decoration: none !important;
}
.logout{
	color: blue !important;
	background:none!important;
	border:none; 
	padding:0!important;
	cursor: pointer;
}
.nav a {
    text-align:center;
    margin:0;
    border-left: 1px solid gray;
    border-right: 1px solid gray;
    display:block;
    
}
.nav a:HOVER { 
    background-color:#EEEEEE !important;;
}

ul.nav li:first-child a{
    border-left:none;
}
ul.nav li:last-child a {
    border-right:none;
}
@media screen and (min-width: 1000px) {
	.navbar-form{
		width: 30%;
	}
}
</style>
</head>
<body>
	<div class="container">
		<div style="background-color: #fff;" class="row">
			<table>
				<tr>
					<td class="col-md-10">
						<h1><a>Quản Lý Thư Viện</a></h1>
					<td>
					<td class="col-md-2" style="padding-top: 25px">
						<form action="j_spring_security_logout.html" method="POST">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							${fullName} | 
							<button class="logout" type="submit">Logout</button>
						</form>
					</td>
				</tr>
			</table>
		</div>
		<div class="header-menu">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu" aria-expanded="false">
					        <span class="sr-only">Toggle navigation</span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
		      			</button>
						<a class="navbar-brand" href="#">Trang chủ</a>
					</div>
					<div class="collapse navbar-collapse" id="menu">
						<ul class="nav navbar-nav">
							<li><a class="menu" href="quanlysach.html">Quản Lý Sách</a></li>
							<li><a class="menu" href="trasach.html">Trả Sách</a></li>
							<li><a class="menu" href="muonsach.html">Mượn Sách</a></li>
							<li><a class="menu" href="thongtinmuontra.html">Thông Tin Mượn Trả</a></li>
							<li><a class="menu" href="quanlythanhvien.html">Quản Lý Thành Viên</a></li>
						</ul>
						<form action="search.html" class="main search navbar-form navbar-left" role="search">
		  					<div style="margin-top: 6px; width: 100%" class="form-group">
		    					<input id="search" type="text" name="search" placeholder="Search...">
		  					</div>
		  					<div id="contain"></div>
		  					<button hidden="hidden" type="submit"></button>
						</form>
					</div>
				</div>
			</nav>
		</div>
	</div>
</body>
</html>