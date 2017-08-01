package com.by.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.by.model.WebsiteData;
import com.by.repository.WebSiteDataRepository;
import com.by.service.WebsiteDataService;
@Service
public class WebsiteDataSeviceImp implements WebsiteDataService {
	@Autowired
	private WebSiteDataRepository  repository;
	@Override
	public List<WebsiteData> findAll() {
		return repository.findAll();
	}
	@Override
	public WebsiteData save(WebsiteData w) {
		return repository.save(w);
	}
	@Override
	public WebsiteData update(WebsiteData newwebsiteData) {
		WebsiteData websiteData = repository.findOne(newwebsiteData.getId());
		websiteData.setMarket(newwebsiteData.getMarket());
		websiteData.setSiteName(newwebsiteData.getSiteName());
		websiteData.setSiteNumber(newwebsiteData.getSiteNumber());
		websiteData.setBrowseTime(newwebsiteData.getBrowseTime());
		return repository.save(websiteData);
	}
	@Override
	public WebsiteData findOne(int id) {
		return repository.findOne(id);
	}
}
