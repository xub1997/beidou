var shape = "";
var enclosuretype = "";
var cards = [];
function showform() {
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block'
}

function closeform(){
    document.getElementById('light').style.display='none';
    document.getElementById('fade').style.display='none'
}

var map = new BMap.Map('map');
var pt = new BMap.Point(113.483531,23.107291);
map.centerAndZoom(pt, 18);
map.enableScrollWheelZoom();
var overlays = [];

var overlaycomplete = function(e){
    clearenclosure();
    overlays.push(e.overlay);
};
var styleOptions = {
    strokeColor:"#5041ff",    //边线颜色。
    fillColor:"#fdeadc",      //填充颜色。当参数为空时，圆形将没有填充效果。
    strokeWeight: 2,       //边线的宽度，以像素为单位。
    strokeOpacity: 0.6,	   //边线透明度，取值范围0 - 1。
    fillOpacity: 0.6,      //填充的透明度，取值范围0 - 1。
    strokeStyle: 'solid' //边线的样式，solid或dashed。
}
//实例化鼠标绘制工具
var drawingManager = new BMapLib.DrawingManager(map, {
    isOpen: false, //是否开启绘制模式
    enableDrawingTool: true, //是否显示工具栏
    drawingToolOptions: {
        anchor: BMAP_ANCHOR_TOP_RIGHT, //位置
        offset: new BMap.Size(5, 5), //偏离值
    },
    circleOptions: styleOptions, //圆的样式
    polylineOptions: styleOptions, //线的样式
    polygonOptions: styleOptions, //多边形的样式
    rectangleOptions: styleOptions //矩形的样式
});
//添加鼠标绘制工具监听事件，用于获取绘制结果
drawingManager.addEventListener('overlaycomplete', overlaycomplete);

drawingManager.addEventListener('circlecomplete',function(e, overlay) {
    var c = overlay.point; //获取所绘制的圆的圆心
    var r = overlay.getRadius();//获取所绘制的圆的半径
    //console.log(r);
    var circle = new BMap.Circle(c,r);//所绘制的圆
    shape = r+"#"+c.lng+"&"+c.lat;
    enclosuretype = "CIRCLE";
    console.log(shape)
});

drawingManager.addEventListener('polygoncomplete',function (e,overlay) {
    var pts =overlay.getPath();//获取所绘制的多边形各个点的坐标
    //console.log(pts);
    var ply = new BMap.Polygon(pts);//绘制多边形
    shape = "";
    var rec = ply.getBounds();
    var sw = rec.getSouthWest();
    var ne = rec.getNorthEast()
    for(var i = 0; i < pts.length; i++){
        var point = pts[i];
        shape += point.lng+"&"+point.lat+"#";
    }
    shape += sw.lng+"&"+sw.lat+"#"+ne.lng+"&"+ne.lat;
    enclosuretype = "POLYGON";
    console.log(shape)
});

drawingManager.addEventListener('rectanglecomplete',function (e,overlay) {
    var rec = overlay.getBounds();
    var sw = rec.getSouthWest();
    var ne = rec.getNorthEast()
    shape  = sw.lng+"&"+sw.lat+"#"+ne.lng+"&"+ne.lat;
    enclosuretype = "RECTANGLE";
    console.log(shape)
});

function clearAll() {
    shape = "";
    clearenclosure();
}

$(function () {
    $(":checkbox").change(function() {
        var checked = [];
        $('input:checkbox:checked').each(function() {
            checked.push($(this).val());
        });
        cards = checked;
    });
});



function clearenclosure() {
    for(var i = 0; i < overlays.length; i++){
        map.removeOverlay(overlays[i]);
    }
    overlays.length = 0;
}

function addenclosure() {
    if(cards.length == 0){
        $("#tip").text("请选择终端");
        return;
    }
    if(shape == ""){
        $("#tip").text("请绘制围栏");
        return;
    }
    var name = $("#name").val();
    var valid = $("#valid").val();
    var invalid = $("#invalid").val();
    var start = $("#start").val();
    var stop = $("#stop").val();
    var speed = $("#speed").val();
    if(name == ""){
        $("#tip").text("请填写围栏名称");
        return;
    }
    if(valid == "" || invalid == "" || start == "" || stop == "" || speed == ""){
        $("#tip").text("请选择时间日期");
        return;
    }
    if((valid > invalid) || (start > stop)){
        $("#tip").text("时间日期选择有误");
        return;
    }
    start = "2018-06-14T"+start;
    stop = "2018-06-14T"+stop;
    var warntype = $("#warntype").val();
    var cars = [];
    for (var i = 0; i < cards.length; i++){
        cars.push(new car(cards[i]));
    }
    console.log(start,stop);
    $.ajax({
        type: "post",
        url: "/warn/enclosure/add",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({"name":name,"valid":valid,"invalid":invalid,"start":start,"stop":stop,"speed":speed,"enclosuretype":enclosuretype,"enclosurewarntype":warntype,"shape":shape,"cars":cars}),
        success: function (data) {

            if (data != null && data.length != 0) {
                console.log(data);
                if(data == 1) {
                    closeform();
                    location.reload();
                    alert("保存成功");
                }else{
                    alert("请先登录")
                }
            }else {
                $("#message").text("查询失败");
            }
        },
        error: function () {
            console.log('请求失败 ');
        },

    });
}

function car(card) {
    this.card = card;
}
