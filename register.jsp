<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<style type="text/css">
input {
	border-radius: 10px;
	width: 250px;
	height: 40px;
}

#btu {
	width: 100px;
	height: 40px;
}
</style>
</head>
<body>
	<form action="UserServlet?method=register" method="post">
		<table class="table">
			<tr>
				<td width="100px"><font size="2" id="ti"> 用户名</font></td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td width="100px"><font size="2" id="ti"> 性别</font></td>
				<td><input type="radio" name="sex" id="sex" value="男">男
				<input type="radio" name="sex" id="sex" value="女">女</td>
			</tr>
			<tr>
				<td width="100px"><font size="2" id="ti"> 手机号</font></td>
				<td><input type="text" name="phone" id="phone"></td>
			</tr>
			<tr>
				<td width="100px"><font size="2" id="ti"> 家庭编号</font></td>
				<td><input type="text" name="identity" id="identity">
				</td>
			</tr>
			<tr>
				<td width="100px"><font size="2" id="ti"> 密码</font></td>
				<td><input type="text" name="password" id="password">
				</td>
			</tr>
			<tr>
				<td width="100px"><font size="2" id="ti"> 银行卡金额</font></td>
				<td><input type="text" name="account" id="account"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="注册" id="btu">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>