$(function() {
	$('#tol_submit').click(function() {
		var market = $("#market_id").find("option:selected").val();
		var browseTime = $("#browseTime1_id").val();
		var siteName = $("#siteName_id").find("option:selected").val();
		var siteName1 = $("#siteName1_id").find("option:selected").val();
		var siteName2 = $("#siteName2_id").find("option:selected").val();
		var siteName3 = $("#siteName3_id").find("option:selected").val();
		var siteName4 = $("#siteName4_id").find("option:selected").val();
		var siteName5 = $("#siteName5_id").find("option:selected").val();
		var siteName6 = $("#siteName6_id").find("option:selected").val();
		var siteNumber = $("#siteNumber_id").val();
		var siteNumber1 = $("#siteNumber1_id").val();
		var siteNumber2 = $("#siteNumber2_id").val();
		var siteNumber3 = $("#siteNumber3_id").val();
		var siteNumber4 = $("#siteNumber4_id").val();
		var siteNumber5 = $("#siteNumber5_id").val();
		var siteNumber6 = $("#siteNumber6_id").val();
		var ok = true;
		if (market == '') {
			ok = false;
		}
		if (browseTime == '') {
			ok = false;
		}
		if (siteNumber == '') {
			ok = false;
		}
		if (siteNumber1 == '') {
			ok = false;
		}
		if (siteNumber2 == '') {
			ok = false;
		}
		if (siteNumber3 == '') {
			ok = false;
		}
		if (siteNumber4 == '') {
			ok = false;
		}
		if (siteNumber5 == '') {
			ok = false;
		}
		if (siteNumber6 == '') {
			ok = false;
		}
		if (ok) {
			$.ajax({
				type : "POST",
				url : global.context + '/admin/menudata/save',
				data : {
					"market" : market,
					"browseTime" : browseTime,
					"siteName" : siteName,
					"siteNumber" : siteNumber
				},
				dataType : "text",
				async : false,
				success : function(result) {

				}
			});
			$.ajax({
				type : "POST",
				url : global.context + '/admin/menudata/save1',
				data : {
					"market" : market,
					"browseTime" : browseTime,
					"siteName1" : siteName1,
					"siteNumber1" : siteNumber1
				},
				dataType : "text",
				async : false,
				success : function(result) {

				}
			});
			$.ajax({
				type : "POST",
				url : global.context + '/admin/menudata/save2',
				data : {
					"market" : market,
					"browseTime" : browseTime,
					"siteName2" : siteName2,
					"siteNumber2" : siteNumber2
				},
				dataType : "text",
				async : false,
				success : function(result) {

				}
			});
			$.ajax({
				type : "POST",
				url : global.context + '/admin/menudata/save3',
				data : {
					"market" : market,
					"browseTime" : browseTime,
					"siteName3" : siteName3,
					"siteNumber3" : siteNumber3
				},
				dataType : "text",
				async : false,
				success : function(result) {

				}
			});
			$.ajax({
				type : "POST",
				url : global.context + '/admin/menudata/save4',
				data : {
					"market" : market,
					"browseTime" : browseTime,
					"siteName4" : siteName4,
					"siteNumber4" : siteNumber4
				},
				dataType : "text",
				async : false,
				success : function(result) {

				}
			});
			$.ajax({
				type : "POST",
				url : global.context + '/admin/menudata/save5',
				data : {
					"market" : market,
					"browseTime" : browseTime,
					"siteName5" : siteName5,
					"siteNumber5" : siteNumber5
				},
				dataType : "text",
				async : false,
				success : function(result) {

				}
			});
			$.ajax({
				type : "POST",
				url : global.context + '/admin/menudata/save6',
				data : {
					"market" : market,
					"browseTime" : browseTime,
					"siteName6" : siteName6,
					"siteNumber6" : siteNumber6
				},
				dataType : "text",
				async : false,
				success : function(result) {

				}
			});
			window.wxc.xcConfirm("录入成功！", window.wxc.xcConfirm.typeEnum.info);
			var newbrowseTime = Date.parse(browseTime);
			newbrowseTime = new Date(newbrowseTime);
			newbrowseTime = newbrowseTime.setDate(newbrowseTime
					.getDate() + 1);
			newbrowseTime = new Date(newbrowseTime);
			$("#browseTime1_id").val(
					newbrowseTime.Format("yyyy-MM-dd"));
			$("#siteNumber_id").val('');
			$("#siteNumber1_id").val('');
			$("#siteNumber2_id").val('');
			$("#siteNumber3_id").val('');
			$("#siteNumber4_id").val('');
			$("#siteNumber5_id").val('');
			$("#siteNumber6_id").val('');

		} else {
			window.wxc.xcConfirm("录入失败！", window.wxc.xcConfirm.typeEnum.info);
		}
	});
	Date.prototype.Format = function(fmt) {
		var o = {
			"M+" : this.getMonth() + 1, //月份
			"d+" : this.getDate(), //日
			"h+" : this.getHours(), //小时
			"m+" : this.getMinutes(), //分
			"s+" : this.getSeconds(), //秒
			"q+" : Math.floor((this.getMonth() + 3) / 3), //季度
			"S" : this.getMilliseconds()
		//毫秒
		};
		if (/(y+)/.test(fmt))
			fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		for ( var k in o)
			if (new RegExp("(" + k + ")").test(fmt))
				fmt = fmt.replace(RegExp.$1,
						(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
								.substr(("" + o[k]).length)));
		return fmt;
	}
});