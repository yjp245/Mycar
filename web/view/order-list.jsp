<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 2018/8/25 0025
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${APP_PATH}/lib/html5shiv.js"></script>
    <script type="text/javascript" src="${APP_PATH}/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="${APP_PATH}/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>设备列表</title>
</head>
<body style="">
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 商城管理 <span class="c-gray en">&gt;</span> 商品管理<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">

    <div class="cl pd-5 bg-1 bk-gray mt-20">
    
        <span class="r">共有数据：<strong id="list_size">${list.size()}</strong> 条</span> </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th width="100">订单编号</th>
                <th width="100">购买人</th>
                <th width="100">消费金额</th>
                <th width="90">购买时间</th>
                <th width="90">发送地址</th>
                <th width="90">订单状态</th>
                <th width="90">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="c" varStatus="st">
                <tr class="text-c">
                    <td>${c.orderid}</td>
                    <td>${c.name}</td>
                    <td>${c.cost}</td>
                    <td>${c.orderTime}</td>
                    <td>${c.orderAddress}</td>
                    <td class="td-status"><span class="label label-success radius">${c.confirm}</span></td>
                     <td> <span class="label label-warning radius"><a href="javascript:;" onClick="update_order(this,'${c.orderid}')" >打印订单</a></span>  </td>
                   </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${APP_PATH}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${APP_PATH}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    $(function(){


    });
    /*用户-添加*/
    function member_add(title,url,w,h){
        layer_show(title,url,w,h);
    }
    /*用户-查看*/
    function member_show(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*用户-停用*/
    function member_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){
            $.ajax({
                type: 'POST',
                url: '',
                dataType: 'json',
                success: function(data){
                    $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
                    $(obj).remove();
                    layer.msg('已停用!',{icon: 5,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }

    /*用户-启用*/
    function member_start(obj,id){
        layer.confirm('确认要启用吗？',function(index){
            $.ajax({
                type: 'POST',
                url: '',
                dataType: 'json',
                success: function(data){
                    $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
                    $(obj).remove();
                    layer.msg('已启用!',{icon: 6,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }
    /*用户-编辑*/
    function device_edit(title,url,w,h){
        layer_show(title,url,w,h);
    }
    /*密码-修改*/
    function change_password(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type: 'POST',
                url: '',
                dataType: 'json',
                success: function(data){
                    $(obj).parents("tr").remove();
                    window.location.reload();
                    layer.msg('已删除!',{icon:1,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }

    function update_order(obj,id){
        // alert(id);

        layer.confirm('确认要打印订单吗？',function(index){

            $.post("${APP_PATH}/good/updateOrderConfirm",{
                "orderid":id
            },function (str) {
                if(str=="ok"){
                  //  $(obj).parents("tr").remove();
                    layer.msg('订单打印成功!',{icon:1,time:1000});
                    window.location.reload();
                }
            });


        });
    }
    function show_device(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
</script>
</body>
</html>