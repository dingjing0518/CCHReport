package com.by.json;

import com.by.model.Activity;

public class ActivityJson {
	private int id;
	private Integer sort;
	private String activityImg;
	private String name;
	public ActivityJson(){
		
	}
	public ActivityJson(Activity activity){
		this.id=activity.getId();
		this.activityImg=activity.getActivityImg();
		this.name=activity.getName();
		this.sort=activity.getSort();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getActivityImg() {
		return activityImg;
	}
	public void setActivityImg(String activityImg) {
		this.activityImg = activityImg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
