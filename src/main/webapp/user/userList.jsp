<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<style type="text/css">
.total {
	width: 855px;
	margin: auto;
}

table {
	width: 850px;
	border: 1px solid #4F81BD;
	border-collapse: collapse;
	text-align: center;
}

td {
	border: 1px solid #4F81BD;
	height: 30px;
}

.title {
	background-color: #95B3D7;
	font-family: "微软雅黑";
	color: #FFFFFF;
}
.userName{width:150px;}
.realName{width:150px;}
.time{width:200px;}
.operate{width:150px;}
.delete,.update{float:left; width:70px;height:25px; border:1px solid #4F81BD;margin-left:2px;border-radius:4px;text-align:center;line-height:23px;background-color: #4F81BD;color: #FFFFFF;}
</style>
</head>
<body>
	<div class="total">
		<table id="userList">
			<tr>
				<td class="title userName">用户名</td>
				<td class="title realName">姓名</td>
				<td class="title time">注册时间</td>
				<td class="title">更新时间</td>
				<td class="title operate">操作</td>
			</tr>
		</table>
	</div>
 <script src="<%=request.getContextPath() %>/js/public/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
function addUser()
{
	alert("dffdfdffdf");
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/user/getUserList",
		dataType:"json",
		success:function(userList)
		{
			if(userList!=null)
			{
				for(var i=0;i<userList.length;i++)
				{
					var user = userList[i];
					var tr="<tr class='userContent'><td>"+user.userName+"</td><td>"+user.realName+"</td><td>"+user.insertTime+"</td><td>"+user.updateTime+"</td><td><div class='delete' onclick=\"deleteUser("+user.userId+")\">删除</div><div class='update'>更新</div></tr>";
					$("#userList").append(tr);
				}
			} else
			{
				alert("userList is null");
			}
		},
		error:function(msg)
		{
			alert("数据出现异常");
		}
	});
}

addUser();

function deleteUser(userId)
{
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/user/deleteUserById",
		data:{"userId":userId},
		dataType:"json",
		success:function(resultVO)
		{
			if(resultVO.resultCode=="200")
			{
				$("#userList").find(".userContent").remove();
				addUser();
			}
		},
		error:function(resultVO)
		{
			alert("服务出现异常");
		}
	}); 
}
</script> 
</body>
</html>