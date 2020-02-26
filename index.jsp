<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<style type="text/css">
#container {
	width: 440px;
	border: 1px solid #E7E7E7;
	padding: 20px 0 20px 30px;
	border-radius: 5px;
	margin-top: 60px;
	background: #fff;
}

#submit {
	background: url('./images/login.gif') no-repeat scroll 0 0
		rgba(0, 0, 0, 0);
	height: 35px;
	width: 100px;
	color: white;
}
</style>

</head>
<body>
	<div id="container" class="container">
		<form class="form-horizontal" action="UserServlet?method=login" method="post">
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="username"
						name="name" placeholder="请输入用户名">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group" align="center">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" width="100px" value="登录" name="submit"
						id="submit"> 
					<input type="button" value="注册" onClick="window.location.href='register.jsp'"> 
					<input type="reset" width="100px" value="重置"/>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
