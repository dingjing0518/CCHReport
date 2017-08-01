package com.by.service;

import java.util.List;
import com.by.model.Fan;
public interface FanService {
	List<Fan> findAll();
	Fan save(Fan f);
	Fan update(Fan f);	
	Fan findOne(int id);
}
