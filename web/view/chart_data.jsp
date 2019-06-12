<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 2018/8/25 0025
  Time: 22:15
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
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${APP_PATH}/lib/html5shiv.js"></script>
    <script type="text/javascript" src="${APP_PATH}/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/lib/Hui-iconfont/1.0.8/iconfont.min.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="${APP_PATH}/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>折线图</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 统计管理 <span class="c-gray en">&gt;</span> 折线图 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

<div class="page-container">
    <div id="container1" style="min-width:700px;height:300px"></div>
    <div id="container" style="min-width:700px;height:400px"></div>

</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${APP_PATH}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${APP_PATH}/lib/hcharts/Highcharts/5.0.6/js/highcharts.js"></script>
<script type="text/javascript" src="${APP_PATH}/lib/hcharts/Highcharts/5.0.6/js/modules/exporting.js"></script>
<script type="text/javascript">


    //请求后获取数据,以便后面使用

    $(document).ready(function() {
         table2();
        var tem=null;
        var hum=null;
     var  chart = {
            type: 'spline',
            animation: Highcharts.svg, // don't animate in IE < IE 10.
            marginRight: 10,
            events: {
                //load: requestData // 图表加载完毕后执行的回调函数

             load: function () {
                  var  series = this.series[0],
                     chart = this;
                 activeLastPointToolip(chart);
                 setInterval(function () {

                     $.post  ("${APP_PATH}/jsondata/chart_data.do", {
                          dnum:"${device_info}"
                         },
                         function(data) {
                             if(data==""){
                                 $.Huimodalalert('设备已经下线，不能查看当前设备实时信息',2000);

                             }
                             else{
                             console.log(data);
                             tem=data.temperature;
                             hum=data.humidity;

                             var series = chart.series[0];
                             var  shift = series.data.length > 20; // 当数据点数量超过 20 个，则指定删除第一个点
                             var x = (new Date()).getTime();
                             var y = tem;
                             chart.series[0].addPoint([x,y], true, shift);

                             var series1 = chart.series[0];
                             var  shift1 = series1.data.length > 20; // 当数据点数量超过 20 个，则指定删除第一个点
                             var x1 = (new Date()).getTime();
                             var y1 = hum;
                             chart.series[1].addPoint([x1,y1], true, shift1);
                             }
                         }
                     );
                 }, 3000);

             }

            }
        };
        var title = {
            text: '温湿度折线显示图',
            x: -20 //center
        };
        var xAxis = {
            type: 'datetime',
            tickPixelInterval: 150
        };
        var yAxis = {
            title: {
                text: '温湿度（℃ / %RH）'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        };
        var tooltip = {
            formatter: function () {
                return '<b>' + this.series.name + '</b><br/>' +
                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                    Highcharts.numberFormat(this.y, 2);
            }
        };
        var plotOptions = {
            area: {
                pointStart: 1940,
                marker: {
                    enabled: false,
                    symbol: 'circle',
                    radius: 2,
                    states: {
                        hover: {
                            enabled: true
                        }
                    }
                }
            }
        };
        var lang={

                printChart:"打印图表",
                downloadJPEG:"下载JPEG图片",
                downloadPDF:"下载PDF文档",
                downloadPNG:"下载PNG图片",
                downloadSVG:"下载SVG矢量图",
                contextButtonTitle:"导出菜单"

        };
        var legend = {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        };
        var exporting = {
            enabled: true
        };
        var series= [{
               name: '温度值',
            data: (function () {
                // generate an array of random data
                var data = [],time = (new Date()).getTime(),i;
                for (i = -19; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 1000,
                        y:tem
                    });
                }
                return data;
            }())
        },{
            name: '湿度值',
            data: (function () {
                // generate an array of random data
                var data = [],time = (new Date()).getTime(),i;
                for (i = -19; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 1000,
                        y:tem
                    });
                }
                return data;
            }())
        }


        ];

         json = {};
        json.chart = chart;
        json.title = title;
        json.tooltip = tooltip;
        json.xAxis = xAxis;
        json.yAxis = yAxis;
        json.legend = legend;
        json.exporting = exporting;
        json.series = series;
        json.plotOptions = plotOptions;
        json.lang=lang;

        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
        $('#container').highcharts(json);

        function activeLastPointToolip(chart) {
            var points = chart.series[0].points;
            chart.tooltip.refresh(points[points.length -1]);
        }


    });


    function table2() {
        var mq2=null;
        var mq135=null;
        var  chart1 = {
            type: 'spline',
            animation: Highcharts.svg, // don't animate in IE < IE 10.
            marginRight: 10,
            events: {
                //load: requestData // 图表加载完毕后执行的回调函数

                load: function () {
                    var  series = this.series[0],
                        chart1 = this;
                    activeLastPointToolip(chart1);
                    setInterval(function () {

                        $.post  ("${APP_PATH}/jsondata/chart_data.do", {
                                dnum:"${device_info}"
                            },
                            function(data) {
                                if(data==""){
                                   // $.Huimodalalert('设备已经下线，不能查看当前设备实时信息',2000);

                                }
                                else{
                                    console.log(data);
                                    mq2=data.mq2;
                                    mq135=data.mq135;

                                    var series = chart1.series[0];
                                    var  shift = series.data.length > 20; // 当数据点数量超过 20 个，则指定删除第一个点
                                    var x = (new Date()).getTime();
                                    var y = mq2;
                                    chart1.series[0].addPoint([x,y], true, shift);

                                    var series1 = chart1.series[0];
                                    var  shift1 = series1.data.length > 20; // 当数据点数量超过 20 个，则指定删除第一个点
                                    var x1 = (new Date()).getTime();
                                    var y1 = mq135;
                                    chart1.series[1].addPoint([x1,y1], true, shift1);
                                }
                            }
                        );
                    }, 3000);

                }

            }
        };
        var title = {
            text: 'MQ2&&MQ135实时数据显示图',
            x: -20 //center
        };
        var xAxis = {
            type: 'datetime',
            tickPixelInterval: 150
        };
        var yAxis = {
            title: {
                text: 'MQ2|MQ135值（ppm/%）'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        };
        var tooltip = {
            formatter: function () {
                return '<b>' + this.series.name + '</b><br/>' +
                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                    Highcharts.numberFormat(this.y, 2);
            }
        };
        var plotOptions = {
            area: {
                pointStart: 1940,
                marker: {
                    enabled: false,
                    symbol: 'circle',
                    radius: 2,
                    states: {
                        hover: {
                            enabled: true
                        }
                    }
                }
            }
        };
        var lang={

            printChart:"打印图表",
            downloadJPEG:"下载JPEG图片",
            downloadPDF:"下载PDF文档",
            downloadPNG:"下载PNG图片",
            downloadSVG:"下载SVG矢量图",
            contextButtonTitle:"导出菜单"

        };
        var legend = {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        };
        var exporting = {
            enabled: true
        };
        var series= [{
            name: 'MQ2值',
            data: (function () {
                // generate an array of random data
                var data = [],time = (new Date()).getTime(),i;
                for (i = -19; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 1000,
                        y:mq2
                    });
                }
                return data;
            }())
        },{
            name: 'MQ135值',
            data: (function () {
                // generate an array of random data
                var data = [],time = (new Date()).getTime(),i;
                for (i = -19; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 1000,
                        y:mq2
                    });
                }
                return data;
            }())
        }


        ];

        json = {};
        json.chart = chart1;
        json.title = title;
        json.tooltip = tooltip;
        json.xAxis = xAxis;
        json.yAxis = yAxis;
        json.legend = legend;
        json.exporting = exporting;
        json.series = series;
        json.plotOptions = plotOptions;
        json.lang=lang;

        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
        $('#container1').highcharts(json);

        function activeLastPointToolip(chart) {
            var points = chart.series[0].points;
            chart.tooltip.refresh(points[points.length -1]);
        }

    }

</script>
</body>
</html>