package com.by.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.by.model.MemberData;
import com.by.repository.MemberDataRepository;
import com.by.service.MemberDataService;

@Service
public class MemberDataServiceImp implements MemberDataService {
	@Autowired
	private MemberDataRepository repository;

	@Override
	public List<MemberData> findAll() {
		return repository.findAll();
	}

	@Override
	public MemberData findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	public MemberData save(MemberData f) {
		return repository.save(f);
	}

	@Override
	public MemberData update(MemberData f) {
		MemberData m = repository.findOne(f.getId());
		m.setBrowseTime(f.getBrowseTime());
		m.setMarket(f.getMarket());
		m.setMemberNumber(f.getMemberNumber());
		m.setMembersNumbers(f.getMembersNumbers());
		return repository.save(m);
	}
}
