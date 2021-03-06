package com.by.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.by.model.RuleCategory;
import com.by.repository.CategoryRepository;
import com.by.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Optional<RuleCategory> findOne(int id) {
		return repository.findById(id);
	}

}
