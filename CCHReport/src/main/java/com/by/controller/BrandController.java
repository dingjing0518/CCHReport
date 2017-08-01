package com.by.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.by.model.Brand;
import com.by.model.ShopCategory;
import com.by.service.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandController {
	private final String LIST = "brand/brand";
	private final String FOOD_LIST = "brand/food/food";
	private final String LIFE_LIST = "brand/life/life";
	private final String FUN_LIST = "brand/fun/fun";
	private final String CHILD_LIST = "brand/child/child";
	
	@Autowired
	private BrandService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Model uiModel) {	
		List<Brand> brands = service.findAll(new Sort(Sort.Direction.ASC, "sortAll"));
		List<Brand> newBrands = selectStatus(brands);
		uiModel.addAttribute("brands", newBrands);
		return LIST;
	}
	private List<Brand> selectStatus(List<Brand> brands) {
		List<Brand> newBrands=new ArrayList<>();
      for(int i=0;i<brands.size();i++){
    	  Brand brand=brands.get(i);
    	  if(brand.getStatus()==0){
    		  newBrands.add(brand);
    	  }
      }
		return newBrands;
	}
	//餐饮
	@RequestMapping(value = "/food/", method = RequestMethod.GET)
	public String foodList(Model uiModel) {
		List<Brand> recommandBrands = service.findRecommandByBrandCategory(new ShopCategory(32),new Sort(Sort.Direction.ASC, "sort"));
		List<Brand> newRecommandBrands=selectStatus(recommandBrands);
		List<Brand> otherBrands = service.findOtherByBrandCategory(new ShopCategory(32),new Sort(Sort.Direction.ASC, "sort"));
		List<Brand>newOtherBrands=selectStatus(otherBrands);
		uiModel.addAttribute("recommandBrands", newRecommandBrands.subList(0, 2));
		uiModel.addAttribute("otherBrands", newRecommandBrands.subList(2, 6));
		uiModel.addAttribute("brands", newOtherBrands);
		return FOOD_LIST;
	}
	//美丽人生
	@RequestMapping(value = "/life/", method = RequestMethod.GET)
	public String retailList(Model uiModel) {	
		List<Brand> recommandBrands = service.findRecommandByBrandCategory(new ShopCategory(35),new Sort(Sort.Direction.ASC, "sort"));
		List<Brand> newRecommandBrands=selectStatus(recommandBrands);
		uiModel.addAttribute("recommandBrands", newRecommandBrands.subList(0, 2));
		uiModel.addAttribute("otherBrands", newRecommandBrands.subList(2, 4));
		return LIFE_LIST;
	}
	//休闲生活
	@RequestMapping(value = "/fun/", method = RequestMethod.GET)
	public String funList(Model uiModel) {	
		List<Brand> recommandBrands = service.findRecommandByBrandCategory(new ShopCategory(34),new Sort(Sort.Direction.ASC, "sort"));
		List<Brand> newRecommandBrands=selectStatus(recommandBrands);
		uiModel.addAttribute("recommandBrands", newRecommandBrands.subList(0, 2));
		uiModel.addAttribute("otherBrands", newRecommandBrands.subList(2, 6));
		return FUN_LIST;
	}
	//儿童欢乐与教育
	@RequestMapping(value = "/child/", method = RequestMethod.GET)
	public String childList(Model uiModel) {	
		List<Brand> recommandBrands = service.findRecommandByBrandCategory(new ShopCategory(36),new Sort(Sort.Direction.ASC, "sort"));
		List<Brand> newRecommandBrands=selectStatus(recommandBrands);
		uiModel.addAttribute("recommandBrands", newRecommandBrands.subList(0, 2));
		uiModel.addAttribute("otherBrands", newRecommandBrands.subList(2, 6));
		return CHILD_LIST;
	}
	
}
