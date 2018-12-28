
var vm1 = new Vue({
    el:'#checkbtn',
    methods:{
        docheck: function(){
            this.$http.get('single.json').then(function(result){
                //console.log(result.data);
                var lng = result.data.lng,
                    lat = result.data.lat;

                this.$http.jsonp("http://api.map.baidu.com/geoconv/v1/?coords="+ lng +"," + lat+ "&from=1&to=5&ak=ijFmea7PT5GlBEsq7CbHNSTQALgPV7cZ",
                ).then(function(result){
                        console.log(result.data.result[0]);
                        var x = result.data.result[0].x,
                            y = result.data.result[0].y;

                    var currentTime = '{"lng":' + x + ','+'"lat":'+ y +  '}';
                    var JcurrentTime = currentTime.toString();//将二进制的数据转换为字符串
                    JcurrentTime = JSON.parse(JcurrentTime);
                    //console.log(JcurrentTime);

                    map.clearOverlays();
                    var point = new BMap.Point(x,y);
                    var marker = new BMap.Marker(point); // 创建标注
                    map.addOverlay(marker); // 将标注添加到地图中
                    marker.setAnimation(BMAP_ANIMATION_BOUNCE);
                    map.centerAndZoom(point, 18); //跳动的动画
                })
            })
        }
    }
});

var vm2 =new Vue({
    el:'#WXcheckbtn',
    methods:{
        doWXcheck:function(){
            this.$http.get('/json/WXtest.json').then(function(result){
                //console.log(result.data);
                var lng = result.data.lng,
                    lat = result.data.lat;

                this.$http.jsonp("http://api.map.baidu.com/geoconv/v1/?coords="+ lng +"," + lat+ "&from=3&to=5&ak=ijFmea7PT5GlBEsq7CbHNSTQALgPV7cZ",
                ).then(function(result){
                    console.log(result.data.result[0]);
                    var x = result.data.result[0].x,
                        y = result.data.result[0].y;

                    var currentTime = '{"lng":' + x + ','+'"lat":'+ y +  '}';
                    var JcurrentTime = currentTime.toString();//将二进制的数据转换为字符串
                    JcurrentTime = JSON.parse(JcurrentTime);
                    //console.log(JcurrentTime);

                    map.clearOverlays();
                    var point = new BMap.Point(x,y);
                    var marker = new BMap.Marker(point); // 创建标注
                    map.addOverlay(marker); // 将标注添加到地图中
                    marker.setAnimation(BMAP_ANIMATION_BOUNCE);
                    map.centerAndZoom(point, 18); //跳动的动画
                })
            })
        }
    }
})