<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看自己的保险</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

<style type="text/css">
.ab{
	position: relative;
	top: 40px; 
	left : 35px;
	right: 30px;
}
</style>
</head>
<body>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>保险编号</th>
				<th>姓名</th>
				<th>时间</th>
				<th>类型</th>
				<th>金额</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  var="item"  items="${list}" varStatus="i">
				<tr>
					<td >${item.bxcode}</td>
					<td >${item.name}</td>
					<td >${item.time}</td>
					<td >${item.type}</td>
					<td >${item.money}</td>
					<td >${item.beizhu}</td>
					<td><a href="AccountServlet?method=deletebx&bxcode=${item.bxcode}">删除保险</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="updatebx.jsp?name=${item.name}&bxcode=${item.bxcode}&time=${item.time}&type=${item.type}&money=${item.money}&beizhu=${item.beizhu}">修改保险</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>