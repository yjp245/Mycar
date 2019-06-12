<%--
  Created by IntelliJ IDEA.
  User: dim
  Date: 2017/5/27
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<!--[if lt IE 9]>
	<script type="text/javascript" src="${APP_PATH}/lib/html5shiv.js"></script>
	<script type="text/javascript" src="${APP_PATH}/lib/respond.min.js"></script>
	<![endif]-->
	<link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="${APP_PATH}/lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/css/style.css" />
	<link href="${APP_PATH}/static/css/time.css" type="text/css" rel="stylesheet">
	<!--[if IE 6]>
	<script type="text/javascript" src="${APP_PATH}/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('*');</script>
	<![endif]-->
	<title>我的桌面</title>
</head>
<body>
<div class="page-container">
    <p class=" text-success">欢迎尊贵的<strong>${loginUserInfo.getUname()}</strong> 使用智能车载安全监测管理系统</p>
	<p>登录次数：${login_pojo.count} </p>
	<p>登录IP：${login_pojo.ip} 上次登录时间：${login_pojo.time}</p>
</div>
<center>
	<div class="box">
		<ul>
			<li><span id="hour"></span><span>Hours</span></li>
			<li><span id="minute"></span><span>Minutes</span></li>
			<li><span id="second"></span><span>Seconds</span></li>
		</ul>
	</div>
</center>
<script>
    var hour=document.getElementById('hour');
    var minute=document.getElementById('minute');
    var second=document.getElementById('second');
    function showTime(){
        var oDate=new Date();
        var iHours=oDate.getHours();
        var iMinute=oDate.getMinutes();
        var iSecond=oDate.getSeconds();
        hour.innerHTML=AddZero(iHours);
        minute.innerHTML=AddZero(iMinute);
        second.innerHTML=AddZero(iSecond);

    }
    showTime();
    setInterval(showTime,1000);
    function AddZero(n){
        if(n<10){

            return '0'+n;

        }

        return ''+n;
    }
</script>
<script type="text/javascript" src="${APP_PATH}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript">
    function mills2time(mill){
        var unixTimestamp = new Date(mill) ;
        commonTime = unixTimestamp.toLocaleString();
        return commonTime;
    }
</script>
</body>
</html>