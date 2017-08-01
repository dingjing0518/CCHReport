package com.by.service;

import java.util.List;
public interface MemberDataReportService {
	List<Object[]> findByYear(int year);
	List<Object[]> findByMonthAndDay(int year,int month);
}
