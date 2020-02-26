<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>功能</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
function likai(){
	var msg = "确定退出吗？";
	if(confirm(msg)==true){
		return true;
	}else{
		return false;
	}
}

</script>
<style type="text/css">
table {
	position: relative;
	top: 10px; left : 5px;
	bgcolor: #FFFFFF;
	left: 5px;
}

#right {
	height: 800px;
	background-color: ghostwhite;
	float: left;
}



#left {
	height: 700px;
	background-color: #28A4C9;
}

#who {
	position: relative;
	top: 30px;
	left: 5px;
}
.ab {
	position: relative;
	top: 40px;
	left: 35px;
	right: 30px;
}
</style>
</head>
<body style="height: 900px">
	<div class="row" style="background-color: silver; height: 100px">

		<div class="col-md-3">
			<font class="ab" size="4">用户：${who.name }</font>
		</div>
		<div class="col-md-8" style="align-content: center;">
			<h1>家庭记账系统</h1>
		</div>
		<div class="col-md-1" style="align-content: left; margin-top: 60px">
			<a href="UserServlet?method=exit" onclick="return likai()">[退出]</a>
		</div>
	</div>
		<hr />
	<div class="row">
		<div class="col-md-2" id="left">
			<table class="table">

					<tr>
						<td style="background-color: white"><h6 align="center">
								<a href="AccountServlet?method=select&name=${who.name}" target="right">查看账单</a>
							</h6></td>
					</tr>
										<tr>
						<td style="background-color: white"><h6 align="center">
								<a href="AccountServlet?method=shouzhi&name=${who.name}" target="right">查看收支情况</a>
							</h6></td>
					</tr>
										<tr>
						<td style="background-color: white"><h6 align="center">
								<a href="selectByDate.jsp?name=${who.name}" target="right">根据日期查询账单</a>
							</h6></td>
					</tr>
					
												<tr>
						<td style="background-color: white"><h6 align="center">
								<a href="selectByMoney.jsp?name=${who.name}" target="right">根据金额查询账单</a>
							</h6></td>
					</tr>
												<tr>
						<td style="background-color: white"><h6 align="center">
								<a href="selectByWay.jsp?name=${who.name}" target="right">根据描述模糊查询</a>
							</h6></td>
					</tr>
										<tr>
						<td style="background-color: white"><h6 align="center">
								<a href="addAccount.jsp?name=${who.name}" target="right">添加账单</a>
							</h6></td>
					</tr>
										<tr>
						<td style="background-color: white"><h6 align="center">
								<a href="AccountServlet?method=select&name=${who.name}" target="right">修改账单</a>
							</h6></td>
					</tr>
										<tr>
						<td style="background-color: white"><h6 align="center">
								<a href="AccountServlet?method=select&name=${who.name}" target="right">删除账单</a>
							</h6></td>
					</tr>
										<tr>
						<td style="background-color: white"><h6 align="center">
								<a href="updateUser.jsp?name=${who.name}&sex=${who.sex}&phone=${who.phone}&password=${who.password}&account=${who.account}&identity=${who.identity}" target="right">修改个人信息</a>
							</h6></td>
					</tr>
										<tr>
						<td style="background-color: white"><h6 align="center">
								<a href="AccountServlet?method=selectF&identity=${who.identity}" target="right">查看家庭账单</a>
							</h6></td>
					</tr>
										<tr>
						<td style="background-color: white"><h6 align="center">
								<a href="transfer.jsp?name=${who.name}" target="right">转账</a>
							</h6></td>
					</tr>
			</table>
		</div>
		<div id="right" class="col-md-10">
			<iframe name="right" src="" width="100%" height="600px"></iframe>
		</div>
	</div>
	
</body>
</html>