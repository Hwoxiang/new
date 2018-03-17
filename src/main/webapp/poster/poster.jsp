<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="">
	<title>海报制作</title>
	<meta
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
			name="viewport" />
	<meta content="yes" name="apple-mobile-web-app-capable" />
	<meta content="black" name="apple-mobile-web-app-status-bar-style" />
	<meta content="telephone=no" name="format-detection" />
	<link rel="stylesheet" type="text/css"
		  href="<%=request.getContextPath()%>/css/poster/mobileReset.css" />
	<link rel="stylesheet" type="text/css"
		  href="<%=request.getContextPath()%>/css/poster/maker.css" />
	<link rel="stylesheet" type="text/css"
		  href="<%=request.getContextPath()%>/css/poster/style.css">
</head>
<style type="text/css">
	#zhez {
		background: #000;
		display: block;
		z-index: 100;
		width: 100%;
		position: absolute;
		top: 0;
		left: 0;
	}

	.prompt {
		display: none;
		z-index: 200;
		position: fixed;
		top: 0;
		left: 0;
		/* transform: scale(0.755, 0.83); */
	}

	.sheve {
		text-align: center;
		font-size: 1.67rem;
		color: #fff;
		margin-top: 2%;
	}

	.sContent {
		max-width: 100%;
		width: 100%;
		height: 100%;
	}

	.creatImg{
		width: 71%;
		margin: 0 auto;
		margin-top: 6%;
		display: block;
	}

	@media screen and (max-width: 320px) {
		.prompt {
			z-index: 200;
			position: fixed;
			top: 0;
			left: 0;
			/* transform: scale(0.753, 0.7); */
		}
		.creatImg{
			width: 71%;
		}
		.topImg img{
			height: auto;
		}
	}
</style>
<body>

<div class="container">

	<p class="title">
		快来制作属于<br />自己的专属名片吧
	</p>

	<div class="scaleHtml" id="card">

		<div class="content">

			<div class="topImg" id="logox">
				<img
						src="<%=request.getContextPath()%>/images/poster/topHeader.png" />
				<div class="backChnage">
					<img class="backCh closePic"
						 src="<%=request.getContextPath()%>/images/poster/upload.png"
						 id="bgl" onclick="hideImg()" />
				</div>
			</div>


			<!--名片上传-->
			<article class="htmleaf-container">
				<div id="clipArea"></div>
				<div class="foot-use">
					<div class="uploader1 blue">
						<input type="button" name="file" class="button" value="打开">
						<input id="file" type="file" accept="image/*" multiple />
					</div>
					<button id="clipBtn">截取</button>
				</div>
				<div id="view"></div>
			</article>
			<!--名片上传 end-->

			<img src="<%=request.getContextPath()%>/images/poster/logo.png"
				 class="logoPic" />

			<!--业务员信息-->
			<div class="InfroDiv">
				<div class="bottomList">
					<p class="introduce">
						郭海琪<span class="duty">业务主任</span>
					</p>
					<div class="listP">
						<p>手机：18600212646</p>
						<p>工号：600212646</p>
						<p>地址：北京市海淀区杏石口路9号合众大厦</p>
					</div>


					<div class="scaImg">
						<img class="scanning"
							 src="<%=request.getContextPath()%>/images/poster/QR.png" id="qr" />


						<!--二维码上传-->
						<div class="tChange uploader closePic">
							<img class="addImg"
								 src="<%=request.getContextPath()%>/images/poster/scale.png"
								 id="codeImg" /> <input accept="image/*" type="file"
														id="qrFile" class="file-3">
						</div>

						<div class="yulan">
							<img src="" id="qrShwoImage">
							<div class="enter">
								<button class="btn-2 fl" id="qrCancel">取消</button>
								<button class="btn-3 fr" id="qrIndex">确定</button>
							</div>
						</div>
					</div>

				</div>

				<div class="bottomImg">
					<img
							src="<%=request.getContextPath()%>/images/poster/diamondService.png" />
					<img src="<%=request.getContextPath()%>/images/poster/star.png" />
				</div>

			</div>
			<!--业务员信息 end-->

		</div>
		<!--content div-->

	</div>
	<!--scaleHtml div-->


	<!--底部信息-->
	<div class="bottomDiv">
		<div class="createCard" id="btnSave">生成名片</div>
		<p class="complian">注：1.为了保证生成的名片比较美观，我们建议上传白色背景职业照片，二维码建议上传黑白二维码，尽量避免卡通二维码。</p>
	</div>
	<!--底部信息 end-->

