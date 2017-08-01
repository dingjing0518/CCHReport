package com.by.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.by.form.ReportForm;
import com.by.json.PieReportJson;
import com.by.json.ReportJson;
import com.by.service.FanDataReportService;
import com.by.service.MemberDataReportService;
import com.by.service.MenuDataReportService;
import com.by.service.WebsiteDataReportService;

@Controller
public class ReportController {
	private final String REPORT_INDEX = "report/index";
	private final String WEBSITE_REPORT = "website/report";
	private final String MEMBERDATE_REPORT = "memberdata/report";
	private final String FANDATA_REPORT = "fandata/report";
	private final String FANDATA_SOURCE_REPORT = "fandatasource/report";
	private final String MENUDATA_REPORT = "menudata/report";
	private final String SUMMARY_REPORT = "summary/report";
	@Autowired
	private WebsiteDataReportService websiteDataReportService;
	@Autowired
	private MemberDataReportService memberDataReportService;
	@Autowired
	private FanDataReportService fanDataReportService;
	@Autowired
	private MenuDataReportService menuDataReportService;

	@ModelAttribute("years")
	public List<Integer> categories() {
		return websiteDataReportService.findAllValidYear();
	}

	@ModelAttribute("months")
	public List<ReportForm> months() {
		List<ReportForm> monthList = new ArrayList<ReportForm>();

		ReportForm month1 = new ReportForm("一", 1);
		ReportForm month2 = new ReportForm("二", 2);
		ReportForm month3 = new ReportForm("三", 3);
		ReportForm month4 = new ReportForm("四", 4);
		ReportForm month5 = new ReportForm("五", 5);
		ReportForm month6 = new ReportForm("六", 6);
		ReportForm month7 = new ReportForm("七", 7);
		ReportForm month8 = new ReportForm("八", 8);
		ReportForm month9 = new ReportForm("九", 9);
		ReportForm month10 = new ReportForm("十", 10);
		ReportForm month11 = new ReportForm("十一", 11);
		ReportForm month12 = new ReportForm("十二", 12);

		monthList.add(month1);
		monthList.add(month2);
		monthList.add(month3);
		monthList.add(month4);
		monthList.add(month5);
		monthList.add(month6);
		monthList.add(month7);
		monthList.add(month8);
		monthList.add(month9);
		monthList.add(month10);
		monthList.add(month11);
		monthList.add(month12);

		return monthList;
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String report() {
		return REPORT_INDEX;
	}

	// 汇总数据
	@RequestMapping(value = "/summaryReport", method = RequestMethod.GET)
	public String summaryReport() {
		return SUMMARY_REPORT;
	}

	@RequestMapping(value = "/summaryReport/data", method = RequestMethod.GET)
	@ResponseBody
	public ReportJson summaryReport(@RequestParam(value = "year", required = false) Integer year,
			@RequestParam(value = "month", required = false) Integer month) {
		ReportJson json = new ReportJson();
		if (year > 0 && month == -1) {
			// 粉丝数据data[2]
			List<Object[]> lists = fanDataReportService.findByYear(year);
			// 会员数据data[2]
			List<Object[]> lists1 = memberDataReportService.findByYear(year);

			String[] xDig = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
			// 粉丝数据
			String[] y = { "", "", "", "", "", "", "", "", "", "", "", "" };
			// 会员数据
			String[] y1 = { "", "", "", "", "", "", "", "", "", "", "", "" };
			Object[] data = null;
			// 粉丝数据
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < lists.size(); j++) {
					data = lists.get(j);
					if ((Integer) (data[0]) == (i + 1)) {
						y[i] = String.valueOf(data[2]);
						break;
					}
				}
			}
			// 会员数据
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < lists.size(); j++) {
					data = lists1.get(j);
					if ((Integer) (data[0]) == (i + 1)) {
						y1[i] = String.valueOf(data[2]);
						break;
					}
				}
			}
			ReportJson.Tooltip tooltip = json.new Tooltip();
			tooltip.setTrigger("axis");
			json.setTooltip(tooltip);

			ReportJson.Legend legend = json.new Legend();
			legend.setX("center");
			legend.setY("89%");
			legend.setItemGap(2);
			legend.setData(new String[] { "粉丝数据", "会员数据" });
			legend.setShow("true");
			legend.setOrient("horizontal");
			legend.setShow("true");
			json.setLegend(legend);

			ReportJson.Grid grid = json.new Grid();
			grid.setLeft("5%");
			grid.setContainLabel("true");
			json.setGrid(grid);

			ReportJson.XAxis xAxis = json.new XAxis();
			xAxis.setType("category");
			xAxis.setShow("true");
			xAxis.setName("月");
			xAxis.setData(xDig);
			json.setxAxis(xAxis);

			ReportJson.YAxis yAxis1 = json.new YAxis();
			yAxis1.setType("value");
			yAxis1.setName("总数");
			ReportJson.YAxis[] yAxisArray = new ReportJson.YAxis[1];
			yAxisArray[0] = yAxis1;
			json.setyAxis(yAxisArray);

			ReportJson.Series series = json.new Series();
			series.setName("粉丝数据");
			series.setType("line");
			series.setData(y);

			ReportJson.Series series1 = json.new Series();
			series1.setName("会员数据");
			series1.setType("line");
			series1.setData(y1);

			ReportJson.Series[] seriesArray = new ReportJson.Series[2];
			seriesArray[0] = series;
			seriesArray[1] = series1;
			json.setSeries(seriesArray);

			return json;
		} else if (year > 0 && month > 0) {
			int dateOfMonth = CalendarUtil.getDaysByYearMonth(year, month);
			String[] x = new String[dateOfMonth];
			String[] y = new String[dateOfMonth];
			String[] y1 = new String[dateOfMonth];
			List<Object[]> lists = fanDataReportService.findByMonthAndDay(year, month);
			List<Object[]> lists1 = memberDataReportService.findByMonthAndDay(year, month);
			for (int i = 0; i < dateOfMonth; i++) {
				x[i] = String.valueOf(i + 1);
				y[i] = "";
				y1[i] = "";
			}
			Object[] data = null;
			for (int i = 0; i < dateOfMonth; i++) {
				for (int j = 0; j < lists.size(); j++) {
					data = lists.get(j);
					if ((Integer) data[0] == (i + 1)) {
						y[i] = String.valueOf(data[2]);
						break;
					}
				}
			}
			for (int i = 0; i < dateOfMonth; i++) {
				for (int j = 0; j < lists1.size(); j++) {
					data = lists1.get(j);
					if ((Integer) data[0] == (i + 1)) {
						y1[i] = String.valueOf(data[2]);
						break;
					}
				}
			}
			ReportJson.Tooltip tooltip = json.new Tooltip();
			tooltip.setTrigger("axis");
			json.setTooltip(tooltip);

			ReportJson.Legend legend = json.new Legend();
			legend.setX("center");
			legend.setY("89%");
			legend.setItemGap(2);
			legend.setData(new String[] { "粉丝数据", "会员数据" });
			legend.setShow("true");
			legend.setOrient("horizontal");
			json.setLegend(legend);

			ReportJson.Grid grid = json.new Grid();
			grid.setLeft("5%");
			grid.setContainLabel("true");
			json.setGrid(grid);

			ReportJson.XAxis xAxis = json.new XAxis();
			xAxis.setType("category");
			xAxis.setShow("true");
			xAxis.setName("日");
			xAxis.setData(x);
			json.setxAxis(xAxis);

			ReportJson.YAxis yAxis1 = json.new YAxis();
			yAxis1.setType("value");
			yAxis1.setName("总数");
			ReportJson.YAxis[] yAxisArray = new ReportJson.YAxis[1];
			yAxisArray[0] = yAxis1;
			json.setyAxis(yAxisArray);

			ReportJson.Series series = json.new Series();
			series.setName("粉丝数据");
			series.setType("line");
			series.setData(y);

			ReportJson.Series series1 = json.new Series();
			series1.setName("会员数据");
			series1.setType("line");
			series1.setData(y1);

			ReportJson.Series[] seriesArray = new ReportJson.Series[2];
			seriesArray[0] = series;
			seriesArray[1] = series1;
			json.setSeries(seriesArray);
			return json;
		}
		return null;
	}

	// 自定义菜单数据
	@RequestMapping(value = "/menudataReport", method = RequestMethod.GET)
	public String menudataReport() {
		return MENUDATA_REPORT;
	}

	@RequestMapping(value = "/menudataReport/data", method = RequestMethod.GET)
	@ResponseBody
	public PieReportJson menudataReport(@RequestParam(value = "startTime", required = false) String startTime,
			@RequestParam(value = "endTime", required = false) String endTime) {
		PieReportJson json = new PieReportJson();
		PieReportJson.Tooltip tooltip = json.new Tooltip();
		tooltip.setTrigger("item");
		tooltip.setFormatter("{a} <br/>{b} : {c} ({d}%)");
		json.setTooltip(tooltip);

		PieReportJson.Legend legend = json.new Legend();
		legend.setItemGap(7);
		legend.setData(new String[] { "如何到达", "品牌索引", "最新活动", "我的会员卡", "积分兑换", "停车缴费", "我的券库" });
		legend.setShow("true");
		legend.setOrient("horizontal");
		json.setLegend(legend);

		PieReportJson.Series series = json.new Series();
		series.setName(""
				+ ""
				+ "来源");
		series.setType("pie");
		series.setRadius("50%");
		series.setCenter(new String[] { "50%", "60%" });

		PieReportJson.PieData pieData0 = json.new PieData();
		pieData0.setName("如何到达");
		pieData0.setValue(menuDataReportService.findByMemu0(startTime, endTime) == null ? "0"
				: menuDataReportService.findByMemu0(startTime, endTime));

		PieReportJson.PieData pieData1 = json.new PieData();
		pieData1.setName("品牌索引");
		pieData1.setValue(menuDataReportService.findByMemu1(startTime, endTime) == null ? "0"
				: menuDataReportService.findByMemu1(startTime, endTime));

		PieReportJson.PieData pieData2 = json.new PieData();
		pieData2.setName("最新活动");
		pieData2.setValue(menuDataReportService.findByMemu2(startTime, endTime) == null ? "0"
				: menuDataReportService.findByMemu2(startTime, endTime));

		PieReportJson.PieData pieData3 = json.new PieData();
		pieData3.setName("我的会员卡");
		pieData3.setValue(menuDataReportService.findByMemu3(startTime, endTime) == null ? "0"
				: menuDataReportService.findByMemu3(startTime, endTime));

		PieReportJson.PieData pieData4 = json.new PieData();
		pieData4.setName("积分兑换");
		pieData4.setValue(menuDataReportService.findByMemu4(startTime, endTime) == null ? "0"
				: menuDataReportService.findByMemu4(startTime, endTime));

		PieReportJson.PieData pieData5 = json.new PieData();
		pieData5.setName("停车缴费");
		pieData5.setValue(menuDataReportService.findByMemu5(startTime, endTime) == null ? "0"
				: menuDataReportService.findByMemu5(startTime, endTime));

		PieReportJson.PieData pieData6 = json.new PieData();
		pieData6.setName("我的券库");
		pieData6.setValue(menuDataReportService.findByMemu6(startTime, endTime) == null ? "0"
				: menuDataReportService.findByMemu6(startTime, endTime));
		PieReportJson.PieData[] pieDataArray = new PieReportJson.PieData[7];
		pieDataArray[0] = pieData0;
		pieDataArray[1] = pieData1;
		pieDataArray[2] = pieData2;
		pieDataArray[3] = pieData3;
		pieDataArray[4] = pieData4;
		pieDataArray[5] = pieData5;
		pieDataArray[6] = pieData6;
		series.setData(pieDataArray);
		PieReportJson.Emphasis emphasis = json.new Emphasis();
		emphasis.setShadowBlur("10");
		emphasis.setShadowOffsetX("0");
		emphasis.setShadowColor("rgba(0, 0, 0, 0.5)");
		PieReportJson.ItemStyle itemStyle = json.new ItemStyle();
		itemStyle.setEmphasis(emphasis);
		series.setItemStyle(itemStyle);
		PieReportJson.Series[] seriesArray = new PieReportJson.Series[1];
		seriesArray[0] = series;
		json.setSeries(seriesArray);

		return json;
	}

	// 粉丝来源
	@RequestMapping(value = "/fandataSourceReport", method = RequestMethod.GET)
	public String fandataSourceReport() {
		return FANDATA_SOURCE_REPORT;
	}

	@RequestMapping(value = "/fandataSourceReport/data", method = RequestMethod.GET)
	@ResponseBody
	public ReportJson fandataSourceReport(@RequestParam(value = "year", required = false) Integer year,
			@RequestParam(value = "month", required = false) Integer month) {
		ReportJson json = new ReportJson();
		if (year > 0 && month == -1) {
			List<Object[]> lists = fanDataReportService.findByYear1(year);
			String[] xDig = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
			// wifi粉丝
			String[] y = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
			// 其它来源
			String[] y1 = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
			Object[] data = null;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < lists.size(); j++) {
					data = lists.get(j);
					if ((Integer) (data[0]) == (i + 1)) {
						y[i] = String.valueOf(data[1]);
						y1[i] = String.valueOf(data[2]);
						break;
					}
				}
			}
			ReportJson.Tooltip tooltip = json.new Tooltip();
			tooltip.setTrigger("axis");
			json.setTooltip(tooltip);

			ReportJson.Legend legend = json.new Legend();
			legend.setX("center");
			legend.setY("89%");
			legend.setItemGap(2);
			legend.setData(new String[] { "其他来源", "Wi-Fi粉丝" });
			legend.setShow("true");
			legend.setOrient("horizontal");
			json.setLegend(legend);

			ReportJson.Grid grid = json.new Grid();
			grid.setLeft("5%");
			grid.setContainLabel("true");
			json.setGrid(grid);

			ReportJson.XAxis xAxis = json.new XAxis();
			xAxis.setType("category");
			xAxis.setShow("true");
			xAxis.setName("月");
			xAxis.setData(xDig);
			json.setxAxis(xAxis);

			ReportJson.YAxis yAxis1 = json.new YAxis();
			yAxis1.setType("value");
			yAxis1.setName("粉丝总数");
			ReportJson.YAxis[] yAxisArray = new ReportJson.YAxis[1];
			yAxisArray[0] = yAxis1;
			json.setyAxis(yAxisArray);

			ReportJson.Series series = json.new Series();
			series.setName("其他来源");
			series.setStack("总量");
			series.setType("bar");
			series.setData(y1);

			ReportJson.Series series1 = json.new Series();
			series1.setName("Wi-Fi粉丝");
			series1.setStack("总量");
			series1.setType("bar");
			series1.setData(y);
			ReportJson.Series[] seriesArray = new ReportJson.Series[2];
			seriesArray[0] = series;
			seriesArray[1] = series1;
			json.setSeries(seriesArray);
			return json;
		} else if (year > 0 && month > 0) {
			int dateOfMonth = CalendarUtil.getDaysByYearMonth(year, month);
			String[] x = new String[dateOfMonth];
			String[] y = new String[dateOfMonth];
			String[] y1 = new String[dateOfMonth];
			List<Object[]> lists = fanDataReportService.findByMonthAndDay1(year, month);
			for (int i = 0; i < dateOfMonth; i++) {
				x[i] = String.valueOf(i + 1);
				y[i] = "0";
				y1[i] = "0";
			}
			Object[] data = null;
			for (int i = 0; i < dateOfMonth; i++) {
				for (int j = 0; j < lists.size(); j++) {
					data = lists.get(j);
					if ((Integer) (data[0]) == (i + 1)) {
						y[i] = String.valueOf(data[1]);
						y1[i] = String.valueOf(data[2]);
						break;
					}
				}
			}
			ReportJson.Tooltip tooltip = json.new Tooltip();
			tooltip.setTrigger("axis");
			json.setTooltip(tooltip);

			ReportJson.Legend legend = json.new Legend();
			legend.setX("center");
			legend.setY("89%");
			legend.setItemGap(2);
			legend.setData(new String[] { "其他来源", "Wi-Fi粉丝" });
			legend.setShow("true");
			legend.setOrient("horizontal");
			json.setLegend(legend);

			ReportJson.Grid grid = json.new Grid();
			grid.setLeft("5%");
			grid.setContainLabel("true");
			json.setGrid(grid);

			ReportJson.XAxis xAxis = json.new XAxis();
			xAxis.setType("category");
			xAxis.setName("日");
			xAxis.setShow("true");
			xAxis.setData(x);
			json.setxAxis(xAxis);

			ReportJson.YAxis yAxis1 = json.new YAxis();
			yAxis1.setType("value");
			yAxis1.setName("粉丝总数");
			ReportJson.YAxis[] yAxisArray = new ReportJson.YAxis[1];
			yAxisArray[0] = yAxis1;
			json.setyAxis(yAxisArray);

			ReportJson.Series series = json.new Series();
			series.setName("其他来源");
			series.setStack("总量");
			series.setType("bar");
			series.setData(y1);

			ReportJson.Series series1 = json.new Series();
			series1.setName("Wi-Fi粉丝");
			series1.setStack("总量");
			series1.setType("bar");
			series1.setData(y);
			ReportJson.Series[] seriesArray = new ReportJson.Series[2];
			seriesArray[0] = series;
			seriesArray[1] = series1;
			json.setSeries(seriesArray);
			return json;
		}
		return null;

	}

	// 粉丝数据
	@RequestMapping(value = "/fandataReport", method = RequestMethod.GET)
	public String fandataReport() {
		return FANDATA_REPORT;
	}

	@RequestMapping(value = "/fandataReport/data", method = RequestMethod.GET)
	@ResponseBody
	public ReportJson fandataReport(@RequestParam(value = "year", required = false) Integer year,
			@RequestParam(value = "month", required = false) Integer month) {
		ReportJson json = new ReportJson();
		if (year > 0 && month == -1) {
			List<Object[]> lists = fanDataReportService.findByYear(year);
			String[] xDig = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
			// 粉丝增长数
			String[] y = { "", "", "", "", "", "", "", "", "", "", "", "" };
			// 粉丝总数
			String[] y1 = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
			Object[] data = null;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < lists.size(); j++) {
					data = lists.get(j);
					if ((Integer) (data[0]) == (i + 1)) {
						y[i] = String.valueOf(data[1]);
						y1[i] = String.valueOf(data[2]);
						break;
					}
				}
			}

			ReportJson.Tooltip tooltip = json.new Tooltip();
			tooltip.setTrigger("axis");
			json.setTooltip(tooltip);

			ReportJson.Legend legend = json.new Legend();
			legend.setX("center");
			legend.setY("89%");
			legend.setItemGap(2);
			legend.setData(new String[] { "当前粉丝", "新增粉丝" });
			legend.setShow("true");
			legend.setOrient("horizontal");
			json.setLegend(legend);

			ReportJson.Grid grid = json.new Grid();
			grid.setLeft("5%");
			grid.setContainLabel("true");
			json.setGrid(grid);

			ReportJson.XAxis xAxis = json.new XAxis();
			xAxis.setType("category");
			xAxis.setShow("true");
			xAxis.setName("日");
			xAxis.setData(xDig);
			json.setxAxis(xAxis);

			ReportJson.YAxis yAxis = json.new YAxis();
			yAxis.setType("value");
			yAxis.setName("粉丝总数");

			ReportJson.YAxis yAxis1 = json.new YAxis();
			yAxis1.setType("value");
			yAxis1.setName("粉丝增长数");
			ReportJson.YAxis[] yAxisArray = new ReportJson.YAxis[2];
			yAxisArray[0] = yAxis;
			yAxisArray[1] = yAxis1;
			json.setyAxis(yAxisArray);

			ReportJson.Series series = json.new Series();
			series.setName("当前粉丝");
			series.setType("bar");
			series.setData(y1);

			ReportJson.Series series1 = json.new Series();
			series1.setName("新增粉丝");
			series1.setType("line");
			series1.setyAxisIndex("1");
			series1.setData(y);
			ReportJson.Series[] seriesArray = new ReportJson.Series[2];
			seriesArray[0] = series;
			seriesArray[1] = series1;
			json.setSeries(seriesArray);
			return json;
		} else if (year > 0 && month > 0) {
			int dateOfMonth = CalendarUtil.getDaysByYearMonth(year, month);
			String[] x = new String[dateOfMonth];
			String[] y = new String[dateOfMonth];
			String[] y1 = new String[dateOfMonth];
			List<Object[]> lists = fanDataReportService.findByMonthAndDay(year, month);
			for (int i = 0; i < dateOfMonth; i++) {
				x[i] = String.valueOf(i + 1);
				y[i] = "";
				y1[i] = "0";
			}
			Object[] data = null;
			for (int i = 0; i < dateOfMonth; i++) {
				for (int j = 0; j < lists.size(); j++) {
					data = lists.get(j);
					if ((Integer) data[0] == (i + 1)) {
						// 粉丝增长数
						y[i] = String.valueOf(data[1]);
						y1[i] = String.valueOf(data[2]);
						break;
					}
				}
			}
			ReportJson.Tooltip tooltip = json.new Tooltip();
			tooltip.setTrigger("axis");
			json.setTooltip(tooltip);

			ReportJson.Legend legend = json.new Legend();
			legend.setX("center");
			legend.setY("89%");
			legend.setItemGap(2);
			legend.setData(new String[] { "当前粉丝", "新增粉丝" });
			legend.setShow("true");
			legend.setOrient("horizontal");
			json.setLegend(legend);

			ReportJson.Grid grid = json.new Grid();
			grid.setLeft("5%");
			grid.setContainLabel("true");
			json.setGrid(grid);

			ReportJson.XAxis xAxis = json.new XAxis();
			xAxis.setType("category");
			xAxis.setShow("true");
			xAxis.setName("日");
			xAxis.setData(x);
			json.setxAxis(xAxis);

			ReportJson.YAxis yAxis = json.new YAxis();
			yAxis.setType("value");
			yAxis.setName("粉丝总数");

			ReportJson.YAxis yAxis1 = json.new YAxis();
			yAxis1.setType("value");
			yAxis1.setName("粉丝增长数");
			ReportJson.YAxis[] yAxisArray = new ReportJson.YAxis[2];
			yAxisArray[0] = yAxis;
			yAxisArray[1] = yAxis1;
			json.setyAxis(yAxisArray);

			ReportJson.Series series = json.new Series();
			series.setName("当前粉丝");
			series.setType("bar");
			series.setData(y1);

			ReportJson.Series series1 = json.new Series();
			series1.setName("新增粉丝");
			series1.setType("line");
			series1.setyAxisIndex("1");
			series1.setData(y);
			ReportJson.Series[] seriesArray = new ReportJson.Series[2];
			seriesArray[0] = series;
			seriesArray[1] = series1;
			json.setSeries(seriesArray);
			return json;
		}
		return null;

	}

	// 会员数据
	@RequestMapping(value = "/memberdataReport", method = RequestMethod.GET)
	public String memberdataReport() {
		return MEMBERDATE_REPORT;
	}

	@RequestMapping(value = "/memberdataReport/data", method = RequestMethod.GET)
	@ResponseBody
	public ReportJson memberdataReport(@RequestParam(value = "year", required = false) Integer year,
			@RequestParam(value = "month", required = false) Integer month) {
		ReportJson json = new ReportJson();
		if (year > 0 && month == -1) {
			List<Object[]> lists = memberDataReportService.findByYear(year);
			String[] xDig = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
			// 会员增长数
			String[] y = { "", "", "", "", "", "", "", "", "", "", "", "" };
			// 会员总数
			String[] y1 = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
			Object[] data = null;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < lists.size(); j++) {
					data = lists.get(j);
					if ((Integer) (data[0]) == (i + 1)) {
						y[i] = String.valueOf(data[1]);
						y1[i] = String.valueOf(data[2]);
					}
				}
			}

			ReportJson.Tooltip tooltip = json.new Tooltip();
			tooltip.setTrigger("axis");
			json.setTooltip(tooltip);

			ReportJson.Legend legend = json.new Legend();
			legend.setX("center");
			legend.setY("89%");
			legend.setItemGap(2);
			legend.setData(new String[] { "当前会员", "新增会员" });
			legend.setShow("true");
			legend.setOrient("horizontal");
			json.setLegend(legend);

			ReportJson.Grid grid = json.new Grid();
			grid.setLeft("5%");
			grid.setContainLabel("true");
			json.setGrid(grid);

			ReportJson.XAxis xAxis = json.new XAxis();
			xAxis.setType("category");
			xAxis.setShow("true");
			xAxis.setShow("true");
			xAxis.setName("月");
			xAxis.setData(xDig);

			json.setxAxis(xAxis);

			ReportJson.YAxis yAxis = json.new YAxis();
			yAxis.setType("value");
			yAxis.setName("会员总数");

			ReportJson.YAxis yAxis1 = json.new YAxis();
			yAxis1.setType("value");
			yAxis1.setName("会员增长数");
			ReportJson.YAxis[] yAxisArray = new ReportJson.YAxis[2];
			yAxisArray[0] = yAxis;
			yAxisArray[1] = yAxis1;
			json.setyAxis(yAxisArray);

			ReportJson.Series series = json.new Series();
			series.setName("当前会员");
			series.setType("bar");
			series.setData(y1);

			ReportJson.Series series1 = json.new Series();
			series1.setName("新增会员");
			series1.setType("line");
			series1.setyAxisIndex("1");
			series1.setData(y);
			ReportJson.Series[] seriesArray = new ReportJson.Series[2];
			seriesArray[0] = series;
			seriesArray[1] = series1;
			json.setSeries(seriesArray);
			return json;
		} else if (year > 0 && month > 0) {
			int dateOfMonth = CalendarUtil.getDaysByYearMonth(year, month);
			String[] x = new String[dateOfMonth];
			String[] y = new String[dateOfMonth];
			String[] y1 = new String[dateOfMonth];
			List<Object[]> lists = memberDataReportService.findByMonthAndDay(year, month);
			for (int i = 0; i < dateOfMonth; i++) {
				x[i] = String.valueOf(i + 1);
				y[i] = "";
				y1[i] = "0";
			}
			Object[] data = null;
			for (int i = 0; i < dateOfMonth; i++) {
				for (int j = 0; j < lists.size(); j++) {
					data = lists.get(j);
					if ((Integer) data[0] == (i + 1)) {
						y[i] = String.valueOf(data[1]);
						y1[i] = String.valueOf(data[2]);
						break;
					}
				}
			}
			ReportJson.Tooltip tooltip = json.new Tooltip();
			tooltip.setTrigger("axis");
			json.setTooltip(tooltip);

			ReportJson.Legend legend = json.new Legend();
			legend.setX("center");
			legend.setY("89%");
			legend.setItemGap(2);
			legend.setData(new String[] { "当前会员", "新增会员" });
			legend.setShow("true");
			legend.setOrient("horizontal");
			json.setLegend(legend);

			ReportJson.Grid grid = json.new Grid();
			grid.setLeft("5%");
			grid.setContainLabel("true");
			json.setGrid(grid);

			ReportJson.XAxis xAxis = json.new XAxis();
			xAxis.setType("category");
			xAxis.setShow("true");
			xAxis.setData(x);
			xAxis.setName("日");
			json.setxAxis(xAxis);

			ReportJson.YAxis yAxis = json.new YAxis();
			yAxis.setType("value");
			yAxis.setName("会员总数");

			ReportJson.YAxis yAxis1 = json.new YAxis();
			yAxis1.setType("value");
			yAxis1.setName("会员增长数");
			ReportJson.YAxis[] yAxisArray = new ReportJson.YAxis[2];
			yAxisArray[0] = yAxis;
			yAxisArray[1] = yAxis1;
			json.setyAxis(yAxisArray);

			ReportJson.Series series = json.new Series();
			series.setName("当前会员");
			series.setType("bar");
			series.setData(y1);

			ReportJson.Series series1 = json.new Series();
			series1.setName("新增会员");
			series1.setType("line");
			series1.setyAxisIndex("1");
			series1.setData(y);
			ReportJson.Series[] seriesArray = new ReportJson.Series[2];
			seriesArray[0] = series;
			seriesArray[1] = series1;
			json.setSeries(seriesArray);
			return json;
		}
		return null;
	}

	// 网站数据
	@RequestMapping(value = "/websitedataReport", method = RequestMethod.GET)
	public String websiteReport() {
		return WEBSITE_REPORT;
	}

	@RequestMapping(value = "/websitedataReport/data", method = RequestMethod.GET)
	@ResponseBody
	public ReportJson websitedataReport(@RequestParam(value = "year", required = false) Integer year,
			@RequestParam(value = "month", required = false) Integer month) {
		ReportJson json = new ReportJson();
		// 默认不选为当年，x轴为12个月
		if (year > 0 && month == -1) {
			return findByJsonAndYear(json, year);
		} else if (year > 0 && month > 0) {
			int dateOfMonth = CalendarUtil.getDaysByYearMonth(year, month);
			String[] x = new String[dateOfMonth];
			String[] y = new String[dateOfMonth];
			String[] y1 = new String[dateOfMonth];
			String[] y2 = new String[dateOfMonth];
			String[] y3 = new String[dateOfMonth];
			String[] y4 = new String[dateOfMonth];
			List<Object[]> lists = websiteDataReportService.findByMonthAndDay0(year, month);
			List<Object[]> lists1 = websiteDataReportService.findByMonthAndDay1(year, month);
			List<Object[]> lists2 = websiteDataReportService.findByMonthAndDay2(year, month);
			List<Object[]> lists3 = websiteDataReportService.findByMonthAndDay3(year, month);
			List<Object[]> lists4 = websiteDataReportService.findByMonthAndDay4(year, month);
			Object[] data = null;
			for (int i = 0; i < dateOfMonth; i++) {
				x[i] = String.valueOf(i + 1);
				y[i] = "0";
				y1[i] = "0";
				y2[i] = "0";
				y3[i] = "0";
				y4[i] = "0";
			}
			for (int i = 0; i < dateOfMonth; i++) {
				for (int j = 0; j < lists.size(); j++) {
					data = lists.get(j);
					if ((Integer) (data[0]) == (i + 1)) {
						y[i] = String.valueOf(data[1]);
						break;
					}
				}
			}
			for (int i = 0; i < dateOfMonth; i++) {
				for (int j = 0; j < lists1.size(); j++) {
					data = lists1.get(j);
					if ((Integer) (data[0]) == (i + 1)) {
						y1[i] = String.valueOf(data[1]);
						break;
					}
				}
			}
			for (int i = 0; i < dateOfMonth; i++) {
				for (int j = 0; j < lists2.size(); j++) {
					data = lists2.get(j);
					if ((Integer) (data[0]) == (i + 1)) {
						y2[i] = String.valueOf(data[1]);
						break;
					}
				}
			}
			for (int i = 0; i < dateOfMonth; i++) {
				for (int j = 0; j < lists3.size(); j++) {
					data = lists3.get(j);
					if ((Integer) (data[0]) == (i + 1)) {
						y3[i] = String.valueOf(data[1]);
						break;
					}
				}
			}
			for (int i = 0; i < dateOfMonth; i++) {
				for (int j = 0; j < lists4.size(); j++) {
					data = lists4.get(j);
					if ((Integer) (data[0]) == (i + 1)) {
						y4[i] = String.valueOf(data[1]);
						break;
					}
				}
			}
			ReportJson.Tooltip tooltip = json.new Tooltip();
			tooltip.setTrigger("axis");
			json.setTooltip(tooltip);

			ReportJson.Legend legend = json.new Legend();
			legend.setData(new String[] { "主页", "品牌", "活动", "会员", "关于我们" });
			legend.setShow("true");
			legend.setOrient("horizontal");
			legend.setY("89%");
			legend.setItemGap(5);
			json.setLegend(legend);

			ReportJson.Grid grid = json.new Grid();
			grid.setLeft("8%");
			grid.setContainLabel("true");
			json.setGrid(grid);

			ReportJson.YAxis yAxis = json.new YAxis();
			yAxis.setName("网站点击数（pv）");
			yAxis.setType("value");
			ReportJson.YAxis[] yAxisArray = new ReportJson.YAxis[1];
			yAxisArray[0] = yAxis;
			json.setyAxis(yAxisArray);

			ReportJson.XAxis xAxis = json.new XAxis();
			xAxis.setData(x);
			xAxis.setName("日");
			xAxis.setShow("true");
			xAxis.setType("category");
			json.setxAxis(xAxis);

			jsonSetSeries(json, y, y1, y2, y3, y4);
			return json;
		}
		return null;
	}

	private ReportJson findByJsonAndYear(ReportJson json, int currentYear) {
		List<Object[]> lists = websiteDataReportService.findByYear0(currentYear);
		List<Object[]> lists1 = websiteDataReportService.findByYear1(currentYear);
		List<Object[]> lists2 = websiteDataReportService.findByYear2(currentYear);
		List<Object[]> lists3 = websiteDataReportService.findByYear3(currentYear);
		List<Object[]> lists4 = websiteDataReportService.findByYear4(currentYear);
		String[] x = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };
		String[] xDig = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		String[] y = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
		String[] y1 = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
		String[] y2 = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
		String[] y3 = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
		String[] y4 = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
		Object[] data = null;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < lists.size(); j++) {
				data = lists.get(j);
				if ((Integer) (data[0]) == (i + 1)) {
					y[i] = String.valueOf(data[1]);
					break;
				}
			}
		}
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < lists1.size(); j++) {
				data = lists1.get(j);
				if ((Integer) (data[0]) == (i + 1)) {
					y1[i] = String.valueOf(data[1]);
					break;
				}
			}
		}
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < lists2.size(); j++) {
				data = lists2.get(j);
				if ((Integer) (data[0]) == (i + 1)) {
					y2[i] = String.valueOf(data[1]);
					break;
				}
			}
		}
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < lists3.size(); j++) {
				data = lists3.get(j);
				if ((Integer) (data[0]) == (i + 1)) {
					y3[i] = String.valueOf(data[1]);
					break;
				}
			}
		}
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < lists4.size(); j++) {
				data = lists4.get(j);
				if ((Integer) (data[0]) == (i + 1)) {
					y4[i] = String.valueOf(data[1]);
					break;
				}
			}
		}

		ReportJson.Tooltip tooltip = json.new Tooltip();
		tooltip.setTrigger("axis");
		json.setTooltip(tooltip);

		ReportJson.Legend legend = json.new Legend();
		legend.setData(new String[] { "主页", "品牌", "活动", "会员", "关于我们" });
		legend.setShow("true");
		legend.setOrient("horizontal");
		legend.setY("89%");
		legend.setItemGap(5);
		json.setLegend(legend);

		ReportJson.Grid grid = json.new Grid();
		grid.setLeft("5%");
		grid.setContainLabel("true");
		json.setGrid(grid);

		ReportJson.YAxis yAxis = json.new YAxis();
		yAxis.setName("网站点击数（pv）");
		yAxis.setType("value");

		ReportJson.YAxis[] yAxisArray = new ReportJson.YAxis[1];
		yAxisArray[0] = yAxis;
		json.setyAxis(yAxisArray);

		ReportJson.XAxis xAxis = json.new XAxis();
		xAxis.setData(xDig);
		xAxis.setName("月");
		xAxis.setShow("true");
		xAxis.setType("category");
		json.setxAxis(xAxis);
		jsonSetSeries(json, y, y1, y2, y3, y4);
		return json;
	}

	private void jsonSetSeries(ReportJson json, String[] y, String[] y1, String[] y2, String[] y3, String[] y4) {
		ReportJson.Series series = json.new Series();
		series.setName("主页");
		series.setType("bar");
		series.setStack("总量");
		series.setData(y);

		ReportJson.Series series1 = json.new Series();
		series1.setName("品牌");
		series1.setType("bar");
		series1.setStack("总量");
		series1.setData(y1);

		ReportJson.Series series2 = json.new Series();
		series2.setName("活动");
		series2.setType("bar");
		series2.setStack("总量");
		series2.setData(y2);

		ReportJson.Series series3 = json.new Series();
		series3.setName("会员");
		series3.setType("bar");
		series3.setStack("总量");
		series3.setData(y3);

		ReportJson.Series series4 = json.new Series();
		series4.setName("关于我们");
		series4.setType("bar");
		series4.setStack("总量");
		series4.setData(y4);

		ReportJson.Series[] seriesArray = new ReportJson.Series[5];
		seriesArray[0] = series;
		seriesArray[1] = series1;
		seriesArray[2] = series2;
		seriesArray[3] = series3;
		seriesArray[4] = series4;
		json.setSeries(seriesArray);
	}
}
