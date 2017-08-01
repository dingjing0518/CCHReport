package com.by.service;

import java.util.List;
public interface WebsiteDataReportService {
	//主页
	List<Object[]> findByYear0(int year);
	//品牌
	List<Object[]> findByYear1(int year);
	//活动
	List<Object[]> findByYear2(int year);
	//会员
	List<Object[]> findByYear3(int year);
	//关于我们
	List<Object[]> findByYear4(int year);
	
	List<Object[]> findByMonthAndDay0(int year, int month);
	
	List<Object[]> findByMonthAndDay1(int year, int month);
	
	List<Object[]> findByMonthAndDay2(int year, int month);
	
	List<Object[]> findByMonthAndDay3(int year, int month);
	
	List<Object[]> findByMonthAndDay4(int year, int month);
	List<Integer> findAllValidYear();
}
