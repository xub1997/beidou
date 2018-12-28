var map = new BMap.Map("allmap");
var point = new BMap.Point(113.484908, 23.107454);
var myDis = new BMapLib.DistanceTool(map);
map.centerAndZoom(point, 18);
map.addControl(new BMap.NavigationControl());
map.addControl(new BMap.ScaleControl());
map.addControl(new BMap.OverviewMapControl());
map.addControl(new BMap.MapTypeControl());
map.enableScrollWheelZoom();
map.setCurrentCity("广州"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用

function demon() {
    layui.use(['checkbox', 'layer'], function () {
        var $ = layui.$,
            layer = layui.layer,
            checkbox = layui.checkbox;
        layer.open({
            type: 1,
            title: '选择监控车辆',
            area: ['400px', '250px'],
            content: '<div id="testbox"></div>',
            success: function (layero, index) {
                $("#testbox").children("li").remove();
                checkbox({
                    elem: "#testbox",
                    nodes: [
                        {
                            "id": 1,
                            "name": "1号车",
                            "type": "113.484938,23.107654",
                            "on": false
                        },
                        {
                            "id": 2,
                            "name": "2号车",
                            "type": "113.483513,23.107275",
                            "on": false
                        }
                    ],
                    click: function (node) {
                        map.clearOverlays();
                        var newId = node.id;
                        if (newId === 1) {
                            var num1 = new BMap.Point(113.484938,23.107654);
                        }
                        if (newId === 2) {
                            var num1 = new BMap.Point(113.483513, 23.107275);
                        }
                        var marker = new BMap.Marker(num1); // 创建标注
                        map.addOverlay(marker); // 将标注添加到地图中
                        marker.setAnimation(BMAP_ANIMATION_BOUNCE);
                        map.centerAndZoom(num1, 18); //跳动的动画
                    }/*,
                    del: function (node) {
                        console.log("删除", node);
                        return true;
                    }*/
                });
            }
        });
    });
}

function delpoint() {
    map.clearOverlays();
}