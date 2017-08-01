var mySwiper2 = new Swiper('.swiper-container2', {
        loop: true,
        speed: 800,
        slidesPerView: 1,
        autoplay: false, //可选选项，自动滑动
        simulateTouch: false //禁止鼠标点击和拖动

    })
    function next() {
        mySwiper.slideNext(function () {
        }, 2000);
    }

    function next() {
        mySwiper.slideNext();
    }