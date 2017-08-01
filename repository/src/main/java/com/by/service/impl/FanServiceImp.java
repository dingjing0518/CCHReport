package com.by.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.by.model.Fan;
import com.by.repository.FanRepository;
import com.by.service.FanService;
@Service
public class FanServiceImp implements FanService {
	@Autowired
	private FanRepository  repository;
	@Override
	public List<Fan> findAll() {
		return repository.findAll();
	}

	@Override
	public Fan save(Fan f) {
		return repository.save(f);
	}

	@Override
	public Fan update(Fan f) {
		Fan fan=repository.findOne(f.getId());
		fan.setBrowseTime(f.getBrowseTime());
		fan.setFanNumber(f.getFanNumber());
		fan.setFanNumbers(f.getFanNumbers());
		fan.setMarket(f.getMarket());
		fan.setWfanNumbers(f.getWfanNumbers());
		return repository.save(fan);
	}

	@Override
	public Fan findOne(int id) {
		return repository.findOne(id);
	}

}
