export let trackback = (points, map, Begin, End) => {
  var donePoints = []; //已经显示的点。
  var bPoints = []; //保存百度化的坐标组。用于重设地图的中心点和显示级别。
  var timerArr = []; //定时器
  var interval;
  console.log(Begin, End);
  //根据时间选择。
  //清除当前所有的定时器和地图上的覆盖物。
  map.clearOverlays();
  for (var t = 0; t < timerArr.length; t++) {
    clearTimeout(timerArr[t]);
  }
  timerArr = [];
  clearInterval(interval);
  bPoints.length = 0;
  donePoints.length = 0;

  var dateBegin = Begin;
  var dateEnd = End;

  //从原始数组中查询符合条件的坐标点。
  var pointsLen = points.length;
  var searchRes = points; //用来装符合条件的坐标信息。

  for (var j = 0; j < searchRes.length; j++) {
    //var wait = dateDiff(searchRes[j].time, dateBegin) * 100; //等待时间。
    var timeDelay=1000;
    (function () {
      var pointAg = [searchRes[j]],
          timer; //闭包
      timer = setTimeout(function () {
        var doneLen = donePoints.length;
        var linePoints = [];
        if (doneLen != 0) {
          linePoints.push(donePoints[doneLen - 1]);
        }
        linePoints.push(pointAg[0]);
        donePoints.push(pointAg[0]);
        addLine(linePoints); //把原始数据的轨迹线添加到地图上。
        addMarker(pointAg);
        bPoints.push(new BMap.Point(pointAg[0].lon, pointAg[0].lat));
        setZoom(bPoints);
      }, timeDelay);
      timerArr.push(timer);
    })();
  }

  function getRandom(n) {
    return Math.floor(Math.random() * n + 1)
  }

  //根据点信息实时更新地图显示范围，让轨迹完整显示。设置新的中心点和显示级别
  function setZoom(bPoints) {
    var view = map.getViewport(eval(bPoints));
    var mapZoom = view.zoom;
    var centerPoint = view.center;
    map.centerAndZoom(centerPoint, mapZoom);
  }

  //在轨迹点上创建图标，并添加点击事件，显示轨迹点信息。points,数组。
  function addMarker(points) {
    var pointsLen = points.length;
    if (pointsLen == 0) {
      return;
    }
    var myIcon = new BMap.Icon("./img/car.png", new BMap.Size(48, 48), {
      offset: new BMap.Size(10, 10)
    });

    // 创建标注对象并添加到地图
    for (var i = 0; i < pointsLen; i++) {
      var point = new BMap.Point(points[i].lon, points[i].lat);
      var marker = new BMap.Marker(point, {
        icon: myIcon
      });
      map.addOverlay(marker);
      (function () {
        var thePoint = points[i];
        marker.addEventListener("click", function () {
          showInfo(this, thePoint);
        });
      })();
    }
  }

  //点击轨迹点后显示信息窗口
  function showInfo(thisMaker, point) {
    var sContent = "<p>司机：" + point.driver + "</p>"+
        "<p>公司：" + point.comName + "</p>"+
        "<p>lon：" + point.lon + "</p>"+
        "<p>lat：" + point.lat + "</p>"+
        "<p>时间：" + point.utcTime  + "</p>";
    var infoWindow = new BMap.InfoWindow(sContent); // 创建信息窗口对象
    thisMaker.openInfoWindow(infoWindow); //图片加载完毕重绘infowindow
  }

  //添加线
  function addLine(points) {
    var linePoints = [];
    var pointsLen = points.length;
    if (pointsLen == 0) {
      return;
    }
    // 创建标注对象并添加到地图
    for (var i = 0; i < pointsLen; i++) {
      linePoints.push(new BMap.Point(points[i].lon, points[i].lat));
    }
    var polyline = new BMap.Polyline(linePoints, {
      strokeColor: "red",
      strokeWeight: 2,
      strokeOpacity: 1
    }); //创建折线
    map.addOverlay(polyline); //增加折线
  }

  //显示轨迹运行的时间
  function trackTime(beginTime) {
    clearInterval(interval);
    var beginTimestamp = Date.parse(new Date(beginTime));
    interval = setInterval(function () {
      var time = getDate(beginTimestamp).time;
      document.getElementById('realTime').innerHTML = "回放时间" + time;
      beginTimestamp = beginTimestamp + 1000;
    }, 1000)

  }

  //根据时间戳（毫秒），返回处理过后的时间。
  function getDate(ms) {
    var res;
    if (ms != undefined) {
      var today = new Date();
      today.setTime(ms);
    } else {
      var today = new Date();
    }

    var year, month, day, hour, minute, second;
    year = today.getFullYear();
    month = today.getMonth() + 1;
    if (month < 10) {
      month = '0' + month;
    }
    day = today.getDate();
    if (day < 10) {
      day = '0' + day;
    }
    hour = today.getHours();
    if (hour < 10) {
      hour = '0' + hour;
    }
    minute = today.getMinutes();
    if (minute < 10) {
      minute = '0' + minute;
    }
    second = today.getSeconds();
    if (second < 10) {
      second = '0' + second;
    }
    res = {
      'y': year,
      'M': month,
      'd': day,
      'h': hour,
      "m": minute,
      "s": second,
      "time": year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second,
      "date": year + "-" + month + "-" + day
    };
    return res;
  }

  //求时间差的方法
  function dateDiff(date1, date2) {
    var type1 = typeof date1,
        type2 = typeof date2;
    if (type1 == 'string')
      date1 = stringToTime(date1);
    else if (date1.getTime)
      date1 = date1.getTime();
    if (type2 == 'string')
      date2 = stringToTime(date2);
    else if (date2.getTime)
      date2 = date2.getTime();
    return (date1 - date2) / 1000; //结果是秒
  }

  //字符串转成Time(dateDiff)所需方法
  function stringToTime(string) {
    var f = string.split(' ', 2);
    var d = (f[0] ? f[0] : '').split('-', 3);
    var t = (f[1] ? f[1] : '').split(':', 3);
    return (new Date(
        parseInt(d[0], 10) || null,
        (parseInt(d[1], 10) || 1) - 1,
        parseInt(d[2], 10) || null,
        parseInt(t[0], 10) || null,
        parseInt(t[1], 10) || null,
        parseInt(t[2], 10) || null
    )).getTime();
  }
};
