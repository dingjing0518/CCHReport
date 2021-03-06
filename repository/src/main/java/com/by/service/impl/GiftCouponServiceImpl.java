package com.by.service.impl;

import com.by.form.BaseCouponForm;
import com.by.json.GiftCouponJson;
import com.by.model.GiftCoupon;
import com.by.repository.GiftCouponRepository;
import com.by.service.CouponService;
import com.by.service.GiftCouponService;
import com.by.typeEnum.ValidEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yagamai on 15-12-4.
 */
@Service
@Transactional
public class GiftCouponServiceImpl implements GiftCouponService {
    @Autowired
    private GiftCouponRepository repository;
    @Autowired
    private EntityManager em;
    @Autowired
    private CouponService couponService;

    @Override
    @CachePut(value = "coupon", key = "#coupon.id")
    public GiftCoupon save(GiftCoupon coupon) {
        Calendar endTime = coupon.getEndTime();
        Calendar couponEndTime = coupon.getCouponEndTime();
        if (endTime != null) {
            endTime.set(Calendar.HOUR, 23);
            endTime.set(Calendar.MINUTE, 59);
            endTime.set(Calendar.SECOND, 59);
        }
        if (couponEndTime != null) {
            couponEndTime.set(Calendar.HOUR, 23);
            couponEndTime.set(Calendar.MINUTE, 59);
            couponEndTime.set(Calendar.SECOND, 59);
        }
        return repository.save(coupon);
    }

    @Override
    @CachePut(value = "coupon", key = "#coupon.id")
    public GiftCoupon cachePut(GiftCoupon coupon) {
        return coupon;
    }

    @Override
    @CachePut(value = "coupon", key = "#coupon.id")
    public GiftCoupon update(GiftCoupon coupon) {
        GiftCoupon c = findOne(coupon.getId());
        c.setAmount(coupon.getAmount());
        c.setContentImg(coupon.getContentImg());
        c.setCoverImg(coupon.getCoverImg());
        c.setName(coupon.getName());
        c.setSummary(coupon.getSummary());
        c.setDuplicate(coupon.getDuplicate());
        c.setCouponEndTime(coupon.getCouponEndTime());
        c.setBeginTime(coupon.getBeginTime());
        c.setEndTime(coupon.getEndTime());
        return c;
    }

    @Override
    @Transactional(readOnly = true)
    public GiftCoupon findOne(int id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable("coupon")
    public GiftCoupon findOneCache(int id) {
        return repository.findOne(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    @CacheEvict(value = "coupon")
    public GiftCoupon refresh(int id){
        return repository.findOne(id);
    }
    
    @Override
    public GiftCoupon findByIdAndValid(int id, ValidEnum valid) {
        return repository.findByIdAndValid(id, valid);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GiftCoupon> findByValid(ValidEnum valid, Pageable pageable) {
        return repository.findByValid(valid, pageable);
    }

    @Transactional(readOnly = true)
    public Page<GiftCoupon> findAllByValidAndDateBetween(ValidEnum valid, Calendar calendar, Pageable pageable) {
        return repository.findAllByValidAndDateBetween(ValidEnum.VALID, Calendar.getInstance(), pageable);
    }

    @Override
    public Page<GiftCoupon> findAllByValidAndDateBetweenAndNameLike(ValidEnum valid, String name, Calendar calendar, Pageable pageable) {
        return repository.findAllByValidAndDateBetweenAndNameLike(valid, name, Calendar.getInstance(), pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GiftCouponJson> findAll(BaseCouponForm form, Pageable pageable) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<GiftCoupon> c = cb.createQuery(GiftCoupon.class);
        Root<GiftCoupon> root = c.from(GiftCoupon.class);
        c.select(root);
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(GiftCoupon.class)));
        Predicate[] predicates = couponService.getPredicateList(form, root, cb).toArray(new Predicate[0]);
        c.where(predicates);
        c.orderBy(cb.desc(root.get("beginTime")));
        cq.where(predicates);

        List<GiftCoupon> lists = em.createQuery(c).setFirstResult((pageable.getPageNumber()) * pageable.getPageSize())
                .setMaxResults(pageable.getPageSize()).getResultList();
        Long count = em.createQuery(cq).getSingleResult();
        List<GiftCouponJson> results = lists.stream().map(i -> new GiftCouponJson(i)).collect(Collectors.toList());
        return new PageImpl<>(results, pageable, count);
    }

    @Override
    public Long countByName(String name) {
        return repository.countByName(name);
    }

    @Override
    public GiftCoupon findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void delete(GiftCoupon giftCoupon) {
        if (giftCoupon != null)
            repository.delete(giftCoupon);
    }
}
