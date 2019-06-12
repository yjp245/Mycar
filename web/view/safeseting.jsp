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
    <link href="${APP_PATH}/lib/Hui-iconfont/1.0.8/iconfont.min.css" rel="stylesheet" type="text/css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="${APP_PATH}/lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>空白页</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 设备管理<span
        class="c-gray en">&gt;</span>安全设置<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                            href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>

<div class="page-container">
    <form class="form form-horizontal" id="form-article-add">
        <div id="tab-system" class="HuiTab">
            <div class="tabBar cl">
                <span>安全设置</span>
            </div>
            <div class="tabCon">

                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">
                        <span class="c-red">*</span>
                        设备:</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <select style="height: 30px; width: 400px; border: 0.5px solid #ccc;" id="dnum">
                            <option value="">请选择</option>
                        </select>
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">
                        <span class="c-red">*</span>
                        烟雾值：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text" id="mq2" placeholder="请配置一个理想烟雾值，推荐1" value="" class="input-text">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">
                        <span class="c-red">*</span>
                        温度值：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text" id="wendu" placeholder="请配置一个理想温度值，推荐30" value="" class="input-text">
                    </div>
                </div>

                <div class="row cl">
                    <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                        <button onClick="updateUserinfo();" class="btn btn-primary radius" type="button"><i
                                class="Hui-iconfont">&#xe632;</i> 修改
                        </button>
                    </div>
                </div>
            </div>


        </div>

    </form>
</div>


<script type="text/javascript" src="${APP_PATH}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="${APP_PATH}/view/js/H-ui.admin.js"></script>
<script type="text/javascript" src="${APP_PATH}/view/js/util.js"></script>

<script type="text/javascript">
    var devices;
    $(function () {
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });
        $("#tab-system").Huitab({
            index: 0
        });

        var uid = '<%= session.getAttribute("loginUserUid")%>';
        $.post("${APP_PATH}/jsondata/device-list.do", {
            'uid':uid
        }, function(e) {
            devices = e;
            for (var i = 0; i < devices.length; i++) {
                $('#dnum').append(
                    '<option value='+devices[i].dnum+'>'
                    + devices[i].dname
                    + '</option>');
            }
        });
    });

    function updateUserinfo() {
        var mq2 = $("#mq2").val();
        var wendu = $("#wendu").val();
        var dnum = $("#dnum").val();

        $.post("${APP_PATH}/jsondata/updateOrAddThreshold.do", {
                "mq2_s": mq2,
                "wendu": wendu,
                "dnum": dnum
            },
            function (data) {
                console.log(data);
                if (data.code == 0) {
                    $.Huimodalalert('信息修改成功', 1000);
                    // location.reload();
                }
            }
        );
    }

    function updatePass() {
        var pass = $("#password").val();
        var repass = $("#repassword").val();

        if (pass != "") {
            if (repass != "") {
                if (pass.length >= 6) {
                    if (pass == repass) {
                        $.post("${APP_PATH}/user/updateUserPass.do", {
                            "pass": pass
                        }, function (str) {
                            if (str == "ok") {
                                $.Huimodalalert('密码修改成功', 1000);
                            }
                        });


                    }
                    else {
                        $.Huimodalalert('两次密码输入不一致，请重新输入', 1000);

                    }
                    $("#password").val("");
                    $("#repassword").val("");
                }
                else {
                    $.Huimodalalert('密码输入长度小于6，请重新输入', 1000);
                }
            }
            else {
                $.Huimodalalert('确认密码不得为空', 1000);
            }
        }
        else {
            $.Huimodalalert('修改密码不得为空', 1000);
        }

    }

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
