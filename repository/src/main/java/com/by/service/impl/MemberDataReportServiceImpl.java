package com.by.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.by.repository.MemberDataReportRepositoty;
import com.by.service.MemberDataReportService;
@Service
public class MemberDataReportServiceImpl implements MemberDataReportService {
	@Autowired
	private MemberDataReportRepositoty repositoty;
	@Override
	public List<Object[]> findByYear(int year) {
		return repositoty.findByYear(year);
	}
	@Override
	public List<Object[]> findByMonthAndDay(int year, int month) {
		return repositoty.findByMonthAndDay(year, month);
	}
}
