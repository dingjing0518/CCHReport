$(function() {
	$("div .banner").each(function(index){
	    if($(window).width()<700) {
	    	$(this).css("background","url("+$(this).attr("data")+") no-repeat");
	    	$(this).css("background-size","cover");
	    	$(this).css("background-position","50% 50%");
	    } else {
	    	$(this).css("background","url("+$(this).attr("src")+") no-repeat");
	    	$(this).css("background-size","cover");
	    	if(index==1){
	    		$(this).css("background-position","40% 50%");
			}else if(index==2){
				$(this).css("background-position","0% 50%");
			}else{
				$(this).css("background-position","50% 50%");
			}
	    }
	});
	
	mySwiper = new Swiper('.swiper-container', {
		loop:true,
		speed:2000,
		slidesPerView:1,
		autoplay: 3000,//可选选项，自动滑动
		simulateTouch:false, //禁止鼠标点击和拖动
		pagination : '.pagination',
	})

	if($(window).width()<700){
		mySwiper.params.speed=500;
	}
	
	function next(){
		mySwiper.slideNext(function(){},2000);
	}
	function next(){
		mySwiper.slideNext();
	}
})

