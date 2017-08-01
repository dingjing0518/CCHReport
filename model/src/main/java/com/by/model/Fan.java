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
@Entity
@Table(name = "by_fan")
public class Fan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//商场名称 0为金桥太茂,1为南翔太茂
	private Integer market;
	//新增粉丝
	@Column(name="fan_number")
	private Integer fanNumber;
	//粉丝总数
	@Column(name="fans_number")
	private Integer fanNumbers;
	//WiFi粉丝总数
	@Column(name="wifi_fans_number")
	private Integer wfanNumbers;
	//时间
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

	public Integer getMarket() {
		return market;
	}

	public void setMarket(Integer market) {
		this.market = market;
	}

	public Integer getFanNumber() {
		return fanNumber;
	}

	public void setFanNumber(Integer fanNumber) {
		this.fanNumber = fanNumber;
	}

	public Integer getFanNumbers() {
		return fanNumbers;
	}

	public void setFanNumbers(Integer fanNumbers) {
		this.fanNumbers = fanNumbers;
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

	public Integer getWfanNumbers() {
		return wfanNumbers;
	}

	public void setWfanNumbers(Integer wfanNumbers) {
		this.wfanNumbers = wfanNumbers;
	}
	
}
