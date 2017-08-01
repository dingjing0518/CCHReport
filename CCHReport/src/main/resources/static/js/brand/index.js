$(function() {
	var loadedImages = 0, // Counter for loaded images
	container = '.wookmark-list', $container = $(container), tileCount = 30, wookmark;

	// Initialize Wookmark
	wookmark = new Wookmark(container, {
		align : 'left',
		comparator : null,
	});

	if ($(window).width() < 700) {
		wookmark = new Wookmark(container, {
			itemWidth : '48%',
			flexibleWidth : true,
		});
	}

	$container.imagesLoaded().always(function() {

	}).progress(function(instance, image) {
		// Update progress bar after each image has loaded and remove loading state
		$(image.img).closest('div').removeClass('tile-loading');
		wookmark.updateOptions();
	});
})