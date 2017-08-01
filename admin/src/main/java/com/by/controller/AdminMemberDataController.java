package com.by.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.by.model.MemberData;
import com.by.model.Menu;
import com.by.service.MemberDataService;

@Controller
@RequestMapping("/admin/memberData")
public class AdminMemberDataController extends BaseController {
	private final Menu subMenu = new Menu(40);
	private final String LIST = "admin/memberdata/lists";
	private final String CREATE = "admin/memberdata/create";
	private final String EDIT = "admin/memberdata/edit";
	private final String REDIRECT = "redirect:/admin/memberData/";
	@Autowired
	private MemberDataService service;
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		List<MemberData> fans = service.findAll();
		uiModel.addAttribute("lists", fans);
		return LIST;
	}

	// 新增录入数据页面
	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String save() {
		return CREATE;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") int id, Model uiModel, @ModelAttribute("memberData") MemberData memberData,
			BindingResult result, RedirectAttributes redirectAttributes) {
		memberData.setId(id);
		if (result.hasErrors()) {
			uiModel.addAttribute("memberData", memberData);
			uiModel.addAttribute("message", failMessage(messageSource));
			return EDIT;
		}
		service.update(memberData);
		redirectAttributes.addFlashAttribute("message", successMessage(messageSource));
		return REDIRECT + id;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") int id, Model uiModel) {
		MemberData memberData = service.findOne(id);
		uiModel.addAttribute("fan", memberData);
		return EDIT;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@RequestParam("market") String market, @RequestParam("browseTime1") String browseTime1,
			@RequestParam("fanNumber1") String fanNumber1, @RequestParam("fansNumber1") String fansNumber1)
					throws Exception {
		MemberData f = new MemberData();
		f.setMarket(new Integer(market));
		f.setMemberNumber(new Integer(fanNumber1));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(browseTime1);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		f.setBrowseTime(c);
		f.setMembersNumbers(new Integer(fansNumber1));
		service.save(f);
		return "success";
	}

	@RequestMapping(value = "/save1", method = RequestMethod.POST)
	@ResponseBody
	public String save1(@RequestParam("market") String market, @RequestParam("browseTime2") String browseTime2,
			@RequestParam("fanNumber2") String fanNumber2, @RequestParam("fansNumber2") String fansNumber2)
					throws Exception {
		MemberData f = new MemberData();
		f.setMarket(new Integer(market));
		f.setMemberNumber(new Integer(fanNumber2));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(browseTime2);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		f.setBrowseTime(c);
		f.setMembersNumbers(new Integer(fansNumber2));
		service.save(f);
		return "success";
	}

	@RequestMapping(value = "/save2", method = RequestMethod.POST)
	@ResponseBody
	public String save2(@RequestParam("market") String market, @RequestParam("browseTime3") String browseTime3,
			@RequestParam("fanNumber3") String fanNumber3, @RequestParam("fansNumber3") String fansNumber3)
					throws Exception {
		MemberData f = new MemberData();
		f.setMarket(new Integer(market));
		f.setMemberNumber(new Integer(fanNumber3));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(browseTime3);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		f.setBrowseTime(c);
		f.setMembersNumbers(new Integer(fansNumber3));
		service.save(f);
		return "success";
	}

	@RequestMapping(value = "/save3", method = RequestMethod.POST)
	@ResponseBody
	public String save3(@RequestParam("market") String market, @RequestParam("browseTime4") String browseTime4,
			@RequestParam("fanNumber4") String fanNumber4, @RequestParam("fansNumber4") String fansNumber4)
					throws Exception {
		MemberData f = new MemberData();
		f.setMarket(new Integer(market));
		f.setMemberNumber(new Integer(fanNumber4));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(browseTime4);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		f.setBrowseTime(c);
		f.setMembersNumbers(new Integer(fansNumber4));
		service.save(f);
		return "success";
	}

	@RequestMapping(value = "/save4", method = RequestMethod.POST)
	@ResponseBody
	public String save4(@RequestParam("market") String market, @RequestParam("browseTime5") String browseTime5,
			@RequestParam("fanNumber5") String fanNumber5, @RequestParam("fansNumber5") String fansNumber5)
					throws Exception {
		MemberData f = new MemberData();
		f.setMarket(new Integer(market));
		f.setMemberNumber(new Integer(fanNumber5));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(browseTime5);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		f.setBrowseTime(c);
		f.setMembersNumbers(new Integer(fansNumber5));
		service.save(f);
		return "success";
	}

	@RequestMapping(value = "/save5", method = RequestMethod.POST)
	@ResponseBody
	public String save5(@RequestParam("market") String market, @RequestParam("browseTime6") String browseTime6,
			@RequestParam("fanNumber6") String fanNumber6, @RequestParam("fansNumber6") String fansNumber6)
					throws Exception {
		MemberData f = new MemberData();
		f.setMarket(new Integer(market));
		f.setMemberNumber(new Integer(fanNumber6));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(browseTime6);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		f.setBrowseTime(c);
		f.setMembersNumbers(new Integer(fansNumber6));
		service.save(f);
		return "success";
	}

	@RequestMapping(value = "/save6", method = RequestMethod.POST)
	@ResponseBody
	public String save6(@RequestParam("market") String market, @RequestParam("browseTime7") String browseTime7,
			@RequestParam("fanNumber7") String fanNumber7, @RequestParam("fansNumber7") String fansNumber7)
					throws Exception {
		MemberData f = new MemberData();
		f.setMarket(new Integer(market));
		f.setMemberNumber(new Integer(fanNumber7));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(browseTime7);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		f.setBrowseTime(c);
		f.setMembersNumbers(new Integer(fansNumber7));
		service.save(f);
		return "success";
	}

	@Override
	public Menu getSubMenu() {
		return subMenu;
	}
}
