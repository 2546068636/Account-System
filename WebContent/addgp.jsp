<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
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
#btu{
	width: 100px;
	height: 40px;
}
</style>
</head>
<body>
	<form action="AccountServlet?method=addgp" method="post">
		<table class="table">
			<tr>
				<td width="100px">
					<font size="2" id="ti" > 姓名</font>
				</td>
				<td>
					<input type="text" name="name" id="name" value="${param.name}" readonly>
				</td>
			</tr>
			<tr>
				<td width="100px">
					<font size="2" id="ti" > 股票名称</font>
				</td>
				<td>
					<input type="text" name="gpname"  >	
				</td>
			</tr>
			<tr>
				<td width="100px">
					<font size="2" id="ti"> 股票编号</font>
				</td>
				<td>
					<input type="text" name="gpcode" id="description"  >
				</td>
			</tr>
			<tr>
				<td width="100px">
					<font size="2" id="ti">买入价格</font>
				</td>
				<td>
					<input type="text" name="buyprice" id="type"  >
				</td>
			</tr>
			<tr>
				<td width="100px">
					<font size="2" id="ti"> 股数</font>
				</td>
				<td>
					<input type="text" name="gushu" id="money"  >
				</td>
			</tr>
						<tr>
				<td width="100px">
					<font size="2" id="ti"> 卖出价格</font>
				</td>
				<td>
					<input type="text" name="soldprice" id="beizhu"  >
				</td>
			</tr>
			
									<tr>
				<td width="100px">
					<font size="2" id="ti">盈利金额</font>
				</td>
				<td>
					<input type="text" name="benefit" id="beizhu"  >
				</td>
			</tr>
			
												<tr>
				<td width="100px">
					<font size="2" id="ti">时间</font>
				</td>
				<td>
					<input type="text" name="time" id="beizhu"  >
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit"  value="添加" id="btu">
				</td >
			</tr>
		</table>
	</form>
</body>
</html>