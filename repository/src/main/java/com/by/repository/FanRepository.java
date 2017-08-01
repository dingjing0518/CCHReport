package com.by.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.by.model.Fan;
public interface FanRepository extends CrudRepository<Fan, Integer>{
	List<Fan> findAll();
}
