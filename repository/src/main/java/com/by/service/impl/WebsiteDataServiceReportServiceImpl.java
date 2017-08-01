package com.by.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.by.repository.WebDataReportRepository;
import com.by.service.WebsiteDataReportService;
@Service
public class WebsiteDataServiceReportServiceImpl implements WebsiteDataReportService {
	@Autowired
	private WebDataReportRepository repository;
	@Override
	public List<Object[]> findByYear0(int year) {
		return repository.findByYear0(year);
	}

	@Override
	public List<Object[]> findByYear1(int year) {
		return repository.findByYear1(year);
	}

	@Override
	public List<Object[]> findByYear2(int year) {
		return repository.findByYear2(year);
	}

	@Override
	public List<Object[]> findByYear3(int year) {
		return repository.findByYear3(year);
	}

	@Override
	public List<Object[]> findByYear4(int year) {
		return repository.findByYear4(year);
	}

	@Override
	public List<Object[]> findByMonthAndDay0(int year, int month) {
		return repository.findByMonthAndDay0(year, month);
	}

	@Override
	public List<Object[]> findByMonthAndDay1(int year, int month) {
		return repository.findByMonthAndDay1(year, month);
	}

	@Override
	public List<Object[]> findByMonthAndDay2(int year, int month) {
		return repository.findByMonthAndDay2(year, month);
	}

	@Override
	public List<Object[]> findByMonthAndDay3(int year, int month) {
		return repository.findByMonthAndDay3(year, month);
	}

	@Override
	public List<Object[]> findByMonthAndDay4(int year, int month) {
		return repository.findByMonthAndDay4(year, month);
	}

	@Override
	public List<Integer> findAllValidYear() {
		return repository.findAllValidYear();
	}

}
