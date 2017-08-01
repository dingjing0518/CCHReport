$(function() {
	$('#browseTime1_id').datepicker({
		dateFormat : 'yy-mm-dd'
	});
	$('#browseTime2_id').datepicker({
		dateFormat : 'yy-mm-dd'
	});
	$('#browseTime3_id').datepicker({
		dateFormat : 'yy-mm-dd'
	});
	$('#browseTime4_id').datepicker({
		dateFormat : 'yy-mm-dd'
	});
	$('#browseTime5_id').datepicker({
		dateFormat : 'yy-mm-dd'
	});
	$('#browseTime6_id').datepicker({
		dateFormat : 'yy-mm-dd'
	});
	$('#browseTime7_id').datepicker({
		dateFormat : 'yy-mm-dd'
	});
	$('#form0').validate({
		onkeyup : false,
		rules : {
			market:{
				required : true
			},
			siteName : {
				required : true
			},
			siteNumber : {
				required : true
			},
			browseTime : {
				dateISO : true,
				required :true
			}
		},
		messages : {
			market:{
				required : "商场名称不能为空"
			},
			siteName : {
				required : '网页名称不能为空'
			},
			siteNumber : {
				required : '网页点击数不能为空'
			},
			browseTime : {
				dateISO : '请输入正确的日期格式yyyy-mm-dd',
				required : '请输入日期'
			}
		}
	});
	$('#form1').validate({
		onkeyup : false,
		rules : {
			market:{
				required : true
			},
			siteName : {
				required : true
			},
			siteNumber : {
				required : true
			},
			browseTime : {
				dateISO : true,
				required :true
			}
		},
		messages : {
			market:{
				required : "商场名称不能为空"
			},
			siteName : {
				required : '网页名称不能为空'
			},
			siteNumber : {
				required : '网页点击数不能为空'
			},
			browseTime : {
				dateISO : '请输入正确的日期格式yyyy-mm-dd',
				required : '请输入日期'
			}
		}
	});
	$('#form2').validate({
		onkeyup : false,
		rules : {
			market:{
				required : true
			},
			siteName : {
				required : true
			},
			siteNumber : {
				required : true
			},
			browseTime : {
				dateISO : true,
				required :true
			}
		},
		messages : {
			market:{
				required : "商场名称不能为空"
			},
			siteName : {
				required : '网页名称不能为空'
			},
			siteNumber : {
				required : '网页点击数不能为空'
			},
			browseTime : {
				dateISO : '请输入正确的日期格式yyyy-mm-dd',
				required : '请输入日期'
			}
		}
	});
	$('#form3').validate({
		onkeyup : false,
		rules : {
			market:{
				required : true
			},
			siteName : {
				required : true
			},
			siteNumber : {
				required : true
			},
			browseTime : {
				dateISO : true,
				required :true
			}
		},
		messages : {
			market:{
				required : "商场名称不能为空"
			},
			siteName : {
				required : '网页名称不能为空'
			},
			siteNumber : {
				required : '网页点击数不能为空'
			},
			browseTime : {
				dateISO : '请输入正确的日期格式yyyy-mm-dd',
				required : '请输入日期'
			}
		}
	});
	$('#form4').validate({
		onkeyup : false,
		rules : {
			market:{
				required : true
			},
			siteName : {
				required : true
			},
			siteNumber : {
				required : true
			},
			browseTime : {
				dateISO : true,
				required :true
			}
		},
		messages : {
			market:{
				required : "商场名称不能为空"
			},
			siteName : {
				required : '网页名称不能为空'
			},
			siteNumber : {
				required : '网页点击数不能为空'
			},
			browseTime : {
				dateISO : '请输入正确的日期格式yyyy-mm-dd',
				required : '请输入日期'
			}
		}
	});
});