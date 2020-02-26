<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>根据方式查询账单</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<style type="text/css">
table {
	position: relative;
	top: 10px;
	left: 5px;
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

	<hr />
	<div class="row">
		<div class="col-md-2" id="left">
			<form action="AccountServlet?method=selectByWay&name=${param.name}"
				method="post">
				请输入描述 <input type="text" name="description"> <br> <input
					type="submit" value="查询">
			</form>
		</div>
		<div id="right" class="col-md-10">
			<iframe name="right" src="" width="100%" height="600px"></iframe>
		</div>
	</div>

</body>
</html>