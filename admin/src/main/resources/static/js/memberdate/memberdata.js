$(function() {
	$('#tol_submit').click(function() {
		var market = $("#market_id").find("option:selected").val();
		var browseTime1 = $("#browseTime1_id").val();
		var browseTime2 = $("#browseTime2_id").val();
		var browseTime3 = $("#browseTime3_id").val();
		var browseTime4 = $("#browseTime4_id").val();
		var browseTime5 = $("#browseTime5_id").val();
		var browseTime6 = $("#browseTime6_id").val();
		var browseTime7 = $("#browseTime7_id").val();
		var fanNumber1 = $("#fanNumber1_id").val();
		var fanNumber2 = $("#fanNumber2_id").val();
		var fanNumber3 = $("#fanNumber3_id").val();
		var fanNumber4 = $("#fanNumber4_id").val();
		var fanNumber5 = $("#fanNumber5_id").val();
		var fanNumber6 = $("#fanNumber6_id").val();
		var fanNumber7 = $("#fanNumber7_id").val();
		var fansNumber1 = $("#fansNumber1_id").val();
		var fansNumber2 = $("#fansNumber2_id").val();
		var fansNumber3 = $("#fansNumber3_id").val();
		var fansNumber4 = $("#fansNumber4_id").val();
		var fansNumber5 = $("#fansNumber5_id").val();
		var fansNumber6 = $("#fansNumber6_id").val();
		var fansNumber7 = $("#fansNumber7_id").val();
		var ok = true;
		if (market == '') {
			ok = false;
		}
		if (browseTime1 == '') {
			ok = false;
		}
		if (browseTime2 == '') {
			ok = false;
		}
		if (browseTime3 == '') {
			ok = false;
		}
		if (browseTime4 == '') {
			ok = false;
		}
		if (browseTime5 == '') {
			ok = false;
		}
		if (browseTime6 == '') {
			ok = false;
		}
		if (browseTime7 == '') {
			ok = false;
		}
		if (fanNumber1 == '') {
			ok = false;
		}
		if (fanNumber2 == '') {
			ok = false;
		}
		if (fanNumber3 == '') {
			ok = false;
		}
		if (fanNumber4 == '') {
			ok = false;
		}
		if (fanNumber5 == '') {
			ok = false;
		}
		if (fanNumber6 == '') {
			ok = false;
		}
		if (fanNumber7 == '') {
			ok = false;
		}
		if (fansNumber1 == '') {
			ok = false;
		}
		if (fansNumber2 == '') {
			ok = false;
		}
		if (fansNumber3 == '') {
			ok = false;
		}
		if (fansNumber4 == '') {
			ok = false;
		}
		if (fansNumber5 == '') {
			ok = false;
		}
		if (fansNumber6 == '') {
			ok = false;
		}
		if (fansNumber7 == '') {
			ok = false;
		}
		if (ok) {
			$.ajax({
				type : "POST",
				url : global.context + '/admin/memberData/save',
				data : {
					"market" : market,
					"browseTime1" : browseTime1,
					"fanNumber1" : fanNumber1,
					"fansNumber1" : fansNumber1
				},
				dataType : "json",
				success : function(result) {

				}
			});
			$.ajax({
				type : "POST",
				url : global.context + '/admin/memberData/save1',
				data : {
					"market" : market,
					"browseTime2" : browseTime2,
					"fanNumber2" : fanNumber2,
					"fansNumber2" : fansNumber2
				},
				dataType : "json",
				success : function(result) {

				}
			});
			$.ajax({
				type : "POST",
				url : global.context + '/admin/memberData/save2',
				data : {
					"market" : market,
					"browseTime3" : browseTime3,
					"fanNumber3" : fanNumber3,
					"fansNumber3" : fansNumber3
				},
				dataType : "json",
				success : function(result) {

				}
			});
			$.ajax({
				type : "POST",
				url : global.context + '/admin/memberData/save3',
				data : {
					"market" : market,
					"browseTime4" : browseTime4,
					"fanNumber4" : fanNumber4,
					"fansNumber4" : fansNumber4
				},
				dataType : "json",
				success : function(result) {

				}
			});
			$.ajax({
				type : "POST",
				url : global.context + '/admin/memberData/save4',
				data : {
					"market" : market,
					"browseTime5" : browseTime5,
					"fanNumber5" : fanNumber5,
					"fansNumber5" : fansNumber5
				},
				dataType : "json",
				success : function(result) {

				}
			});
			$.ajax({
				type : "POST",
				url : global.context + '/admin/memberData/save5',
				data : {
					"market" : market,
					"browseTime6" : browseTime6,
					"fanNumber6" : fanNumber6,
					"fansNumber6" : fansNumber6
				},
				dataType : "json",
				success : function(result) {

				}
			});
			$.ajax({
				type : "POST",
				url : global.context + '/admin/memberData/save6',
				data : {
					"market" : market,
					"browseTime7" : browseTime7,
					"fanNumber7" : fanNumber7,
					"fansNumber7" : fansNumber7
				},
				dataType : "json",
				success : function(result) {

				}
			});
			window.wxc.xcConfirm("录入成功！", window.wxc.xcConfirm.typeEnum.info);
			var date = $("#browseTime7_id").val();
			for (var i = 1; i < 8; i++) {
				newdate = Date.parse(date);
				newdate = new Date(newdate);
				newdate = newdate.setDate(newdate.getDate() + i);
				newdate = new Date(newdate);
				$('#browseTime' + i + '_id').val(newdate.Format("yyyy-MM-dd"));
			}
			$("#fanNumber1_id").val('');
			$("#fanNumber2_id").val('');
			$("#fanNumber3_id").val('');
			$("#fanNumber4_id").val('');
			$("#fanNumber5_id").val('');
			$("#fanNumber6_id").val('');
			$("#fanNumber7_id").val('');
			$("#fansNumber1_id").val('');
			$("#fansNumber2_id").val('');
			$("#fansNumber3_id").val('');
			$("#fansNumber4_id").val('');
			$("#fansNumber5_id").val('');
			$("#fansNumber6_id").val('');
			$("#fansNumber7_id").val('');
		} else {
			window.wxc.xcConfirm("录入失败！", window.wxc.xcConfirm.typeEnum.info);
		}
	});
	$("#browseTime1_id").change(function() {
		for (var i = 1; i < 7; i++) {
			var dt = $('#browseTime' + i + '_id').val();
			dt = Date.parse(dt);
			dt = new Date(dt);
			dt = dt.setDate(dt.getDate() + 1);
			dt = new Date(dt);
			$('#browseTime' + (i + 1) + '_id').val(dt.Format("yyyy-MM-dd"));
		}
	});
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
});