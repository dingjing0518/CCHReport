// JavaScript Document
$(function(){
	$('.nav-btn').click(function(){
		var $nav=$('.innerHeader nav');
		$('.filmheader').hide();
		if($nav.is(':hidden')){
			$('body').addClass('open');
			$('.iPage').show();
			$nav.show();
		}else{
			$('body').removeClass('open')
			$nav.hide();
			$('.iPage').hide();
		}
	})	
	$('.bgmask').click(function(){
		$('body').removeClass('open');
		$('.innerHeader nav').hide();
		$('.iPage').hide();
	})
	$('.bnav-hd').click(function(){
		var $bnav=$('.filmheader');
		if($bnav.is(':hidden')){
			$bnav.slideDown();
			$(this).addClass('rotate')
		}else{
			$bnav.slideUp();
			$(this).removeClass('rotate')	
		}
	})	
  
	/*********** 加载地图 ************/
    $('.view-map').click(function(){
    	loadJScript('sh');    	
    });
    
})




//百度异步加载地图
function loadJScript(e) {
	var script = document.createElement("script");
	script.type = "text/javascript";
	script.src = "http://api.map.baidu.com/api?v=2.0&ak=45D0Env5U7WMZ3j9P0kTa8gy&callback="+e+"_init";
	document.body.appendChild(script);
}
 
function sh_init() {
	var map = new BMap.Map("sh-map");    
    var point = new BMap.Point(121.331977,31.305174);
    map.centerAndZoom(point,17);                 
    map.enableScrollWheelZoom();
    map.addControl(new BMap.MapTypeControl()); 
    var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});
	var top_left_navigation = new BMap.NavigationControl(); 
	map.addControl(top_left_control);        
	map.addControl(top_left_navigation);  
    var marker = new BMap.Marker(new BMap.Point(121.331977,31.305174));
    map.addOverlay(marker);             
    marker.setAnimation(BMAP_ANIMATION_BOUNCE);
    var opts = {
	  width : 200,
	  height: 90,
	  title : "南翔太茂商业广场"
	}
	var infoWindow = new BMap.InfoWindow("地址：上海市嘉定区南翔镇丰翔路3168号", opts);
	map.openInfoWindow(infoWindow,point);
	marker.addEventListener('click',function(){
		map.openInfoWindow(infoWindow,point);
	});
}  
