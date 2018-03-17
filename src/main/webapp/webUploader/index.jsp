<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<title>上传</title>

</head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/webUploader/uploadInfo.css" />
<script src="https://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="https://g.alicdn.com/mtb/lib-flexible/0.3.4/??flexible_css.js,flexible.js"></script>
<script src="https://cdn.bootcss.com/webuploader/0.1.1/webuploader.min.js"></script>

<body>

<div id="uploader" class="wu-example">
	<!--用来存放文件信息-->
	<div id="thelist" class="uploader-list"></div>
	<!--成绩单照片-->
	<div class="btns">
		<div class="type">
			<div class="title-type">成绩单照片</div>
			<div class="addButton" id="add1">
				<img src="<%=request.getContextPath()%>/images/webUploader/add.png" />

			</div>
		</div>
	</div>
	<div class="img-show" id="img1"></div>

</div>

<div class="uploadBtn" onclick="uploadFun();">提交</div>
</body>

<script>
    var _type = 1;
    var _arr = [];

    // 初始化Web Uploader
    var uploader = WebUploader.create({
        auto: false, // 选完文件后，是否自动上传。
        swf: 'https://cdn.bootcss.com/webuploader/0.1.1/Uploader.swf',
        server: '<%=request.getContextPath()%>/show/webUploader/uploadImage', // 文件接收服务端。
        pick: {
            id: '#add1',
            multiple: true
        }, // 选择文件的按钮。可选。
        duplicate: false, //去重
        // 只允许选择图片文件。
        thumb: {
            quality: 100
        },
        accept: {
            title: '',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        }
    });


    uploader.on('uploadSuccess', function(file, response) {
		alert(response);
    })

    uploader.on('error', function(type) {
        if(type == 'F_DUPLICATE') {
            $('#add' + _type + ' input').val('');

        }
    })
    uploader.on('beforeFileQueued', function(file, data) {
        //console.log(123)
    })
    // 当有文件添加进来的时候
    uploader.on('fileQueued', function(file, data) {
        if(file.ext) {
            file._type = _type;
            var li = $(
                '<div id="' + file.id + '" class="file-item thumbnail">' +
                '<img>' +
                '</div>' +
                '<div class="cancel" onclick="del(' + _type + ')"></div>'
                ),
                $img = li.find('img');
            // $list为容器jQuery实例
            $('#img' + _type).append(li);
            $('#img' + _type).css('display', 'block');
            $('#add' + _type).hide();
            _arr[_type] = file;
            // 创建缩略图
            // 如果为非图片文件，可以不用调用此方法。
            uploader.makeThumb(file, function(error, src) {
                if(error) {
                    $img.replaceWith('<span>不能预览</span>');
                    return;
                }
                $img.attr('src', src);
            }, $('.addButton').width(), $('.addButton').width());
        }
    });

    function del(_type) {
        $('#add' + _type + ' input').val(''); //将input置空
        uploader.removeFile(_arr[_type], true);
        $("#img" + _type).empty();
        $("#img" + _type).hide();
        $("#add" + _type).show();
    }

    function uploadFun() {


        uploader.upload();
    }
</script>

</body>
</html>