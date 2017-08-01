package com.by.service;

import com.by.form.BaseCouponForm;
import com.by.model.Rule;
import com.by.model.WebsiteData;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by yagamai on 15-11-26.
 */
public interface RuleService {
	Rule save(Rule rule);

	Rule update(Rule rule);

	Long countByName(String name);

	Rule findByName(String name);

	<T extends Rule> List<Predicate> getPredicateList(BaseCouponForm form, Root<T> root, CriteriaBuilder cb);
}
