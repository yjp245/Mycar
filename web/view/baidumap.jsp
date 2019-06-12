<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>点标记</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <style>
        html, body, #container {
            height: 100%;
            width: 100%;
        }

        .amap-icon img,
        .amap-marker-content img{
            width: 25px;
            height: 34px;
        }

        .marker {
            position: absolute;
            top: -20px;
            right: -118px;
            color: #fff;
            padding: 4px 10px;
            box-shadow: 1px 1px 1px rgba(10, 10, 10, .2);
            white-space: nowrap;
            font-size: 12px;
            font-family: "";
            background-color: #25A5F7;
            border-radius: 3px;
        }

        .input-card{
            width: 32rem;
            z-index: 170;
        }

        .input-card .btn{
            margin-right: .8rem;
        }

        .input-card .btn:last-child{
            margin-right: 0;
        }
    </style>
    <script src="https://webapi.amap.com/maps?v=1.4.10&key=	9990d3fdf086ece071c5b62183eb9fb3"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
<div id="container"></div>
<div class="input-card">
    <label style="color:grey">点标记操作</label>
    <div class="input-item">
        <input id="addMarker" type="button" class="btn" onclick="addMarker()" value="添加点标记覆盖物">
        <input id="updateMarker" type="button" class="btn" onclick="updateMarker()" value="更新点标记覆盖物">
        <input id="clearMarker" type="button" class="btn" onclick="clearMarker()" value="删除点标记覆盖物">
    </div>
</div>
<script>

    var marker, map = new AMap.Map("container", {
        resizeEnable: true,
        center: [117.56497, 26.19467],
        zoom: 20
    });
    AMap.event.addDomListener(document.getElementById('addMarker'), 'click', function() {
        addMarker();
    }, false);
  
    AMap.event.addDomListener(document.getElementById('clearMarker'), 'click', function() {
        if (marker) {
            marker.setMap(null);
            marker = null;
        }
    }, false);

      marker = new AMap.Marker({
          icon: "//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png",
          position: [117.56555, 26.19250],
          offset: new AMap.Pixel(-13, -30)
      });
      marker.setMap(map);
 

  

</script>
</body>
</html>

<!-- <!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>默认点标记</title>
    <link rel="stylesheet" href="https://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css"/>
    <style>
        html, body, #container {
            height: 100%;
            width: 100%;
        }

        .amap-icon img,
        .amap-marker-content img{
            width: 25px;
            height: 34px;
        }

        .marker {
            position: absolute;
            top: -20px;
            right: -118px;
            color: #fff;
            padding: 4px 10px;
            box-shadow: 1px 1px 1px rgba(10, 10, 10, .2);
            white-space: nowrap;
            font-size: 12px;
            font-family: "";
            background-color: #25A5F7;
            border-radius: 3px;
        }

        .input-card{
            width: 32rem;
            z-index: 170;
        }

        .input-card .btn{
            margin-right: .8rem;
        }

        .input-card .btn:last-child{
            margin-right: 0;
        }
    </style>
</head>
<body>
<div id="container"></div>
<div class="input-card">
    <label style="color:grey"></label>
    <div class="input-item">
        <input id="addMarker" type="button" class="btn" onclick="addMarker()" value="我所在位置">
    </div>
</div>
<script type="text/javascript"
        src="https://webapi.amap.com/maps?v=1.4.10&key=	9990d3fdf086ece071c5b62183eb9fb3"></script>
<script type="text/javascript">
    var marker, map = new AMap.Map("container", {
        resizeEnable: true,
        center: [117.56497, 26.19460],
        zooms: [4,18],//设置地图级别范围
        zoom: 13
    });
    
    // 实例化点标记
        marker = new AMap.Marker({
            icon: "//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png",
            position: [117.56555, 26.19250],
            offset: new AMap.Pixel(-13, -30)
        });
        marker.setMap(map);
 

 
</script>
</body>
</html> -->