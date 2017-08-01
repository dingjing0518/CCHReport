package com.by.service;

import java.util.List;
public interface FanDataReportService {
	List<Object[]> findByYear(int year);
	List<Object[]> findByMonthAndDay(int year,int month);
	List<Object[]> findByYear1( int year);
	List<Object[]> findByMonthAndDay1(int year,int month);
}
