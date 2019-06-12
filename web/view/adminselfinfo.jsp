<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 2018/9/23 0023
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<!--_meta 作为公共模版分离出去-->
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="favicon.ico" >
    <link rel="Shortcut Icon" href="favicon.ico" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${APP_PATH}/lib/html5.js"></script>
    <script type="text/javascript" src="${APP_PATH}/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>设备信息修改</title>
</head>
<body>

<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 信息管理 <span class="c-gray en">&gt;</span> 个人信息></nav>

<article class="cl pd-20" style="margin-top: 50px">
    <form action="" method="post" class="form form-horizontal" id="form-member-add">


        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>账号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  typeof="<button disabled></button>"  id="user" name="user" value="${login_pojo.l_user}" readonly>

            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"    id="name" name="name" value="${loginUserInfo.aname}">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>电话：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"    id="phone" name="phone" value="${loginUserInfo.aphone}">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码:</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="password" class="input-text" placeholder="请输入6位长度的新密码"   id="password" value="" >
            </div>
        </div>

        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;保存&nbsp;&nbsp;" onclick="save()">
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${APP_PATH}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${APP_PATH}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">

    function save() {
        var user="${login_pojo.l_user}";
        var name= $("#name").val();
        var pass= $("#password").val();
        var phone=$("#phone").val();
        console.log(pass+user+" "+phone+" "+name);
         if(pass.length<6){

              $.Huimodalalert('密码不得小于6位数',2000);
             $("#password").val();
         }
         else{


          $.post("${APP_PATH}/Saveadmininfo.do",{
                "user":user,
                "pass":pass,
                "name":name,
                "phone":phone
            },function (str) {

                if(str=="ok"){

                    layer.confirm('信息修改成功', {
                        btn: ['确定'] //按钮
                    }, function(){
                        layer.msg('的确很重要', {icon: 1});

                        window.location.reload();

                    });
                  // $.Huimodalalert('信息修改成功',2000);

                }

            });
         }
    }


</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>