</div>
<!--container div-->


<div class="photoWhite closePic" id="touchLog">点击图中照片处“＋
	”号可更换照片，建议上传白色背景职业照片。</div>

<div class="changeWei closePic">点击图中二维码处“＋”号可更换自己二维码，建议上传黑白二维码。</div>


<!-- 遮罩层上的HTML-->
<div class="prompt" id="promptTwo">
	<img id="create" class="creatImg" src=""/>

	<p class="sheve">长按保存名片可分享至朋友圈哦～</p>

</div>
<!--prompt 结束div-->




<div id="test"
	 style="position: fixed; top: 21%; left: 23%; z-index: 9999;"></div>
<p class="ttt"
   style="display: none; z-index: 99999; font-size: 1.5rem; color: #fff; position: fixed; left: 10%; bottom: 19%;">长按保存名片可分享至朋友圈哦～</p>



<form id="form1" name="form1" method="post" enctype="multipart/form-data">
	<input type="hidden" name="qrImage" id="qrImage" />
	<input type="hidden" name="header" id="header" />
</form>

</body>
<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/public/jquery.js"></script>
<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/poster/iscrollzoom.js"></script>
<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/poster/hammer.js"></script>
<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/poster/jquery.photoClip.js"></script>

<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/poster/html2canvas.js"></script>
<script>
    $("#btnSave").click(function() {


        var qrImage = $("#qrImage").val();
        if(qrImage=="")
        {
            alert("qrImage is null");
            return;
        }

        var header = $("#header").val();
        if(header==null)
        {
            alert("header is null");
            return;
        }

        var form1 = document.getElementById("form1");
        var formData = new FormData(form1);
        formData.append("qrImage",qrImage);
        //formData.append("header",convertBase64UrlToBlob(header));
        $.ajax({
            type:"POST",
            url:"<%=request.getContextPath()%>/poster/createPoser",
            data:formData,
            dataType:"text",
            processData : false,         // 告诉jQuery不要去处理发送的数据
            contentType : false,        // 告诉jQuery不要去设置Content-Type请求头
            success:function(result)
            {
                $(".prompt").fadeIn("slow");
                //获取页面文档的高度
                var docheight = $(document).height();
                //追加一个层，使背景变灰
                $("body").append("<div id='zhez'></div>");
                $("#zhez").css({
                    "opacity" : "0.5",
                    "height" : docheight
                });

                /* //点击关闭按钮
                $(".close").click(function() {
                    $(".prompt").fadeOut("fast"); //hide();
                    //删除变灰的层
                    $("#zhez").remove();
                    return false;
                });  */
                $("#create").attr("src", "data:image/jpeg;base64," + result);
            },
            error:function()
            {
                alert("失败");
            }
        });

    });


    function dataURItoBlob(urlData){
        var byteString = atob(urlData.split(',')[1]);
        var mimeString = urlData.split(',')[0].split(':')[1].split(';')[0];
        var ab = new ArrayBuffer(byteString.length);
        var ia = new Uint8Array(ab);
        for (var i = 0; i < byteString.length; i++) {
            ia[i] = byteString.charCodeAt(i);
        }
        return new Blob([ab], {type: mimeString});
    }

    var obUrl = ''
    //document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
    $("#clipArea").photoClip({
        width : 300,
        height : 300,
        file : "#file",
        view : "#view",
        ok : "#clipBtn",
        loadStart : function() {

        },
        loadComplete : function() {

        },
        clipFinish : function(dataURL) {
            console.log(dataURL);
            $("#header").val(dataURL);
        }
    });
