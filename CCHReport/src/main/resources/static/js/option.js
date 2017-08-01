var myCharts = [];
var global = {
	context : "/cchReport"
};
var apilist = [ global.context + '/summaryReport/data',
        global.context + '/fandataReport/data',
        global.context + '/memberdataReport/data',
		global.context + '/menudataReport/data',
		global.context + '/fandataSourceReport/data',  
		global.context + '/websitedataReport/data'];
$(function() {
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth();

	var startDate = new Date(year, month, 1);
	var endDate = new Date(new Date().getFullYear(), new Date().getMonth() + 1,
			0);

	$("#my-startDate").text(startDate.Format("yyyy-MM-dd"));

	$("#my-endDate").text(endDate.Format("yyyy-MM-dd"));

	var $alert = $('#my-alert');
	$('#my-start').datepicker().on('changeDate.datepicker.amui',
			function(event) {
				if (event.date.valueOf() > endDate.valueOf()) {
					$alert.find('p').text('开始日期应小于结束日期！').end().show();
				} else {
					$alert.hide();
					startDate = new Date(event.date);
					$('#my-startDate').text($('#my-start').data('date'));
					qapi(year, month, 3);
				}
				$(this).datepicker('close');
			});

	$('#my-end').datepicker().on('changeDate.datepicker.amui', function(event) {
		if (event.date.valueOf() < startDate.valueOf()) {

			$alert.find('p').text('结束日期应大于开始日期！').end().show();
		} else {
			$alert.hide();
			endDate = new Date(event.date);
			$('#my-endDate').text($('#my-end').data('date'));
			qapi(year, month, 3);
		}
		$(this).datepicker('close');
	});

});
$(function() {
	$(".am-tabs-bd .am-tab-panel")
			.each(
					function(k) {
						var date = new Date();
						var year = date.getFullYear();
						var month = date.getMonth() + 1;
						var $years = $("#year").children();
						var str1 = "";
						for (var i = 0; i < $years.length; i++) {
							var newyear = $years[i].value;
							if (year == newyear) {
								str1 += '<option value=' + newyear
										+ ' selected="selected">' + newyear
										+ '年</option>'
							} else {
								str1 += '<option value=' + newyear + '>'
										+ newyear + '年</option>'
							}
						}
						var tit = $(".am-tabs-nav li:eq(" + k + ")").children(
								'a').text();
						var str = "";
						if (k != 3) {
							if (k == 0) {
								str += '<h2 class="am-text-primary" style="text-align: center">会员粉丝概要</h2>';
							}
							if (k == 1) {
								str += '<h2 class="am-text-primary" style="text-align: center">粉丝数</h2>';
							}
							if (k == 2) {
								str += '<h2 class="am-text-primary" style="text-align: center">会员统计</h2>';
							}
							if (k == 4) {
								str += '<h2 class="am-text-primary" style="text-align: center">粉丝来源</h2>';
							}
							if (k == 5) {
								str += '<h2 class="am-text-primary" style="text-align: center">网站访问量</h2>';
							}
							str += '<form class="am-form am-g"><div class="am-form-select am-u-sm-6">'
									+ '<select onchange="querydata('
									+ k
									+ ')" class="year-sl'
									+ k
									+ '" data-am-selected="{ btnWidth: \'100%\',btnSize: \'sm\', btnStyle: \'secondary\'}">'
									+ '</select></div>'
									+ '<div class="am-form-select am-u-sm-6" >'
									+ '<select onchange="querydata('
									+ k
									+ ')" class="month-sl'
									+ k
									+ '" data-am-selected="{btnWidth: \'100%\',btnSize: \'sm\', btnStyle: \'secondary\'}">'
									+ '<option value="-1" >全部</option>'
									+ '<option value="1" >1月</option>'
									+ '<option value="2" >2月</option>'
									+ '<option value="3" >3月</option>'
									+ '<option value="4" >4月</option>'
									+ '<option value="5" >5月</option>'
									+ '<option value="6" >6月</option>'
									+ '<option value="7" >7月</option>'
									+ '<option value="8" >8月</option>'
									+ '<option value="9" >9月</option>'
									+ '<option value="10" >10月</option>'
									+ '<option value="11" >11月</option>'
									+ '<option value="12" >12月</option>'
									+ '</select></div>';
							$(this).prepend(str);
							$(".year-sl" + k).prepend(str1);
							var $ops = $(".month-sl" + k).children();
							for (var i = 0; i < $ops.length; i++) {
								var newmonth = $ops[i].value;
								if (month == newmonth) {
									$ops[i].selected = true;
								}
							}
						}
						if (apilist[k] != "") {
							qapi(year, month, k);
						}
					});
});

