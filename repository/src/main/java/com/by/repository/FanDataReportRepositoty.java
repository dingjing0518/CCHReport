package com.by.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.by.model.Fan;
public interface FanDataReportRepositoty extends CrudRepository<Fan, Integer>{
	//粉丝数据 
	@Query("select month(f.browseTime),sum(f.fanNumber), max(f.fanNumbers) from Fan f  where year(f.browseTime)=:year and f.market=0 group by month(f.browseTime) order by f.browseTime asc")
	List<Object[]> findByYear(@Param("year") int year);
	@Query("select day(f.browseTime),f.fanNumber,f.fanNumbers from Fan f  where year(f.browseTime)=:year and month(f.browseTime)=:month and f.market=0 order by f.browseTime asc")
	List<Object[]> findByMonthAndDay(@Param("year") int year,@Param("month") int month);
	//粉丝来源
	@Query("select month(f.browseTime),max(f.wfanNumbers),max(f.fanNumbers)-max(f.wfanNumbers) from Fan f  where year(f.browseTime)=:year and f.market=0 group by month(f.browseTime) order by f.browseTime asc")
	List<Object[]> findByYear1(@Param("year") int year);
	@Query("select day(f.browseTime),f.wfanNumbers,f.fanNumbers-f.wfanNumbers from Fan f  where year(f.browseTime)=:year and month(f.browseTime)=:month and f.market=0 order by f.browseTime asc")
	List<Object[]> findByMonthAndDay1(@Param("year") int year,@Param("month") int month);
}
