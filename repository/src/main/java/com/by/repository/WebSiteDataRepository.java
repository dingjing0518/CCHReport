package com.by.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.by.model.WebsiteData;
public interface WebSiteDataRepository  extends CrudRepository<WebsiteData, Integer>{
	List<WebsiteData> findAll();
}
