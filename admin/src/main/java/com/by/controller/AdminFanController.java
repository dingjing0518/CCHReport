package com.by.controller;

import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.by.model.Fan;
import com.by.model.Menu;
import com.by.service.FanService;
import com.by.utils.CalendarUtil;

@Controller
@RequestMapping("/admin/fan")
public class AdminFanController extends BaseController {
	private final Menu subMenu = new Menu(39);
	private final String LIST = "admin/fan/lists";
	private final String CREATE = "admin/fan/create";
	private final String EDIT = "admin/fan/edit";
	private final String REDIRECT = "redirect:/admin/fan/";

	@Autowired
	private FanService service;
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		List<Fan> lists = service.findAll();
		uiModel.addAttribute("lists", lists);
		return LIST;
	}

	// 新增录入数据页面
	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String save() {
		return CREATE;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") int id, Model uiModel, @ModelAttribute("fan") Fan fan,
			BindingResult result, RedirectAttributes redirectAttributes) {
		fan.setId(id);
		if (result.hasErrors()) {
			uiModel.addAttribute("fan", fan);
			uiModel.addAttribute("message", failMessage(messageSource));
			return EDIT;
		}
		service.update(fan);
		redirectAttributes.addFlashAttribute("message", successMessage(messageSource));
		return REDIRECT + id;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") int id, Model uiModel) {
		Fan fan = service.findOne(id);
		uiModel.addAttribute("fan", fan);
		return EDIT;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@RequestParam("market") String market, @RequestParam("browseTime1") String browseTime1,
			@RequestParam("fanNumber1") String fanNumber1, @RequestParam("fansNumber1") String fansNumber1,
			@RequestParam("wfansNumber1") String wfansNumber1) throws Exception {
		Fan f = new Fan();
		f.setMarket(new Integer(market));
		f.setFanNumber(new Integer(fanNumber1));
		Calendar calendar = CalendarUtil.stringToCalendar(browseTime1);
		f.setBrowseTime(calendar);
		f.setFanNumbers(new Integer(fansNumber1));
		f.setWfanNumbers(new Integer(wfansNumber1));
		service.save(f);
		return "success";
	}

	@RequestMapping(value = "/save1", method = RequestMethod.POST)
	@ResponseBody
	public String save1(@RequestParam("market") String market, @RequestParam("browseTime2") String browseTime2,
			@RequestParam("fanNumber2") String fanNumber2, @RequestParam("fansNumber2") String fansNumber2,
			@RequestParam("wfansNumber2") String wfansNumber2) throws Exception {
		Fan f = new Fan();
		f.setMarket(new Integer(market));
		f.setFanNumber(new Integer(fanNumber2));
		Calendar calendar = CalendarUtil.stringToCalendar(browseTime2);
		f.setBrowseTime(calendar);
		f.setFanNumbers(new Integer(fansNumber2));
		f.setWfanNumbers(new Integer(wfansNumber2));
		service.save(f);
		return "success";
	}

	@RequestMapping(value = "/save2", method = RequestMethod.POST)
	@ResponseBody
	public String save2(@RequestParam("market") String market, @RequestParam("browseTime3") String browseTime3,
			@RequestParam("fanNumber3") String fanNumber3, @RequestParam("fansNumber3") String fansNumber3,
			@RequestParam("wfansNumber3") String wfansNumber3) throws Exception {
		Fan f = new Fan();
		f.setMarket(new Integer(market));
		f.setFanNumber(new Integer(fanNumber3));
		Calendar calendar = CalendarUtil.stringToCalendar(browseTime3);
		f.setBrowseTime(calendar);
		f.setFanNumbers(new Integer(fansNumber3));
		f.setWfanNumbers(new Integer(wfansNumber3));
		service.save(f);
		return "success";
	}

	@RequestMapping(value = "/save3", method = RequestMethod.POST)
	@ResponseBody
	public String save3(@RequestParam("market") String market, @RequestParam("browseTime4") String browseTime4,
			@RequestParam("fanNumber4") String fanNumber4, @RequestParam("fansNumber4") String fansNumber4,
			@RequestParam("wfansNumber4") String wfansNumber4) throws Exception {
		Fan f = new Fan();
		f.setMarket(new Integer(market));
		f.setFanNumber(new Integer(fanNumber4));
		Calendar calendar = CalendarUtil.stringToCalendar(browseTime4);
		f.setBrowseTime(calendar);
		f.setFanNumbers(new Integer(fansNumber4));
		f.setWfanNumbers(new Integer(wfansNumber4));
		service.save(f);
		return "success";
	}

	@RequestMapping(value = "/save4", method = RequestMethod.POST)
	@ResponseBody
	public String save4(@RequestParam("market") String market, @RequestParam("browseTime5") String browseTime5,
			@RequestParam("fanNumber5") String fanNumber5, @RequestParam("fansNumber5") String fansNumber5,
			@RequestParam("wfansNumber5") String wfansNumber5) throws Exception {
		Fan f = new Fan();
		f.setMarket(new Integer(market));
		f.setFanNumber(new Integer(fanNumber5));
		Calendar calendar = CalendarUtil.stringToCalendar(browseTime5);
		f.setBrowseTime(calendar);
		f.setFanNumbers(new Integer(fansNumber5));
		f.setWfanNumbers(new Integer(wfansNumber5));
		service.save(f);
		return "success";
	}

	@RequestMapping(value = "/save5", method = RequestMethod.POST)
	@ResponseBody
	public String save5(@RequestParam("market") String market, @RequestParam("browseTime6") String browseTime6,
			@RequestParam("fanNumber6") String fanNumber6, @RequestParam("fansNumber6") String fansNumber6,
			@RequestParam("wfansNumber6") String wfansNumber6) throws Exception {
		Fan f = new Fan();
		f.setMarket(new Integer(market));
		f.setFanNumber(new Integer(fanNumber6));
		Calendar calendar = CalendarUtil.stringToCalendar(browseTime6);
		f.setBrowseTime(calendar);
		f.setFanNumbers(new Integer(fansNumber6));
		f.setWfanNumbers(new Integer(wfansNumber6));
		service.save(f);
		return "success";
	}

	@RequestMapping(value = "/save6", method = RequestMethod.POST)
	@ResponseBody
	public String save6(@RequestParam("market") String market, @RequestParam("browseTime7") String browseTime7,
			@RequestParam("fanNumber7") String fanNumber7, @RequestParam("fansNumber7") String fansNumber7,
			@RequestParam("wfansNumber7") String wfansNumber7) throws Exception {
		Fan f = new Fan();
		f.setMarket(new Integer(market));
		f.setFanNumber(new Integer(fanNumber7));
		Calendar calendar = CalendarUtil.stringToCalendar(browseTime7);
		f.setBrowseTime(calendar);
		f.setFanNumbers(new Integer(fansNumber7));
		f.setWfanNumbers(new Integer(wfansNumber7));
		service.save(f);
		return "success";
	}

	@Override
	public Menu getSubMenu() {
		return subMenu;
	}

}
