<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<hr />
	<div class="row">
		<hr>
		<h5>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收入总额:${shouru.money}</h5>
		<br>
		<br>
		<h5>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;支出总额:${zhichu.money}</h5>
		<hr>
		<div class="col-md-2" id="left"></div>
<!-- 		<div id="right" class="col-md-10">
			<iframe name="right" src="" width="100%" height="600px"> </iframe>

		</div> -->
	</div>


</body>

</html>