</script>
<script>
    $(function() {

        $("#logox").click(function() {
            $(".htmleaf-container").show();
        })
        $("#clipBtn")
            .click(
                function() {
                    $("#logox").empty();
                    $('#logox')
                        .append(
                            '<img src="'
                            + imgsource
                            + '" align="absmiddle" style=" width: 60%;display: block;margin: 0 auto;text-align: center;padding-top: 10%;">');
                    $(".htmleaf-container").hide();
                    $('#logox')
                        .append(
                            '<div class="backChnage" ><img class="backCh" src="<%=request.getContextPath()%>/images/poster/upload.png" onclick="hideImg()"/></div>');
                    //二维码框显示
                    $(".changeWei").show();

                })
    });
</script>
<script type="text/javascript">
    $(function() {
        jQuery.divselect = function(divselectid, inputselectid) {
            var inputselect = $(inputselectid);
            $(divselectid + " small").click(function() {
                $("#divselect ul").toggle();
                $(".mask").show();
            });
            $(divselectid + " ul li a").click(function() {
                var txt = $(this).text();
                $(divselectid + " small").html(txt);
                var value = $(this).attr("selectid");
                inputselect.val(value);
                $(divselectid + " ul").hide();
                $(".mask").hide();
                $("#divselect small").css("color", "#333")
            });
        };
        $.divselect("#divselect", "#inputselect");
    });
</script>
<script type="text/javascript">
    $(function() {
        jQuery.divselectx = function(divselectxid, inputselectxid) {
            var inputselectx = $(inputselectxid);
            $(divselectxid + " small").click(function() {
                $("#divselectx ul").toggle();
                $(".mask").show();
            });
            $(divselectxid + " ul li a").click(function() {
                var txt = $(this).text();
                $(divselectxid + " small").html(txt);
                var value = $(this).attr("selectidx");
                inputselectx.val(value);
                $(divselectxid + " ul").hide();
                $(".mask").hide();
                $("#divselectx small").css("color", "#333")
            });
        };
        $.divselectx("#divselectx", "#inputselectx");
    });
</script>
<script type="text/javascript">
    $(function() {
        jQuery.divselecty = function(divselectyid, inputselectyid) {
            var inputselecty = $(inputselectyid);
            $(divselectyid + " small").click(function() {
                $("#divselecty ul").toggle();
                $(".mask").show();
            });
            $(divselectyid + " ul li a").click(function() {
                var txt = $(this).text();
                $(divselectyid + " small").html(txt);
                var value = $(this).attr("selectyid");
                inputselecty.val(value);
                $(divselectyid + " ul").hide();
                $(".mask").hide();
                $("#divselecty small").css("color", "#333")
            });
        };
        $.divselecty("#divselecty", "#inputselecty");
    });
</script>
<script type="text/javascript">
    $(function() {
        $(".mask").click(function() {
            $(".mask").hide();
            $(".all").hide();
        })
        $(".right input").blur(function() {
            if ($.trim($(this).val()) == '') {
                $(this).addClass("place").html();
            } else {
                $(this).removeClass("place");
            }
        })
    });
</script>
<script>
    $("#qrFile").change(function() {
        var ifile = document.getElementById(this.id);
        var reader = new FileReader();
        reader.readAsDataURL(ifile.files[0]);
        reader.onload = function() {
            $("#qrImage").val(reader.result);
            $("#qrShwoImage").attr("src", reader.result).show();
        }
    });

    var subUrl = "";
    $(function() {
        $(".file-3").bind('change', function() {
            subUrl = $(this).val()
            $(".yulan").show();
            $(".file-3").val("");
        });

        $(".file-3").each(function() {
            if ($(this).val() == "") {
                $(this).parents(".uploader").find(".filename").val("营业执照");
            }
        });

        //二维码确认
        $("#qrIndex").click(function() {
            $(".yulan").hide();
            var qrImage = $("#qrImage").val();
            var imgWidth = $("#qr").width();
            $("#qr").css("height", imgWidth);
            $("#qr").attr("src", qrImage);
            $(".addImg").show();

        });
        //二维码取消
        $("#qrCancel").click(function() {
            $(".yulan").hide();
            ;
        });

    });
</script>
<script type="text/javascript">

    function hideImg() {
        $(".photoWhite").hide();
        $(".changeWei").hide();
        $("body").css({
            "overflow-x" : "hidden",
            "overflow-y" : "hidden"
        });
    };
    $(".tChange").click(function() {
        $(".photoWhite").hide();
        $(".changeWei").hide();
    });
</script>


</html>