<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>转账界面</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<style type="text/css">
input {
		border-radius: 10px;
		width: 250px;
		height: 40px;
}
#btu{
	width: 100px;
	height: 40px;
}
</style>
</head>
<body>
	<form action="AccountServlet?method=transfer" method="post">
		<table class="table">
			<tr>
				<td width="100px">
					<font size="2" id="ti" >您的姓名</font>
				</td>
				<td>
					<input type="text" name="name1" id="name1" value="${param.name}"  readonly>
				</td>
			</tr>
			<tr>
				<td width="100px">
					<font size="2" id="ti">被转账者姓名</font>
				</td>
				<td>
					<input type="text" name="name2" id="name2"  >
				</td>
			</tr>
			<tr>
				<td width="100px">
					<font size="2" id="ti"> 金额</font>
				</td>
				<td>
					<input type="text" name="money" id="money"  >
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit"  value="转账" id="btu">
				</td >
			</tr>
		</table>
	</form>
</body>
</html>