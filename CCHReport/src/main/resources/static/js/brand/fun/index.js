function film() {
	location.href = 'film.html';
}

var mySwiper = new Swiper('.swiper-container', {
	speed : 800,
	slidesPerView : 1,
	autoplay : 5000, //可选选项，自动滑动
	simulateTouch : false, //禁止鼠标点击和拖动
	effect : 'flip',
	flip : {
		slideShadows : true,
		limitRotation : true
	}

})

function next() {
	mySwiper.slideNext(function() {
	}, 2000);
}

function next() {
	mySwiper.slideNext();
}

$(function() {
	var loadedImages = 0, // Counter for loaded images
	con = '.retail_bottom ul', $container = $(con), tileCount = 30, wookmark;

	// Initialize Wookmark
	wookmark = new Wookmark(con, {
		align : 'left',
		offset : 10
	});
	if ($(window).width() < 700) {
		wookmark = new Wookmark(con, {
			itemWidth : '48%',
			flexibleWidth : true,
		});
	}
	$container.imagesLoaded().always(function() {

	}).progress(function(instance, image) {
		// Update progress bar after each image has loaded and remove loading state
		$(image.img).closest('li').removeClass('tile-loading');
		wookmark.updateOptions();
	});
})