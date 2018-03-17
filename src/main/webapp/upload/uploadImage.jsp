<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传影像</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mobileReset.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/idupload2.css" />
<style type="text/css">
.tab-ul li{width:100%;}
</style>
</head>
<body class="paddingTop paddingBottom">
  <div class="container">
      <section class="upload">
          <div class="uploadCon disBlock">
              <div class="uploadList clearfix">
                <form id="form1" name="form1">
                    <input type="hidden" name="files" id="files" class="files"/>
                </form>
                <input type="file" class="file-3" name="files" id="doc">
                <input type="button" value="上传影像">
                <div class="picBox">
                    <img src="<%=request.getContextPath()%>/images/pic02.jpg" class="picId" id="previewx">
                </div>
                <div class="yulan" id="yulan">
                    <img src="" id="img0">
                    <div class="enter">
                        <button class="btn-2" id="btn-1">取消</button>
                        <button class="btn-3" id="btn-2">确定</button>
                    </div>
                </div>
                </div>
          </div>
      </section>
      
      <!-- 遮罩层 -->
      <div id="zhez" style="display:none;">
          <p class="upload">正在上传中......</p>
      </div>
      <!-- 遮罩层 end -->

  </div>

  <!-- 底部按钮 -->
  <div class="fixBtn thirty-six" id="nextStart">
    下一步
  </div>
  <!-- 底部按钮 end --> 

<script src="<%=request.getContextPath() %>/js/public/jquery.js" type="text/javascript"></script>
<script>
    $("#doc").change(function(){
        var ifile = document.getElementById(this.id);
        var reader = new FileReader();
        reader.readAsDataURL(ifile.files[0]);
        reader.onload = function ()
        {
            var filesName = ifile.name;
            $("#"+filesName).val(reader.result);
            $("#img0").attr("src", reader.result).show();
        }
    });

    $("#btn-2").click(function(){
        shows();
        $("#previewx").attr("src", $("#files").val());
        $("#yulan").hide();
    	$.ajax({
    		type:"POST",
    		url:"<%=request.getContextPath()%>/upload/uploadImage",
    		data:$("#form1").serialize(),
    		dataType:"json",
    		success:function(result)
    		{
                close();
                if(result.resultCode="200")
                {
                    alert("上传成功");
                } else {
                    alert("上传失败");
                }
    		},
    		error:function()
    		{
                close();
                alert("上传失败");
    		}
    	});
     
    });

    $("#btn-1").click(function(){
        $("#yulan").hide();
    });

  // 遮罩层
  function shows()
  {
      //获取页面文档的高度
      var docheight = $(document).height();
      //追加一个层，使背景变灰
      $("#zhez").css({ "opacity": "0.5", "height": docheight });
      $("#zhez").show();
  } 

  // 关闭遮罩层
  function close()
  {
      $("#zhez").hide();
      return false;
  }

  $("#nextStart").bind("click",function(){
      var filesVal = document.getElementById("files").value;
      console.log(filesVal);
  });

  $(".file-3").bind('change',function(){
        $("#yulan").show();
  });

</script>
</body>
</html>