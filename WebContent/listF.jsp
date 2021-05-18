<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看家庭的账单</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

<style type="text/css">
.ab {
	position: relative;
	top: 40px;
	left: 35px;
	right: 30px;
}
</style>
</head>
<body>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>姓名</th>
				<th>方式</th>
				<th>具体描述</th>
				<th>金额</th>
				<th>日期</th>
				<!-- <th>id</th> -->
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}" varStatus="i">
				<tr>
					<td>${item.name}</td>
					<td>${item.way}</td>
					<td>${item.description}</td>
					<td>${item.money}</td>
					<td>${item.date}</td>
					<%-- <td >${item.id}</td> --%>
					<%-- <td><a
						href="AccountServlet?method=deleteAccount&id=${item.id}">删除账单</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a
						href="updateAccount.jsp?name=${item.name}&way=${item.way}&description=${item.description}&money=${item.money}&date=${item.date}&id=${item.id}">修改账单</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>