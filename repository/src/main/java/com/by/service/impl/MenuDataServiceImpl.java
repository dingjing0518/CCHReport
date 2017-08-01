package com.by.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.by.model.MenuData;
import com.by.repository.MenuDataRepository;
import com.by.service.MenuDataService;
@Service
public class MenuDataServiceImpl implements MenuDataService {
	@Autowired
	private MenuDataRepository repository;
	@Override
	public List<MenuData> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public MenuData save(MenuData w) {
		return repository.save(w);
	}

	@Override
	public MenuData update(MenuData w) {
		MenuData m=repository.findOne(w.getId());
		m.setBrowseTime(w.getBrowseTime());
		m.setMarket(w.getMarket());
		m.setNumber(w.getNumber());
		m.setType(w.getType());
		return repository.save(m);
	}

	@Override
	public MenuData findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public MenuData save1(MenuData w) {
		return repository.save(w);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public MenuData save2(MenuData w) {
		return repository.save(w);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public MenuData save3(MenuData w) {
		return repository.save(w);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public MenuData save4(MenuData w) {
		return repository.save(w);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public MenuData save5(MenuData w) {
		return repository.save(w);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public MenuData save6(MenuData w) {
		return repository.save(w);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void totalsave(MenuData w){
		save(w);
		save1(w);
		save2(w);
		save3(w);
		save4(w);
		save5(w);
		save6(w);
	}
}
