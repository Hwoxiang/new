<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="form1" name="form1" action="<%=request.getContextPath()%>/upload/test" enctype="multipart/form-data" method="post">
上传文件：<input type="file" name="file1"><br/>
</form>
<input type="button" id="btn" name="btn" value="提交">
<script src="<%=request.getContextPath() %>/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
document.getElementById("btn").onclick = function()
{
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/upload/test",
		data:$("#form1").serialize(),
		dataType:"json",
		success:function(result)
		{
			alert("this is success");
		},
		error:function(result)
		{
			alert("this is fail");
		}
	});
};
</script>
</body>
</html>