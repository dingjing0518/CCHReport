package com.by.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.by.model.MemberData;

public interface MemberDataReportRepositoty extends CrudRepository<MemberData, Integer>{
	//会员数据
	@Query("select month(m.browseTime),sum(m.memberNumber), max(m.membersNumbers) from MemberData m  where year(m.browseTime)=:year and m.market=0 group by month(m.browseTime) order by m.browseTime asc")
	List<Object[]> findByYear(@Param("year") int year);
	@Query("select day(m.browseTime),m.memberNumber,m.membersNumbers from MemberData m  where year(m.browseTime)=:year and month(m.browseTime)=:month and m.market=0 order by m.browseTime asc")
	List<Object[]> findByMonthAndDay(@Param("year") int year,@Param("month") int month);
}
