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

import com.by.model.Menu;
import com.by.model.MenuData;
import com.by.service.MenuDataService;
@Controller
@RequestMapping("/admin/menudata")
public class AdminMenuDataController extends BaseController{
	private final Menu subMenu = new Menu(41);
	private final String LIST = "admin/menudata/lists";
	private final String CREATE = "admin/menudata/create";
	private final String EDIT = "admin/menudata/edit";
	private final String REDIRECT = "redirect:/admin/menudata/";
	@Autowired
	private MenuDataService service;
	@Autowired
	private MessageSource messageSource;
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		List<MenuData> menuDatas = service.findAll();
		uiModel.addAttribute("lists", menuDatas);
		return LIST;
	}
		//新增录入数据页面
		@RequestMapping(params = "form", method = RequestMethod.GET)
		public String save() {
			return CREATE;
		}
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public String update(@PathVariable("id") int id, Model uiModel, 
				@ModelAttribute("menuData") MenuData menuData, BindingResult result, RedirectAttributes redirectAttributes) {
			menuData.setId(id);
			if (result.hasErrors()) {
				uiModel.addAttribute("menuData", menuData);
				uiModel.addAttribute("message", failMessage(messageSource));
				return EDIT;
			}
			service.update(menuData);
			redirectAttributes.addFlashAttribute("message", successMessage(messageSource));
			return REDIRECT + id;
		}
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public String detail(@PathVariable("id") int id, Model uiModel) {
			MenuData menuData = service.findOne(id);
			uiModel.addAttribute("menuData", menuData);
			return EDIT;
		}
		@RequestMapping(value="/save", method = RequestMethod.POST)
		@ResponseBody
		public String saveData(@RequestParam("market") String market,@RequestParam("browseTime") String browseTime,
				@RequestParam("siteName") String siteName,@RequestParam("siteNumber") String siteNumber) throws Exception{
			MenuData websiteData=new MenuData();
			websiteData.setMarket(new Integer(market));
			websiteData.setType(new Integer(siteName));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=sdf.parse(browseTime);
			Calendar c=Calendar.getInstance();
			c.setTime(date);
			websiteData.setBrowseTime(c);
			websiteData.setNumber(new Integer(siteNumber));
			service.save(websiteData);
			return "success";
			}
		@RequestMapping(value="/save1", method = RequestMethod.POST)
		@ResponseBody
		public String saveData1(@RequestParam("market") String market,@RequestParam("browseTime") String browseTime,
				@RequestParam("siteName1") String siteName1,@RequestParam("siteNumber1") String siteNumber1) throws Exception{
			MenuData websiteData=new MenuData();
			websiteData.setMarket(new Integer(market));
			websiteData.setType(new Integer(siteName1));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=sdf.parse(browseTime);
			Calendar c=Calendar.getInstance();
			c.setTime(date);
			websiteData.setBrowseTime(c);
			websiteData.setNumber(new Integer(siteNumber1));
			service.save1(websiteData);
			return "success";
			}
		@RequestMapping(value="/save2", method = RequestMethod.POST)
		@ResponseBody
		public String saveData2(@RequestParam("market") String market,@RequestParam("browseTime") String browseTime,
				@RequestParam("siteName2") String siteName2,@RequestParam("siteNumber2") String siteNumber2) throws Exception{
			MenuData websiteData=new MenuData();
			websiteData.setMarket(new Integer(market));
			websiteData.setType(new Integer(siteName2));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=sdf.parse(browseTime);
			Calendar c=Calendar.getInstance();
			c.setTime(date);
			websiteData.setBrowseTime(c);
			websiteData.setNumber(new Integer(siteNumber2));
			service.save2(websiteData);
			return "success";
			}
		@RequestMapping(value="/save3", method = RequestMethod.POST)
		@ResponseBody
		public String saveData3(@RequestParam("market") String market,@RequestParam("browseTime") String browseTime,
				@RequestParam("siteName3") String siteName3,@RequestParam("siteNumber3") String siteNumber3) throws Exception{
			MenuData websiteData=new MenuData();
			websiteData.setMarket(new Integer(market));
			websiteData.setType(new Integer(siteName3));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=sdf.parse(browseTime);
			Calendar c=Calendar.getInstance();
			c.setTime(date);
			websiteData.setBrowseTime(c);
			websiteData.setNumber(new Integer(siteNumber3));
			service.save3(websiteData);
			return "success";
			}
		@RequestMapping(value="/save4", method = RequestMethod.POST)
		@ResponseBody
		public String saveData4(@RequestParam("market") String market,@RequestParam("browseTime") String browseTime,
				@RequestParam("siteName4") String siteName4,@RequestParam("siteNumber4") String siteNumber4) throws Exception{
			MenuData websiteData=new MenuData();
			websiteData.setMarket(new Integer(market));
			websiteData.setType(new Integer(siteName4));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=sdf.parse(browseTime);
			Calendar c=Calendar.getInstance();
			c.setTime(date);
			websiteData.setBrowseTime(c);
			websiteData.setNumber(new Integer(siteNumber4));
			service.save4(websiteData);
			return "success";
			}
		@RequestMapping(value="/save5", method = RequestMethod.POST)
		@ResponseBody
		public String saveData5(@RequestParam("market") String market,@RequestParam("browseTime") String browseTime,
				@RequestParam("siteName5") String siteName5,@RequestParam("siteNumber5") String siteNumber5) throws Exception{
			MenuData websiteData=new MenuData();
			websiteData.setMarket(new Integer(market));
			websiteData.setType(new Integer(siteName5));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=sdf.parse(browseTime);
			Calendar c=Calendar.getInstance();
			c.setTime(date);
			websiteData.setBrowseTime(c);
			websiteData.setNumber(new Integer(siteNumber5));
			service.save5(websiteData);
			return "success";
			}
		@RequestMapping(value="/save6", method = RequestMethod.POST)
		@ResponseBody
		public String saveData6(@RequestParam("market") String market,@RequestParam("browseTime") String browseTime,
				@RequestParam("siteName6") String siteName6,@RequestParam("siteNumber6") String siteNumber6) throws Exception{
			MenuData websiteData=new MenuData();
			websiteData.setMarket(new Integer(market));
			websiteData.setType(new Integer(siteName6));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=sdf.parse(browseTime);
			Calendar c=Calendar.getInstance();
			c.setTime(date);
			websiteData.setBrowseTime(c);
			websiteData.setNumber(new Integer(siteNumber6));
			service.save6(websiteData);
			return "success";
			}
	@Override
	public Menu getSubMenu() {
		return subMenu;
	}

}
