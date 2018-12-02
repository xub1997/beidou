var stompClient = null;
var cars = [];
var pos = [];
var names = [];
var markers = [];
var watch = null;
var flag = false;//连接状态 false为未连接
var marker = new BMap.Marker(new BMap.Point(116.404, 39.915));
var headers = {
    name: 'admin',
    // additional header
    'client-id': '123'
};

function connect() {
    if (flag)return;
    var socket = new SockJS('/gps');
    stompClient = Stomp.over(socket);
    stompClient.connect(headers, function (frame) {
        console.log('Connected: ' + frame);
        flag = true;
        sendCars();
        stompClient.subscribe('/user/topic/position', function (position) {
            pos = JSON.parse(position.body);
            console.log(pos);
            showPosition(pos);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
        flag = false;
    }
    console.log("Disconnected");
}

function sendCars() {
    if (!flag){return;}
    var temp = [];
    for (var i = 0;i < cars.length;i+=2){
        temp.push(cars[i]);
    }
    stompClient.send("/app/cars", {}, temp);
}


$(function () {
    $(":checkbox").change(function() {
        watch = this.value;
        showcars();
        if(cars.length > 0){
            connect();
            sendCars();
        }else if(cars.length == 0)disconnect();
    });
    for (var i = 0; i< $(":checkbox").length; i++){
        var name = $(":checkbox").get(i).name;
        var value = $(":checkbox").get(i).value;
        var label = new BMap.Label("卡号:"+value+" "+name,{offset:new BMap.Size(20,-10)});
        var temp = new BMap.Marker(new BMap.Point(116.404, 39.915));
        temp.setTitle(value);
        temp.setLabel(label);
        temp.hide();
        markers.push(temp);
        map.addOverlay(temp);
    }
});

function showcars(){
	var checked = [];
	$('input:checkbox:checked').each(function() {
            checked.push($(this).val());
            checked.push($(this).text());
        });
        cars = checked;
        for (var i = 0; i < markers.length; i++){
            for (var j = 0; j <= cars.length ; j++){
                if(markers[i].getTitle() == cars[j-1]){
                    markers[i].show();
                    break;
                }
                if (j == cars.length)markers[i].hide();
            }
        }
}

function showPosition(position) {
    if(position.length == 1){
        //解析汽车的监控信息
        return;
    }
    translateCallback = function (data) {
        console.log(data);
        if(data.status === 0) {
            for (var i=0;i<data.points.length;i++) {
                for (var j = 0; j < markers.length; j++){
                    if (markers[j].getTitle() == position[i*3]){
                        markers[j].setPosition(data.points[i]);
                        console.log(markers[j].getTitle());
                        console.log(data.points[i]);
                        break;
                    }
                }
            }
            for (var i = 0 ; i < markers.length ; i++){
                if (markers[i].getTitle() == watch){
                    map.panTo(markers[i].getPosition());
                }
            }
        }
    }
    var points =[];
    for (var i=0;i<position.length;i+=3){
        var point = new BMap.Point(position[i+1],position[i+2]);
        points.push(point);
        console.log(i+point);
    }
    if(points.length > 0) {
        var convertor = new BMap.Convertor();
        convertor.translate(points, 1, 5, translateCallback);
    }
}


function deletePoint(name){
    var allOverlay = map.getOverlays();
    for (var i = 0; i < allOverlay.length -1; i++){
        if(allOverlay[i].getLabel().content == name){
            markers.remove(allOverlay[i]);
            console.log(markers);
            map.removeOverlay(allOverlay[i]);
            return false;
        }
    }
}

$(document).ready(function(){
    $("button").click(function(){
        watch = this.value;
    });
});
