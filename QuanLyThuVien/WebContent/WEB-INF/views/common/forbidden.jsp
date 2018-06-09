<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forbidden</title>
<style type="text/css">
a{
	color: black;
	text-decoration: none;
	padding-left: 10px;
}
a:HOVER {
	color: blue;
}
</style>
</head>
<body>
	<div style="color: red;">
		<c:choose>
			<c:when test = "${pageContext.request.userPrincipal.name !=  null}">
	       		Hello ${pageContext.request.userPrincipal.name},
				You do not have permission to see this page!
	   		</c:when>
	   		<c:otherwise>
	   			You must login before access this page!
	   			<a href="login.html">Login</a>
	   		</c:otherwise>
		</c:choose>
	</div>
</body>
</html>