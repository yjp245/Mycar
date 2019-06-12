<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${APP_PATH}/lib/html5shiv.js"></script>
    <script type="text/javascript" src="${APP_PATH}/lib/respond.min.js"></script>
    <![endif]-->

    <link href="${APP_PATH}/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css"/>
    <link href="${APP_PATH}/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="${APP_PATH}/lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>后台登录 - 智能车载安全监测管理系统</title>
</head>
<body>
<%--header start--%>
<div class="header">
    <div id="h_left">
        <h3 id="header_h1">物联网开发平台</h3>
        <h3 id="header_h2">设备管理系统</h3>
    </div>
<%--    <div id="h_right">
        <h2 id="header_h3"><a href="#" id="r_a1">中</a> /<a href="#" id="r_a2">En</a></h2>
        <h2 id="header_h4"><input class="h_button radius" type="button" value="注册"></h2>
    </div>--%>
</div>
<%--header end--%>
<div style="clear: both"> </div>

<%--login_title start--%>
<div class="login_title" >
    <span title="智能车载安全监测管理系统" ng-bind="LOGONAME | characters:15" class="ng-binding">智能车载安全监测管理系统</span>
</div>
<%--login_title end--%>
<%--login_body start--%>
<div class="login_body">
    <form  class="login_from" action="${APP_PATH}/user/login.do" method="post">
        <div class="f_input" >
            <div class="f_in input_1">
             <input id="l_user" name="l_user" type="text" placeholder="账户" class="input input-text " autofocus required>
            </div>
            <div class="f_in input_2">
                <input id="l_pass"  name="l_pass" type="password" placeholder="密码" class="input input-text " value="" required>
                <input type="hidden" name="ip" value="" id="ip" />
            </div>

        </div>

        <div class="f_forget">
            <span><a href="${APP_PATH}/view/forget.jsp " id="forget">忘记密码？</a></span>
        </div>
        <div class="f_login">
            <input class="btn-login radius" id="loginform" type="submit" value="登录">
            <p id="resultSpan" >${loginerro}</p>
        </div>
    </form>
</div>

<%--login_body end--%>

<div class="footer1">Copyright @Smu 收破烂 by Group <a href="#" target="_blank">JP'Car</a></div>
<script type="text/javascript" src="${APP_PATH}/lib/jquery/1.9.1/jquery.min.js"></script>
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
<script>
    $(function(){
        var ip=returnCitySN.cip;
        $('#ip').val(ip);
    });

</script>
</body>
</html>