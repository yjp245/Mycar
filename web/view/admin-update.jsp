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
<article class="cl pd-20">
    <form action="" method="post" class="form form-horizontal" id="form-member-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  typeof="<button disabled></button>"  id=" " name="" value="${admin.aname}" readonly>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>电话：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  typeof="<button disabled></button>"  id="phone " name="" value="${admin.aphone}" readonly>

            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>账号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  typeof="<button disabled></button>"  id="user" name="user" value="${login.l_user}" readonly>

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
                <input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;修改密码&nbsp;&nbsp;" onclick="resetPass()">
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

    function resetPass() {
      var user="${login.l_user}";
      var pass= $("#password").val();
       console.log(pass);
   if(pass.length<6){
       $.Huimodalalert('密码长度不能小于6位，请重新输入',2000);
   }else{

       $.post("${APP_PATH}/ResetPass.do",{
           "user":user,
           "pass":pass
       },function (str) {

           if(str=="ok"){
               //   $.Huimodalalert('密码重置成功，新密码为'+pass,2000);
               layer.confirm('密码重置成功，新密码为'+pass, {
                   btn: ['确定'] //按钮
               }, function(){
                   layer.msg('的确很重要', {icon: 1});
                   var index = parent.layer.getFrameIndex(window.name);
                   parent.$('.btn-refresh').click();
                   parent.location.reload();
                   parent.layer.close(index);


               });
           }
       });
   }

    }


</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>