function querydata(k) {
	var year = $(".year-sl" + k).val();
	var month = $(".month-sl" + k).val();
	var $lis=$(".year-sl0").parent().find("li");
	for(var i=0;i<$lis.length;i++){
		var li=$lis[i];
		li.className="";
		var sval=li.attributes["data-value"].value;
		if(sval==year){
			li.className="am-checked";
		}
	}
	var $lis=$(".year-sl1").parent().find("li");
	for(var i=0;i<$lis.length;i++){
		var li=$lis[i];
		li.className="";
		var sval=li.attributes["data-value"].value;
		if(sval==year){
			li.className="am-checked";
		}
	}
	var $lis=$(".year-sl2").parent().find("li");
	for(var i=0;i<$lis.length;i++){
		var li=$lis[i];
		li.className="";
		var sval=li.attributes["data-value"].value;
		if(sval==year){
			li.className="am-checked";
		}
	}
	var $lis=$(".year-sl4").parent().find("li");
	for(var i=0;i<$lis.length;i++){
		var li=$lis[i];
		li.className="";
		var sval=li.attributes["data-value"].value;
		if(sval==year){
			li.className="am-checked";
		}
	}
	var $lis=$(".year-sl5").parent().find("li");
	for(var i=0;i<$lis.length;i++){
		var li=$lis[i];
		li.className="";
		var sval=li.attributes["data-value"].value;
		if(sval==year){
			li.className="am-checked";
		}
	}
	$(".year-sl0").parent().find("span").eq(0).html(year+"年");
	$(".year-sl1").parent().find("span").eq(0).html(year+"年");
	$(".year-sl2").parent().find("span").eq(0).html(year+"年");
	$(".year-sl4").parent().find("span").eq(0).html(year+"年");
	$(".year-sl5").parent().find("span").eq(0).html(year+"年");
	var $lis=$(".month-sl0").parent().find("li");
	for(var i=0;i<$lis.length;i++){
		var li=$lis[i];
		li.className="";
		var sval=li.attributes["data-value"].value;
		if(sval==month){
			li.className="am-checked";
		}
	}
	var $lis=$(".month-sl1").parent().find("li");
	for(var i=0;i<$lis.length;i++){
		var li=$lis[i];
		li.className="";
		var sval=li.attributes["data-value"].value;
		if(sval==month){
			li.className="am-checked";
		}
	}
	var $lis=$(".month-sl2").parent().find("li");
	for(var i=0;i<$lis.length;i++){
		var li=$lis[i];
		li.className="";
		var sval=li.attributes["data-value"].value;
		if(sval==month){
			li.className="am-checked";
		}
	}
	var $lis=$(".month-sl4").parent().find("li");
	for(var i=0;i<$lis.length;i++){
		var li=$lis[i];
		li.className="";
		var sval=li.attributes["data-value"].value;
		if(sval==month){
			li.className="am-checked";
		}
	}
	var $lis=$(".month-sl5").parent().find("li");
	for(var i=0;i<$lis.length;i++){
		var li=$lis[i];
		li.className="";
		var sval=li.attributes["data-value"].value;
		if(sval==month){
			li.className="am-checked";
		}
	}
	var monthstr="";
	if(month==-1){
		monthstr="全部";
	}else{
		monthstr=month+"月";
	}
	$(".month-sl0").parent().find("span").eq(0).html(monthstr);
	$(".month-sl1").parent().find("span").eq(0).html(monthstr);
	$(".month-sl2").parent().find("span").eq(0).html(monthstr);
	$(".month-sl4").parent().find("span").eq(0).html(monthstr);
	$(".month-sl5").parent().find("span").eq(0).html(monthstr);
	qapi(year, month, 0);
	qapi(year, month, 1);
	qapi(year, month, 2);
	qapi(year, month, 4);
	qapi(year, month, 5);
}

Date.prototype.Format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}

function qapi(year, month, k) {
	myCharts[k] = echarts.init(document.getElementById('main' + k), 'shine');
	$.AMUI.progress.start();
	if (k == 3) {
		var url = apilist[k] + "?startTime=" + $('#my-startDate').text()
				+ "&endTime=" + $('#my-endDate').text();
	} else {
		var url = apilist[k] + "?year=" + year + "&month=" + month;
	}
	$.getJSON(url, function(result) {
		console.log(result);
		if (k != 3)
			result.dataZoom = [ {
				type : "inside"
			} ];
		myCharts[k].setOption(result);
		$.AMUI.progress.done();
	})
}