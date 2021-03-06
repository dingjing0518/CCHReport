package com.by.json;

import com.by.model.CardRule;
import com.by.model.ShopRule;
import com.by.typeEnum.ValidEnum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by yagamai on 15-12-10.
 */
public class RuleJson {
	private int id;
	private String beginTime;
	private String endTime;
	private String cardName;
	private String category;
	private String cssClass;
	private String state;
	private String name;
	private double rate;
	private int score;

	public RuleJson() {
	}

	public RuleJson(CardRule rule) {
		this.id = rule.getId();
		Calendar today = Calendar.getInstance();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (rule.getBeginTime() == null && rule.getEndTime() == null) {
			this.cssClass = "text-success";
			this.state = "使用中";
		} else if (rule.getBeginTime() != null && rule.getEndTime() != null) {
			if (rule.getBeginTime().before(today) && rule.getEndTime().after(today)) {
				this.cssClass = "text-success";
				this.state = "使用中";
			} else if (rule.getBeginTime().after(today)) {
				this.cssClass = "text-primary";
				this.state = "未生效";
			} else if (rule.getEndTime().before(today)) {
				this.cssClass = "text-muted";
				this.state = "已过期";
			}
			this.beginTime = format.format(rule.getBeginTime().getTime());
			this.endTime = format.format(rule.getEndTime().getTime());
		}
		if (rule.getValid().equals(ValidEnum.INVALID)) {
			this.cssClass = "text-danger";
			this.state = "已关闭";
		}

		this.name = rule.getName();
		this.cardName = rule.getCard().getName();
		this.category = rule.getRuleCategory().getName();
		if (rule.getScore() != null)
			this.score = rule.getScore();
		if (rule.getRate() != null)
			this.rate = rule.getRate();

		// 未设置生效、失效日期列表显示长期有效
		if (rule.getBeginTime() == null) {
			this.beginTime = "长期有效";
		}
		if (rule.getEndTime() == null) {
			this.endTime = "长期有效";
		}
	}

	public RuleJson(ShopRule rule) {
		this.id = rule.getId();
		Calendar today = Calendar.getInstance();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (rule.getBeginTime() == null && rule.getEndTime() == null) {
			this.cssClass = "text-success";
			this.state = "使用中";
		} else if (rule.getBeginTime() != null && rule.getEndTime() != null) {
			if (rule.getBeginTime().before(today) && rule.getEndTime().after(today)) {
				this.cssClass = "text-success";
				this.state = "使用中";
			} else if (rule.getBeginTime().after(today)) {
				this.cssClass = "text-primary";
				this.state = "未生效";
			} else if (rule.getEndTime().before(today)) {
				this.cssClass = "text-muted";
				this.state = "已过期";
			}
			this.beginTime = format.format(rule.getBeginTime().getTime());
			this.endTime = format.format(rule.getEndTime().getTime());
		}
		if (rule.getValid().equals(ValidEnum.INVALID)) {
			this.cssClass = "text-danger";
			this.state = "已关闭";
		}
		this.name = rule.getName();
		if (rule.getRate() != null)
			this.rate = rule.getRate();
		this.score = rule.getScore();
		// 未设置生效、失效日期列表显示长期有效
		if (rule.getBeginTime() == null) {
			this.beginTime = "长期有效";
		}
		if (rule.getEndTime() == null) {
			this.endTime = "长期有效";
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
