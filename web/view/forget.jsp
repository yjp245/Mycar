<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 2018/11/14 0014
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //获取绝对路径webcontent
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>智能车载安全监测系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${APP_PATH}/view/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${APP_PATH}/view/layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet" href="${APP_PATH}/view/layuiadmin/style/login.css" media="all">
</head>
<body>


<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
    <div class="layadmin-user-login-main">
        <div class=" layadmin-user-login-header">
            <h2>智能车载安全监测管理系统</h2>

        </div>
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="uname"></label>
                <input type="text" name="uname" id="uname"  placeholder="用户名" class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-release" for="uemail"></label>
                <input type="text" name="email" id="uemail"  placeholder="请输入用户绑定的邮箱号" class="layui-input">
            </div>
            <div class="layui-form-item">
                <div class="layui-row">
                    <div class="layui-col-xs7">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="code"></label>
                        <input type="text" name="code" id="code" lay-verify="required" placeholder="验证码" class="layui-input">
                    </div>
                    <div class="layui-col-xs5">
                        <div style="margin-left: 10px;">
                            <input type="button" class="layui-btn layui-btn-primary layui-btn-fluid" id="button1"  onclick="sendCode(this)" value="获取验证码"></input>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="pass"></label>
                <input type="password" name="pass" id="pass"  placeholder="密码" class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="repass"></label>
                <input type="password" name="rpass" id="repass"  placeholder="确认密码" class="layui-input">
            </div>

            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid"  type="button" onclick="submit()">找回密码</button>
            </div>

        </div>
    </div>

    <div class="layui-trans layadmin-user-login-footer">

        <p>© 2018 <a href="#" target="_blank">智能车载安全监测管理系统</a></p>

    </div>

</div>
<script type="text/javascript" src="${APP_PATH}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/layer/2.4/layer.js"></script>
<script src="${APP_PATH}/view/layuiadmin/layui/layui.js"></script>
<script>



//邮箱验证码
var clock = '';
var nums = 60;
var btn;

function sendCode(thisBtn) {
    var email = $("#uemail").val();
    if(!checkEmail(email)){
        layer.msg('请输入正确的邮箱',  {icon: 2});
    }else {

       getmsm(email);
        btn = thisBtn;
        btn.disabled = true; //将按钮置为不可点击
        btn.value = nums + '秒后重新获取';
        clock = setInterval(doLoop, 1000); //一秒执行一次
    }
}

function doLoop() {
    nums--;
    if(nums > 0) {
        btn.value = nums + '秒后重新获取';
    } else {
        clearInterval(clock); //清除js定时器
        btn.disabled = false;
        btn.value = '发送验证码';
        nums = 60; //重置时间
    }
}
function 	getmsm(phone){
    var email = $("#uemail").val();

       $.post("${APP_PATH}/user/jsondata/sendCodetoemail.do",{
           receiveaddress:email
       },function (e) {
           if(e =="ok"){
           layer.msg('已发送至绑定邮箱，请注意查看',  {icon: 1});

           }
       });


}
//短信验证结束

//监测邮箱
function checkEmail(str){
    var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
    if (re.test(str)) {
       return true;
    } else {
        return false;
    }
}


//提交表单
    function submit() {
        var upass=$("#pass").val();
        var uname=$("#uname").val();
         var code=$("#code").val();
        var email = $("#uemail").val();
        if(uname.length>1){
                    if(checkEmail(email)){
                             if(code.length>0){
                                 if(upass.length>0){
                                     if(checkpass()) {

                                         $.post("${APP_PATH}/user/jsondata/forgetPass.do",
                                              {
                                                 "uname":uname,
                                                  "code":code,
                                                  "upass":upass
                                              },function (e) {
                                               if(e=="ok"){

                                                  $("#uname").val('');
                                                   $("#pass").val('');
                                                   $("#repass").val('');
                                                  $("#code").val('');
                                                   $("#uemail").val('');
                                                   layer.msg('密码修改成功',  {icon: 1});
                                                   setTimeout(' layer.msg(\'正为你跳转到登录界面\',  {icon:loading});', 2000); //延迟1秒
                                                   setTimeout('window.location.href="login.jsp";', 2000); //延迟1秒
                                               }
                                               else{
                                                   layer.msg('验证码错误，请核对后输入',  {icon: 2});
                                               }
                                          });



                                     }else {
                                         layer.msg('两次密码输入不一致',  {icon: 2});
                                     }
                                 }else{
                                     layer.msg('密码输入不得为空',  {icon: 2});
                                 }
                             }else{
                                 layer.msg('请输入验证码',  {icon: 2});
                             }

                    }else{
                        layer.msg('请输入正确的邮箱',  {icon: 2});
                    }
        }else {
            layer.msg('用户账户不得为空',  {icon: 2});
        }

    }

    function checkpass() {
         var pass=$("#pass").val();
         var repass=$("#repass").val();
             if(pass.trim() == repass.trim()){
                 return true;
             }else{
                 return false;
             }

    }

</script>
</body>
</html>