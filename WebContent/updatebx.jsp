<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改保险</title>
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
	<form action="AccountServlet?method=updatebx" method="post">
		<table class="table">
			<tr>
				<td width="100px">
					<font size="2" id="ti" > 保险编号</font>
				</td>
				<td>
					<input type="text" name="bxcode" id="name" value="${param.bxcode}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td width="100px">
					<font size="2" id="ti"> 姓名</font>
				</td>
				<td>
				<input type="text" name="name" id="name" value="${param.name}" readonly="readonly">	
				</td>
			</tr>
			<tr>
				<td width="100px">
					<font size="2" id="ti"> 时间</font>
				</td>
				<td>
					<input type="text" name="time" id="description" value="${param.time}">
				</td>
			</tr>
			<tr>
				<td width="100px">
					<font size="2" id="ti">类型</font>
				</td>
				<td>
					<input type="text" name="type" id="money" value="${param.type}" >
				</td >
			</tr>
			<tr>
				<td width="100px">
					<font size="2" id="ti">金额</font>
				</td>
				<td>
					<input type="text" name="money" id="date" value="${param.money }">
				</td>
			</tr>
						<tr>
				<td width="100px">
					<font size="2" id="ti">备注</font>
				</td>
				<td>
					<input type="text" name="beizhu" id="date" value="${param.beizhu }">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit"  value="确认修改" id="btu">
				</td >
			</tr>
		</table>
	</form>
</body>
</html>