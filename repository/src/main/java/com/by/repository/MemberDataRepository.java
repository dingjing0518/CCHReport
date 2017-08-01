package com.by.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.by.model.MemberData;

public interface MemberDataRepository extends CrudRepository<MemberData, Integer>{
	List<MemberData> findAll();
}
