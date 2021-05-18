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
	background-color: white;
	float: left;
}



#left {
	height: 700px;
	background-color: white;
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
	<div class="row" style="background-color: white; height: 100px">

		<div class="col-md-3">
			<font class="ab" size="4">用户：${who.name }</font>
		</div>
		<div class="col-md-8" style="align-content: center;">
			<h1>记账系统</h1>
		</div>
		<div class="col-md-1" style="align-content: left; margin-top: 60px">
			<a href="UserServlet?method=exit" onclick="return likai()">[退出]</a>
		</div>
	</div>
		<hr />
	<div class="row">
		<div class="col-md-2" id="left">
		<div class="dropdown">
 <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    账单管理
  </a>

  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item" href="AccountServlet?method=select&name=${who.name}" target="right">查看账单</a><br/>
    <a class="dropdown-item" href="AccountServlet?method=shouzhi&name=${who.name}" target="right">查看收支情况</a><br/>
    <a class="dropdown-item" href="selectByDate.jsp?name=${who.name}" target="right">根据日期查询账单</a><br/>
    <a class="dropdown-item" href="selectByMoney.jsp?name=${who.name}" target="right">根据金额查询账单</a><br/>
    <a class="dropdown-item" href="selectByWay.jsp?name=${who.name}" target="right">根据描述模糊查询账单</a><br/>
    <a class="dropdown-item" href="addAccount.jsp?name=${who.name}" target="right">添加账单</a><br/>
    <a class="dropdown-item" href="AccountServlet?method=select&name=${who.name}" target="right">修改账单</a><br/>
    <a class="dropdown-item" href="AccountServlet?method=select&name=${who.name}" target="right">删除账单</a><br/>
    
  </div>
</div>

		<div class="dropdown">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    债券管理
  </a>

  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item" href="addzq.jsp?name=${who.name}" target="right">添加债券</a><br/>
    <a class="dropdown-item" href="AccountServlet?method=selectzq&name=${who.name}" target="right">修改债券</a><br/>
    <a class="dropdown-item" href="AccountServlet?method=selectzq&name=${who.name}" target="right">删除债券</a><br/>
  </div>
</div>


		<div class="dropdown">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    股票投资
  </a>

  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item" href="addgp.jsp?name=${who.name}" target="right">添加股票</a><br/>
    <a class="dropdown-item" href="AccountServlet?method=selectgp&name=${who.name}" target="right">修改股票</a><br/>
    <a class="dropdown-item" href="AccountServlet?method=selectgp&name=${who.name}" target="right">删除股票</a><br/>
  </div>
</div>


		<div class="dropdown">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    保险投资
  </a>

  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item" href="addbx.jsp?name=${who.name}" target="right">添加保险</a><br/>
    <a class="dropdown-item" href="AccountServlet?method=selectbx&name=${who.name}" target="right">修改保险</a><br/>
    <a class="dropdown-item" href="AccountServlet?method=selectbx&name=${who.name}" target="right">删除保险</a><br/>
  </div>
</div>



  <a  class="btn btn-secondary dropdown-toggle" href="transfer.jsp?name=${who.name}" target="right" >
    转账
  </a>

	<br/>


  <a class="btn btn-secondary dropdown-toggle"  href="updateUser.jsp?name=${who.name}&sex=${who.sex}&phone=${who.phone}&password=${who.password}&account=${who.account}&identity=${who.identity}" target="right"  >
    修改个人信息
  </a>



		</div>
		<div id="right" class="col-md-10">
			<iframe name="right" src="" width="100%" height="600px"></iframe>
		</div>
	</div>
	
</body>
</html>


