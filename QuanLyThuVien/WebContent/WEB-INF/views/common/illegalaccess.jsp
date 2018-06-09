<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Oops</title>
</head>
<body>
	<div style="color: red;">
		<c:choose>
			<c:when test = "${fullName !=  null}">
		      	Hello ${fullName},
				This page can't access like this!
	 		</c:when>
	 		<c:otherwise>
	 			This page can't access like this!
	 		</c:otherwise>
		</c:choose>	
	</div>
</body>
</html>