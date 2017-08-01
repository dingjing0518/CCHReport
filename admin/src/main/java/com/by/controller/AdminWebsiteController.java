package com.by.controller;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
import com.by.model.WebsiteData;
import com.by.service.WebsiteDataService;

@Controller
@RequestMapping("/admin/website")
public class AdminWebsiteController extends BaseController{
	private final Menu subMenu = new Menu(38);
	private final String LIST = "admin/website/lists";
	private final String CREATE = "admin/website/create";
	private final String EDIT = "admin/website/edit";
	private final String REDIRECT = "redirect:/admin/website/";
	@Autowired
	private WebsiteDataService service;
	@Autowired
	private MessageSource messageSource;
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		List<WebsiteData> websiteDatas = service.findAll();
		uiModel.addAttribute("lists", websiteDatas);
		return LIST;
	}
	//新增录入数据页面
	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String save() {
		return CREATE;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") int id, Model uiModel, 
			@ModelAttribute("websiteData") WebsiteData websiteData, BindingResult result, RedirectAttributes redirectAttributes) {
		websiteData.setId(id);
		if (result.hasErrors()) {
			uiModel.addAttribute("websiteData", websiteData);
			uiModel.addAttribute("message", failMessage(messageSource));
			return EDIT;
		}
		service.update(websiteData);
		redirectAttributes.addFlashAttribute("message", successMessage(messageSource));
		return REDIRECT + id;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") int id, Model uiModel) {
		WebsiteData websiteData = service.findOne(id);
		uiModel.addAttribute("websiteData", websiteData);
		return EDIT;
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@RequestParam("market") String market,@RequestParam("browseTime") String browseTime,
			@RequestParam("siteName") String siteName,@RequestParam("siteNumber") String siteNumber) throws Exception{
		WebsiteData websiteData=new WebsiteData();
		websiteData.setMarket(new Integer(market));
		websiteData.setSiteName(new Integer(siteName));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=sdf.parse(browseTime);
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		websiteData.setBrowseTime(c);
		websiteData.setSiteNumber(new Integer(siteNumber));
		service.save(websiteData);
		return "success";
		}
	@RequestMapping(value="/save1", method = RequestMethod.POST)
	@ResponseBody
	public String save1(@RequestParam("market") String market,@RequestParam("browseTime") String browseTime,
			@RequestParam("siteName1") String siteName1,@RequestParam("siteNumber1") String siteNumber1) throws Exception{
		WebsiteData websiteData=new WebsiteData();
		websiteData.setMarket(new Integer(market));
		websiteData.setSiteName(new Integer(siteName1));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=sdf.parse(browseTime);
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		websiteData.setBrowseTime(c);
		websiteData.setSiteNumber(new Integer(siteNumber1));
		service.save(websiteData);
		return "success";
		}
	@RequestMapping(value="/save2", method = RequestMethod.POST)
	@ResponseBody
	public String save2(@RequestParam("market") String market,@RequestParam("browseTime") String browseTime,
			@RequestParam("siteName2") String siteName2,@RequestParam("siteNumber2") String siteNumber2) throws Exception{
		WebsiteData websiteData=new WebsiteData();
		websiteData.setMarket(new Integer(market));
		websiteData.setSiteName(new Integer(siteName2));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=sdf.parse(browseTime);
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		websiteData.setBrowseTime(c);
		websiteData.setSiteNumber(new Integer(siteNumber2));
		service.save(websiteData);
		return "success";
		}
	@RequestMapping(value="/save3", method = RequestMethod.POST)
	@ResponseBody
	public String save3(@RequestParam("market") String market,@RequestParam("browseTime") String browseTime,
			@RequestParam("siteName3") String siteName3,@RequestParam("siteNumber3") String siteNumber3) throws Exception{
		WebsiteData websiteData=new WebsiteData();
		websiteData.setMarket(new Integer(market));
		websiteData.setSiteName(new Integer(siteName3));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=sdf.parse(browseTime);
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		websiteData.setBrowseTime(c);
		websiteData.setSiteNumber(new Integer(siteNumber3));
		service.save(websiteData);
		return "success";
		}
	@RequestMapping(value="/save4", method = RequestMethod.POST)
	@ResponseBody
	public String save4(@RequestParam("market") String market,@RequestParam("browseTime") String browseTime,
			@RequestParam("siteName4") String siteName4,@RequestParam("siteNumber4") String siteNumber4) throws Exception{
		WebsiteData websiteData=new WebsiteData();
		websiteData.setMarket(new Integer(market));
		websiteData.setSiteName(new Integer(siteName4));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=sdf.parse(browseTime);
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		websiteData.setBrowseTime(c);
		websiteData.setSiteNumber(new Integer(siteNumber4));
		service.save(websiteData);
		return "success";
		}
	@Override
	public Menu getSubMenu() {
		return subMenu;
	}

}
