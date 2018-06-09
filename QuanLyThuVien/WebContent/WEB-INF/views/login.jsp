<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById("ipUserName").onclick = removeError;
		document.getElementById("ipPassWord").onclick = removeError;
		
		function removeError() {
			$("#divError").fadeOut("1000");
		}
		
		var error = '${error}';
		if(error == null || error.trim() == 0){
			var divError = document.getElementById("divError");
			divError.style.display = "none";	
		}
	}
</script>
</head>
<body>
	<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="text-center">Đăng Nhập</h1>
				</div>
				<div class="modal-body">
					<form action="j_spring_security_check.html" name='loginForm' method='POST'>
						<div class="form-group">
							<input id="ipUserName" name="j_username" required class="form-control input-lg" 
								placeholder="User name">
						</div>
						<div class="form-group">
							<input id="ipPassWord" name="j_password" type="password" required 
								class="form-control input-lg" placeholder="Password">
						</div>
						<div id="divError" class="alert alert-danger">
                    		<span class="glyphicon glyphicon-remove"></span><strong>&nbsp;&nbsp;${error}</strong>
                		</div>
						<div class="form-group">
			              <button type="submit" class="btn btn-primary btn-lg btn-block">Sign In</button>
			            </div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>