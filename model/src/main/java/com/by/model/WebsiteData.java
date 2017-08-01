package com.by.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.by.json.WebsiteJson;

@Entity
@Table(name = "by_website_data")
public class WebsiteData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//商场名称 0为金桥太茂,1为南翔太茂
	private Integer market;
	//网页名称,o为主页,1为品牌页,2为活动页,3为会员页,4为关于我们页
	@Column(name="site_name")
	private Integer siteName;
	//网页点击数量
	@Column(name="site_number")
	private Integer siteNumber;
	//网页访问时间
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="browse_time")
	private Calendar browseTime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time")
	private Calendar createdTime;

	@Column(name = "created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_time")
	private Calendar updatedTime;

	@Column(name = "updated_by")
	private String updatedBy;

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

	public Integer getSiteName() {
		return siteName;
	}

	public void setSiteName(Integer siteName) {
		this.siteName = siteName;
	}

	public Calendar getBrowseTime() {
		return browseTime;
	}

	public void setBrowseTime(Calendar browseTime) {
		this.browseTime = browseTime;
	}

	public Calendar getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Calendar getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Calendar updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public WebsiteJson toJson(){
		return new WebsiteJson(this);
	}

	public Integer getMarket() {
		return market;
	}

	public void setMarket(Integer market) {
		this.market = market;
	}
}
