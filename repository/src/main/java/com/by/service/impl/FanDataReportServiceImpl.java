package com.by.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.by.repository.FanDataReportRepositoty;
import com.by.service.FanDataReportService;
@Service
public class FanDataReportServiceImpl implements FanDataReportService {
	@Autowired
	private FanDataReportRepositoty repositoty; 
	@Override
	public List<Object[]> findByYear(int year) {
		return repositoty.findByYear(year);
	}
	@Override
	public List<Object[]> findByMonthAndDay(int year, int month) {
		return repositoty.findByMonthAndDay(year, month);
	}
	@Override
	public List<Object[]> findByYear1(int year) {
	return repositoty.findByYear1(year);
	}
	@Override
	public List<Object[]> findByMonthAndDay1(int year, int month) {
		return repositoty.findByMonthAndDay1(year, month);
	}
	
}
