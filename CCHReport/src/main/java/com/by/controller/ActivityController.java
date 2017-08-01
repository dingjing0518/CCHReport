package com.by.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.by.model.Activity;
import com.by.model.ActivitySlide;
import com.by.service.ActivityService;
import com.by.service.ActivitySildeService;

/**
 * @author dingjing
 *
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {
	private final String ACTIVITY = "activity/activity";
	@Autowired
	private ActivityService activityService;
	@Autowired
	private ActivitySildeService activitySildeService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String activtyIndex(Model uiModel){
		List<Activity> activitys=activityService.findAll(new Sort(Sort.Direction.ASC, "sort"));
		uiModel.addAttribute("newactivity", activitys.get(0));
		uiModel.addAttribute("activity", activitys.get(1));
		uiModel.addAttribute("activity1", activitys.get(2));
		uiModel.addAttribute("newactivity1", activitys.get(3));
		List<ActivitySlide> activitySlides =activitySildeService.findAll();
		List<ActivitySlide> newActivitySlides=new ArrayList<>();
		for(int i=0;i<activitySlides.size();i++){
			if(activitySlides.get(i).getStatus()==0){
				newActivitySlides.add(activitySlides.get(i));
			}
		}
		uiModel.addAttribute("activitySlides", newActivitySlides);
		return ACTIVITY;
	}
}
