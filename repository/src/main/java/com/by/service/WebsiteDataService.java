package com.by.service;

import java.util.List;
import com.by.model.WebsiteData;
public interface WebsiteDataService {
	List<WebsiteData> findAll();
	WebsiteData save(WebsiteData w);
	WebsiteData update(WebsiteData websiteData);	
	WebsiteData findOne(int id);
}
