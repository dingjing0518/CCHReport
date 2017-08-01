$(function() {
	if($(window).width()>700){
		$('body').addClass('fixed');
		$('.about').css("background","url("+$('.about').attr("src")+") no-repeat");
		$('.about').css("background-size","cover");
//		$('.about').css("background-position","50% 50%");
	}else{
		$('.modal').remove();
		$('.about').css("background","url("+$('.about').attr("data")+") no-repeat");
		$('.about').css("background-size","cover");
		$('.about').css("background-position","50% 50%");
	}
	if($(window).height()<800 && $(window).width()>700){
		$('.ab_box>div').css('margin-top','-50px')
		$('.ab_box>div.ab_last').css('margin-top','-80px')
		$('.ab_box>div.ab_last img').css('width','80%')
	}
});