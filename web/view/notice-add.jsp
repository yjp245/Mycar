<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 2018/8/25 0025
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="/favicon.ico">
    <link rel="Shortcut Icon" href="/favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${APP_PATH}/lib/html5shiv.js"></script>
    <script type="text/javascript" src="${APP_PATH}/lib/respond.min.js"></script>

    <![endif]-->
    <link href="${APP_PATH}/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css"/>
    <link href="${APP_PATH}/static/h-ui.admin/css/H-ui.admin.css" rel="stylesheet" type="text/css"/>
    <link href="${APP_PATH}/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css"/>

    <!--[if IE 6]>
    <script type="text/javascript" src="${APP_PATH}/lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>空白页</title>
</head>
<body>

<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 系统设置<span class="c-gray en">&gt;</span> 公告发布
</nav>

<div class="panel panel-default">
    <div class="panel-header">

    </div>
    <div class="container Hui-iconfont-align-center">

        <div class="panel-body">

            <form class="" action="" method="post">

                <div class="row cl" style="margin-bottom: 30px">
                    <label class="form-label col-xs-4 col-sm-3">
                        <text style="margin-left: 120px">公告标题：</text>
                    </label>
                    <div class="formControls col-xs-5 col-sm-9">
                        <input type="text" class="input-text radius" name="" id="title" placeholder="">
                    </div>
                </div>
                <div class="row cl" style="margin-bottom: 30px">


                    <label class="form-label col-xs-4 col-sm-3">
                        <text style="margin-left: 120px">公告内容：</text>
                    </label>
                    <div class="formControls col-xs-5 col-sm-9">
                        <textarea class="textarea" placeholder="" rows="" cols="" name="probelm"
                                  id="content"></textarea>
                    </div>
                </div>


                <div class="row cl">
                    <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                        <button onClick="submitfeedback()" class="btn btn-primary radius" type="button"><i
                                class="Hui-iconfont">&#xe632;</i> 保存
                        </button>
                    </div>
                </div>

            </form>
        </div>

    </div>

</div>

<script type="text/javascript" src="${APP_PATH}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/h-ui.admin/js/H-ui.admin.js"></script>

<script type="text/javascript">

    $(function () {

    });

    function submitfeedback() {
        var probelm = $("#title").val();
        var phone = $("#content").val();
        if (probelm != "" && phone != "") {

            $.post("${APP_PATH}/addnotice.do", {

                title: probelm,
                content: phone
            }, function (str) {

                if (str == "ok") {

                    layer.confirm('公告发布成功！', {
                        btn: ['确定'] //按钮
                    }, function(){
                        layer.msg('的确很重要', {icon: 1});

                        $("#title").val('');
                        $("#content").val('');
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.$('.btn-refresh').click();
                        window.parent.location.reload();
                        parent.layer.close(index);

                    });

                }
            });
        } else {
            $.Huimodalalert('请先填写内容', 1000);
        }

    }
</script>
</body>
</html>
