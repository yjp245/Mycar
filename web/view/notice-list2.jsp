<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 2018/8/25 0025
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${APP_PATH}/lib/html5shiv.js"></script>
    <script type="text/javascript" src="${APP_PATH}/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="${APP_PATH}/lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>管理员列表</title>
</head>
<body style="">
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 账户管理 <span
        class="c-gray en">&gt;</span>管理员列表<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                             href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">

    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l"></span>
        <span class="r">共有数据：<strong id="list_size">${list.size()}</strong> 条</span></div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th width="100">编号</th>
                <th width="100">标题</th>
                <th width="250">内容</th>
                <th width="100">时间</th>
                <th width="100">发布人</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="c" varStatus="st">
                <tr class="text-c">
                    <td>${c.nid}</td>
                    <td>${c.title}</td>
                    <td>${c.content}</td>
                    <td>${c.time}</td>
                    <td>${c.aname}</td>
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
    $(function () {

        $('.table-sort').dataTable({
            "aaSorting": [[1, "desc"]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                //{"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
            ]
        });

        var listsize = "${list.size()}";
        //console.log(listsize);
        if (listsize == 0) {
            $.Huimodalalert('不存在操作记录', 2000);
        }

    });

    /*用户-添加*/
    function member_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }

    /*图片-删除*/
    function device_del(obj, id) {


        layer.confirm('确认要删除吗？', function (index) {

            $.post("${APP_PATH}/deleteNotice.do", {
                "nid": id
            }, function (str) {
                if (str == "ok") {
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!', {icon: 1, time: 1000});
                    window.location.reload();
                }
            });


        });
    }

</script>
</body>
</html>