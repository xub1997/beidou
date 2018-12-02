
//获取所有点的坐标
var points = [];

var map; //百度地图对象
var car; //汽车图标
var label; //信息标签
var centerPoint;

var timer; //定时器
var index = 0; //记录播放到第几个point

var followChk, playBtn, pauseBtn, resetBtn; //几个控制按钮

function init() {
    followChk = document.getElementById("follow");
    playBtn = document.getElementById("play");
    pauseBtn = document.getElementById("pause");
    resetBtn = document.getElementById("reset");
    getBtn = document.getElementById("get");

    //初始化地图,选取第一个点为起始点
    map = new BMap.Map("container");
    map.centerAndZoom(new BMap.Point(113.48433, 23.107277), 18);
    map.enableScrollWheelZoom();
    map.addControl(new BMap.NavigationControl());
    map.addControl(new BMap.ScaleControl());
    map.addControl(new BMap.OverviewMapControl({
        isOpen: true
    }));
    console.log("init over");

}

function play() {
    playBtn.disabled = true;
    pauseBtn.disabled = false;

    var point = points[index];
    if(index > 0) {
        map.addOverlay(new BMap.Polyline([points[index - 1], point], {
            strokeColor: "red",
            strokeWeight: 1,
            strokeOpacity: 1
        }));
    }
    label.setContent("经度: " + point.lng + "<br>纬度: " + point.lat);
    car.setPosition(point);
    index++;
    if(followChk.checked) {
        map.panTo(point);
    }
    if(index < points.length) {
        timer = window.setTimeout("play(" + index + ")", 200);
    } else {
        playBtn.disabled = true;
        pauseBtn.disabled = true;
        map.panTo(point);
    }
}

function pause() {
    playBtn.disabled = false;
    pauseBtn.disabled = true;

    if(timer) {
        window.clearTimeout(timer);
    }
}

function reset() {
    followChk.checked = false;
    playBtn.disabled = false;
    pauseBtn.disabled = true;

    if(timer) {
        window.clearTimeout(timer);
    }
    index = 0;
    car.setPosition(points[0]);
    map.panTo(centerPoint);
}

function get() {
    var card = $("#card").val();
    var from = $("#from").val();
    var to = $("#to").val();
    console.log(card);
    console.log(from);
    console.log(to);
    $.ajax({
        type: "post",
        url: "/car/trajectory/get",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({"card": card, "from": from, "to": to}),
        success: function (data) {
            if (data != null && data.length != 0) {
                var gpspoints = [];
                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    points.push(new BMap.Point(data[i].lon, data[i].lat));
                }
                /*
                var start = 0;var end = 0;
                var length = Math.abs(Math.ceil(data.length/99));
                while (length--) {
                    end = Math.min(data.length,(start+99));
                    for (var i = start; i < end; i++) {
                        gpspoints.push(new BMap.Point(data[i].lon, data[i].lat));
                    }
                    translateCallback = function (data) {
                        if (data.status === 0) {
                            for (var i = 0; i < data.points.length; i++) {
                                points.push(data.points[i]);
                            }
                            toTrajectory();
                        }
                    }
                    var convertor = new BMap.Convertor();
                    convertor.translate(gpspoints, 1, 5, translateCallback);
                    start += 100;
                }
                */
                toTrajectory();
                $("#message").text("");
            }else {
                $("#message").text("查询失败");
            }
        },
        error: function () {
            console.log('请求失败 ');
        },

    });
}
function toTrajectory() {
    //通过DrivingRoute获取一条路线的point
    var driving = new BMap.DrivingRoute(map);
    driving.search(points[0], points[points.length-1]);
    driving.setSearchCompleteCallback(function() {
        //根据百度地图推荐的路线得到路线上的所有point，这个在汽车实时轨迹中暂时可以不用
        //points = driving.getResults().getPlan(0).getRoute(0).getPath();

        //画面移动到起点和终点的中间
        centerPoint = new BMap.Point((points[0].lng + points[points.length - 1].lng) / 2, (points[0].lat + points[points.length - 1].lat) / 2);
        map.panTo(centerPoint);
        //连接所有点
        map.addOverlay(new BMap.Polyline(points, {
            strokeColor: "black",
            strokeWeight: 5,
            strokeOpacity: 1
        }));

        //显示小车子
        label = new BMap.Label("", {
            offset: new BMap.Size(-20, -20)
        });
        car = new BMap.Marker(points[0]);
        car.setLabel(label);
        map.addOverlay(car);

        //点亮操作按钮
        playBtn.disabled = false;
        resetBtn.disabled = false;
        getBtn.disabled = true
    });
}


