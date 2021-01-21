<%--
  Created by IntelliJ IDEA.
  User: xuyan
  Date: 2020/12/12
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getContextPath()+"/"%>">
    <title>添加员工</title>
    <link href="../../css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="../../css/H-ui.admin.css" rel="stylesheet" type="text/css" />
    <link href="../../lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
    <link href="../../lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
    <link href="../../lib/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
    <link href="../../lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="pd-20">
    <form action="" method="post" class="form form-horizontal" id="form-admin-add">
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>管理员：</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" value="admin" placeholder="" id="username" name="username" datatype="*2-16" nullmsg="用户名不能为空">
            </div>
            <div class="col-4"> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>初始密码：</label>
            <div class="formControls col-5">
                <input type="password" placeholder="密码" name="password" autocomplete="off" value="123456" class="input-text" datatype="*6-20" nullmsg="密码不能为空">
            </div>
            <div class="col-4"> </div>
        </div>

        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>确认密码：</label>
            <div class="formControls col-5">
                <input type="password" placeholder="密码" name="password2" recheck="password" autocomplete="off" value="123456" class="input-text" datatype="*6-20" nullmsg="密码不能为空">
            </div>
            <div class="col-4"> </div>
        </div>

        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>性别：</label>
            <div class="formControls col-5 skin-minimal">
                <div class="radio-box">
                    <input type="radio" id="sex-1" value="1" checked name="sex" datatype="*" nullmsg="请选择性别！">
                    <label for="sex-1">男</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="sex-2" value="0" name="sex">
                    <label for="sex-2">女</label>
                </div>
            </div>
            <div class="col-4"> </div>
        </div>

        <div class="row cl">
        <label class="form-label col-3"><span class="c-red">*</span>手机：</label>
        <div class="formControls col-5">
            <input type="text" class="input-text" value="15388889479" id="user-tel" name="mobile"  datatype="m" nullmsg="手机不能为空">
        </div>
        <div class="col-4"> </div>
        </div>

        <div class="row cl">
        <label class="form-label col-3"><span class="c-red">*</span>排序的索引：</label>
        <div class="formControls col-5">
            <input type="text" class="input-text" value="1" name="orderbyIndex"  datatype="n">
        </div>
        <div class="col-4"> </div>
        </div>

        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>部门：</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" value="10" placeholder="" id="deptno" name="deptno"  datatype="n">
            </div>
            <div class="col-4"> </div>
        </div>

        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>生日：</label>
            <div class="formControls col-5">
                <input type="text" class="input-text Wdate" onclick="WdatePicker({readOnly:true,lang:'zh-cn'})" id="birthday" name="birthday"  datatype="*">
            </div>
            <div class="col-4"> </div>
        </div>

        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>邮箱：</label>
            <div class="formControls col-5">
                <input type="text" class="input-text"  value="2017961510@qq.com" name="email" id="email" datatype="e" nullmsg="请输入邮箱！">
            </div>
            <div class="col-4"> </div>
        </div>

        <div class="row cl">
            <label class="form-label col-3">头像：</label>

            <div class="formControls col-5">
                <input type="hidden" name="userpng" id="userpng">
                <div id="uploader" class="wu-example">
                    <div id="uploader-demo">
                        <!--用来存放item-->
                        <div id="fileList" class="uploader-list">

                        </div>
                        <div id="filePicker">选择图片</div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row cl">
            <div class="col-9 col-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script>
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script type="text/javascript" src="/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.js"></script>
<script type="text/javascript" src="js/oa_utils.js"></script>
<script type="text/javascript">
    $(function(){

        var uploader = WebUploader.create({

            // 选完文件后，是否自动上传。
            auto: true,

            // 文件接收服务端。
            server: 'commonController/uploadFile',
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.

            pick: '#filePicker',

            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });

        // 当有文件添加进来的时候触发fileQueued
        uploader.on( 'fileQueued', function( file ) { // file代表的就是用户上传的文件
            // 创建div用来显示图片
            var $li = $(
                '<div id="' + file.id + '" class="file-item thumbnail">' +
                '<img>' +
                '<div class="info">' + file.name + '</div>' +
                '</div>'
                ),

                //从上面的div元素中找到img元素
                $img = $li.find('img');


            //  把显示图片的div放到列容器里面
            $("#fileList").append( $li );

            // 创建缩略图
            uploader.makeThumb( file, function( error, src ) {
                if ( error ) {
                    $img.replaceWith('<span>图片已损坏</span>');
                    return;
                }
                $img.attr( 'src', src );
            }, 100, 100);
        });

        // 文件上传成功，给item添加成功class, 用样式标记上传成功。
        uploader.on( 'uploadSuccess', function( file,resp) {

            $("#userpng").val(resp.data);

        });

        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        //初始化表单验证
        $("#form-admin-add").Validform({
            tiptype:2,
            callback:function(form){

                submit("empController/addEmp",form);

                return false;//表单数据不会提交
            }
        });
    });
</script>
</body>
</html>
