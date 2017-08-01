package com.by.service;

import java.util.List;
import com.by.model.MemberData;

public interface MemberDataService {
	List<MemberData> findAll();
	MemberData save(MemberData f);
	MemberData update(MemberData f);	
	MemberData findOne(int id);
}
