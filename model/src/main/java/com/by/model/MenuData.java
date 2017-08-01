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
@Table(name = "by_menu_data")
public class MenuData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//商场名称 0为金桥太茂,1为南翔太茂
	private Integer market;
	//0为如何到达，1为品牌索引，2为最新活动，3为我的会员卡，4为积分兑换，5为停车缴费，6为我的券库
	private Integer type;
	//点击次数
	private Integer number;
	//访问时间
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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

	public Integer getMarket() {
		return market;
	}

	public void setMarket(Integer market) {
		this.market = market;
	}
	
}
