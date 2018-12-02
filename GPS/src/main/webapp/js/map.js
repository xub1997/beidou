var map = new BMap.Map("allmap"); 
map.centerAndZoom(new BMap.Point(116.331398,39.897445),11);
map.addControl(new BMap.MapTypeControl({
	mapTypes: [
		BMAP_NORMAL_MAP,
		BMAP_HYBRID_MAP
	]
}));
map.setCurrentCity("广州"); 
map.enableScrollWheelZoom(true); 
map.addControl(new BMap.NavigationControl());
map.addControl(new BMap.ScaleControl());
map.addControl(new BMap.OverviewMapControl());
map.addControl(new BMap.MapTypeControl());
	function showInfo(e){
		alert(e.point.lng + ", " + e.point.lat);	
	}
	function addClick(){
		map.addEventListener("click", showInfo);
	}
	function removeClick(){
		map.removeEventListener("click", showInfo);
	}

