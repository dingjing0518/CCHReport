package com.by.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.by.form.ReportForm;
@Controller
public class AdminReportController {
	private final String MEMBER_REPORT = "admin/report/member";
	private String[] months = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };

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
	/*
	 * @RequestMapping(value = "/admin/memberReport/data", method =
	 * RequestMethod.GET)
	 * 
	 * @ResponseBody public List<MonthMemberReport>
	 * memberReportData(@RequestParam(value = "year", required = false) Integer
	 * year) { Calendar today = Calendar.getInstance(); int y = getYear(today,
	 * year); int m = getMonth(today, year); List<Object[]> lists =
	 * service.findByYearAndMonth(y, m); List<MonthMemberReport> results =
	 * lists.stream().map(i -> { Integer j = ((Integer) i[0]); String k =
	 * months[j - 1]; int v = ((Long) i[1]).intValue(); String time = (String)
	 * i[2]; return new MonthMemberReport(k, v, time);
	 * }).collect(Collectors.toList()); return results; }
	 */

	/*
	 * @RequestMapping(value = "/admin/tradingReport/data", method =
	 * RequestMethod.GET)
	 * 
	 * @ResponseBody public List<MonthTradingReport>
	 * tradingReportData(@RequestParam(value = "year", required = false) Integer
	 * year) { Calendar today = Calendar.getInstance(); int y = getYear(today,
	 * year); int m = getMonth(today, year); List<Object[]> lists =
	 * tradingService.findByYearAndMonth(y, m); return lists.stream().map(i -> {
	 * Integer j = ((Integer) i[0]); String month = months[j - 1]; int number =
	 * ((Long) i[1]).intValue(); Double amount = ((Double) i[2]); String time =
	 * (String) i[3]; return new MonthTradingReport(month, amount, number,
	 * time); }).collect(Collectors.toList()); }
	 */

}
