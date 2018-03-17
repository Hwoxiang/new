<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<style type="text/css">
body {
	background-color: #aed5e3;
}

.tital {
	margin: auto;
	width: 600px;
	height: 400px;
	margin-top: 15%;
}

.userRegister {
	font-size: 1.3em;
	height: 30px;
	line-height: 30px;
	font-family: "微软雅黑";
	font-weight: bold;
	margin-left: 1%;
}

.form1 {
	width: 600px;
	height: 300px;
	background-color: #ffffff;
	border-radius: 8px;
}

.form1 div span {
	display: inline-block;
	font-size: 0.9em;
	font-family: "微软雅黑";
}

.title {
	width: 100px;
	text-align: right;
	margin-left: 10%;
	margin-top: 10px;
	color: #A4A4A4;
}

span input {
	width: 200px;
	height: 20px;
	outline: none;
}

.fuserName {
	margin-top: 8%;
}

.btndata {
	margin-left: 33%;
	margin-top: 10px;
	border: 1px solid #FE5D53;
	width: 100px;
	height: 30px;
	background-color: #FE5D53;
	border-radius: 3px;
	color: #ffffff;
	font-family: "微软雅黑";
	line-height: 30px;
	text-align: center;
}
</style>
</head>
<body>
	<div class="tital">
		<div class="userRegister">用户注册</div>
		<div class="form1">
		<form action="<%=request.getContextPath()%>/user/register" id="form1" name="form1" method="post">
			<div>
				<span class="title fuserName">手机号：</span> <span><input
					type="text" id="userName" name="userName"></span>
			</div>

			<div>
				<span class="title">姓名：</span> <span><input type="text"
					id="realName" name="realName"></span>
			</div>

			<div>
				<span class="title">密码：</span> <span><input type="password"
					id="password" name="password"></span>
			</div>

			<div>
				<span class="title">确认密码：</span> <span><input type="password"
					id="indexPwd" name="indexPwd"></span>
			</div>
			</form>
			<div class="btndata" id="btndata">提交</div>
		</div>
	</div>

</body>
<script src="<%=request.getContextPath() %>/js/public/jquery.js"
	type="text/javascript"></script>
<script type="text/javascript">
function submitData()
{
	var userName = $("#userName").val();
	if(userName=="")
	{
		alert("请输入手机号");
		return;
	}
	
	var realName = $("#realName").val();
	if(realName=="")
	{
		alert("输入姓名");
		return;
	}
	
	var password = $("#password").val();
	var indexPwd = $("#indexPwd").val();
	if(password==""||password!=indexPwd)
	{
		alert("请输入正确的密码");
		return;
	}
	
	var form1 = document.getElementById("form1");	
	form1.submit();	
}

$("#btndata").unbind("click");
$("#btndata").bind("click",submitData);
</script>
</html>