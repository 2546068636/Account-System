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
				<th>姓名</th>
				<th>债券名称</th>
				<th>股票编号</th>
				<th>金额</th>
				<th>收益率</th>
				<th>盈利金额</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  var="item"  items="${list}" varStatus="i">
				<tr>
					<td >${item.name}</td>
					<td >${item.zqname}</td>
					<td >${item.zqcode}</td>
					<td >${item.money}</td>
					<td >${item.interest}</td>
					<td >${item.profit}</td>
					<td >${item.time}</td>
					<td><a href="AccountServlet?method=deletezq&zqcode=${item.zqcode}">删除债券</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="updategp.jsp?name=${item.name}&zqname=${item.zqname}&zqcode=${item.zqcode}&money=${item.money}&interest=${item.interest}&profit=${item.profit}&time=${item.time}">修改债券</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>