package com.by.json;

import java.util.Calendar;

import com.by.model.WebsiteData;

public class WebsiteJson {
	private int id;
	private Integer market;
	private Integer siteName;
	private Integer siteNumber;
	private Calendar browseTime;
	public WebsiteJson(WebsiteData websitedate){
		this.id=websitedate.getId();
		this.market=websitedate.getMarket();
		this.siteName=(websitedate.getSiteName());
		this.siteNumber=websitedate.getSiteNumber();
		this.browseTime=websitedate.getBrowseTime();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getSiteNumber() {
		return siteNumber;
	}
	public void setSiteNumber(Integer siteNumber) {
		this.siteNumber = siteNumber;
	}
	public Calendar getBrowseTime() {
		return browseTime;
	}
	public void setBrowseTime(Calendar browseTime) {
		this.browseTime = browseTime;
	}
	public Integer getSiteName() {
		return siteName;
	}
	public void setSiteName(Integer siteName) {
		this.siteName = siteName;
	}
	public Integer getMarket() {
		return market;
	}
	public void setMarket(Integer market) {
		this.market = market;
	}
	
}
