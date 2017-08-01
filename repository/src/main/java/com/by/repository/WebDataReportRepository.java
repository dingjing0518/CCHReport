package com.by.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.by.model.WebsiteData;

public interface WebDataReportRepository extends CrudRepository<WebsiteData, Integer>{
	//主页
		@Query("select month(w.browseTime),sum(w.siteNumber)  from WebsiteData w  where year(w.browseTime)=:year and w.market=0 and w.siteName=0 group by month(w.browseTime) order by w.browseTime asc")
		List<Object[]> findByYear0(@Param("year") int year);
		//品牌
		@Query("select month(w.browseTime),sum(w.siteNumber)  from WebsiteData w  where year(w.browseTime)=:year and w.market=0 and w.siteName=1 group by month(w.browseTime) order by w.browseTime asc")
		List<Object[]> findByYear1(@Param("year") int year);
		//活动
		@Query("select month(w.browseTime),sum(w.siteNumber)  from WebsiteData w  where year(w.browseTime)=:year and w.market=0 and w.siteName=2 group by month(w.browseTime) order by w.browseTime asc")
		List<Object[]> findByYear2(@Param("year") int year);
		//会员
		@Query("select month(w.browseTime),sum(w.siteNumber)  from WebsiteData w  where year(w.browseTime)=:year and w.market=0 and w.siteName=3 group by month(w.browseTime) order by w.browseTime asc")
		List<Object[]> findByYear3(@Param("year") int year);
		//关于我们
		@Query("select month(w.browseTime),sum(w.siteNumber)  from WebsiteData w  where year(w.browseTime)=:year and w.market=0 and w.siteName=4 group by month(w.browseTime) order by w.browseTime asc")
		List<Object[]> findByYear4(@Param("year") int year);
		
		@Query("select day(w.browseTime),w.siteNumber from WebsiteData w where year(w.browseTime)=:year and month(w.browseTime)=:month and w.market=0 and w.siteName=0 order by w.browseTime asc")
		List<Object[]> findByMonthAndDay0(@Param("year") int year,@Param("month") int month);
		
		@Query("select day(w.browseTime),w.siteNumber from WebsiteData w where year(w.browseTime)=:year and month(w.browseTime)=:month and w.market=0 and w.siteName=1 order by w.browseTime asc")
		List<Object[]> findByMonthAndDay1(@Param("year") int year,@Param("month") int month);
		
		@Query("select day(w.browseTime),w.siteNumber from WebsiteData w where year(w.browseTime)=:year and month(w.browseTime)=:month and w.market=0 and w.siteName=2 order by w.browseTime asc")
		List<Object[]> findByMonthAndDay2(@Param("year") int year,@Param("month") int month);
		
		@Query("select day(w.browseTime),w.siteNumber from WebsiteData w where year(w.browseTime)=:year and month(w.browseTime)=:month and w.market=0 and w.siteName=3 order by w.browseTime asc")
		List<Object[]> findByMonthAndDay3(@Param("year") int year,@Param("month") int month);
		
		@Query("select day(w.browseTime),w.siteNumber from WebsiteData w where year(w.browseTime)=:year and month(w.browseTime)=:month and w.market=0 and w.siteName=4 order by w.browseTime asc")
		List<Object[]> findByMonthAndDay4(@Param("year") int year,@Param("month") int month);
		
		@Query("select distinct year(w.browseTime) from WebsiteData w")
		List<Integer> findAllValidYear();
}
