package com.by.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.by.repository.MenuDataReportRepositoty;
import com.by.service.MenuDataReportService;
@Service
public class MenuDataReportServiceImpl implements MenuDataReportService {
	@Autowired
	private MenuDataReportRepositoty repositoty;
	@Override
	public String findByMemu0(String startTime, String endTime) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate=sdf.parse(startTime);
			Date endDate=sdf.parse(endTime);
			Calendar startDay=Calendar.getInstance();
			Calendar endtDay=Calendar.getInstance();
			startDay.setTime(startDate);
			endtDay.setTime(endDate);
			return repositoty.findByMemu0(startDay, endtDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String findByMemu1(String startTime, String endTime) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate=sdf.parse(startTime);
			Date endDate=sdf.parse(endTime);
			Calendar startDay=Calendar.getInstance();
			Calendar endtDay=Calendar.getInstance();
			startDay.setTime(startDate);
			endtDay.setTime(endDate);
			return repositoty.findByMemu1(startDay, endtDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String findByMemu2(String startTime, String endTime) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate=sdf.parse(startTime);
			Date endDate=sdf.parse(endTime);
			Calendar startDay=Calendar.getInstance();
			Calendar endtDay=Calendar.getInstance();
			startDay.setTime(startDate);
			endtDay.setTime(endDate);
			return repositoty.findByMemu2(startDay, endtDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String findByMemu3(String startTime, String endTime) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate=sdf.parse(startTime);
			Date endDate=sdf.parse(endTime);
			Calendar startDay=Calendar.getInstance();
			Calendar endtDay=Calendar.getInstance();
			startDay.setTime(startDate);
			endtDay.setTime(endDate);
			return repositoty.findByMemu3(startDay, endtDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String findByMemu4(String startTime, String endTime) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate=sdf.parse(startTime);
			Date endDate=sdf.parse(endTime);
			Calendar startDay=Calendar.getInstance();
			Calendar endtDay=Calendar.getInstance();
			startDay.setTime(startDate);
			endtDay.setTime(endDate);
			return repositoty.findByMemu4(startDay, endtDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String findByMemu5(String startTime, String endTime) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate=sdf.parse(startTime);
			Date endDate=sdf.parse(endTime);
			Calendar startDay=Calendar.getInstance();
			Calendar endtDay=Calendar.getInstance();
			startDay.setTime(startDate);
			endtDay.setTime(endDate);
			return repositoty.findByMemu5(startDay, endtDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String findByMemu6(String startTime, String endTime) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate=sdf.parse(startTime);
			Date endDate=sdf.parse(endTime);
			Calendar startDay=Calendar.getInstance();
			Calendar endtDay=Calendar.getInstance();
			startDay.setTime(startDate);
			endtDay.setTime(endDate);
			return repositoty.findByMemu6(startDay, endtDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
