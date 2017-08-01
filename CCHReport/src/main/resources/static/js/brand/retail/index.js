$(function(){
	var loadedImages = 0, // Counter for loaded images
	  con='.retail_bottom ul',
			$container = $(con),
	  tileCount = 30,
	  wookmark;

      // Initialize Wookmark
	   wookmark = new Wookmark(con, {
       	align: 'left',
       	offset:10
      });
		if($(window).width()<700){	
			wookmark = new Wookmark(con, {
				itemWidth:'48%',
				flexibleWidth: true, 
			});
		}
      $container.imagesLoaded()
        .always(function () {
          
        })
        .progress(function (instance, image) {
          // Update progress bar after each image has loaded and remove loading state
          $(image.img).closest('li').removeClass('tile-loading');
          wookmark.updateOptions();
        });
})