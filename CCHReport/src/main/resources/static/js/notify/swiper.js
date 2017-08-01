$(function(){
	if ($(window).width() > 700) {
		$('body').addClass('fixed')
	} else {
		$('.vip').css("background-position","center center");
	}
	mySwiper = new Swiper('.swiper-container', {
		speed : 1000,
		slidesPerView : "auto",
		autoplay : 3000,//可选选项，自动滑动
		simulateTouch : false
		//禁止鼠标点击和拖动
	})

	function next() {
		mySwiper.slideNext(function() {
		}, 2000);
	}
	function next() {
		mySwiper.slideNext();
	}
});
