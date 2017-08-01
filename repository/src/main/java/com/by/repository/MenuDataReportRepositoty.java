package com.by.repository;

import java.util.Calendar;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.by.model.MenuData;

public interface MenuDataReportRepositoty extends CrudRepository<MenuData, Integer> {
	// 如何到达
	@Query("select sum(md.number) from MenuData md  where md.browseTime>=:startTime and md.browseTime<=:endTime and md.market=0 and type=0 order by md.browseTime asc")
	String findByMemu0(@Param("startTime") Calendar startTime, @Param("endTime") Calendar endTime);
	
	// 品牌索引
	@Query("select sum(md.number) from MenuData md  where md.browseTime>=:startTime and md.browseTime<=:endTime and md.market=0 and type=1 order by md.browseTime asc")
	String findByMemu1(@Param("startTime") Calendar startTime, @Param("endTime") Calendar endTime);

	// 最新活动
	@Query("select sum(md.number) from  MenuData md  where md.browseTime>=:startTime and md.browseTime<=:endTime and md.market=0 and type=2 order by md.browseTime asc")
	String findByMemu2(@Param("startTime") Calendar startTime, @Param("endTime") Calendar endTime);

	// 我的会员卡
	@Query("select sum(md.number) from MenuData md  where md.browseTime>=:startTime and md.browseTime<=:endTime and md.market=0 and type=3 order by md.browseTime asc")
	String findByMemu3(@Param("startTime") Calendar startTime, @Param("endTime") Calendar endTime);

	// 积分兑换
	@Query("select sum(md.number) from  MenuData md  where md.browseTime>=:startTime and md.browseTime<=:endTime and md.market=0 and type=4 order by md.browseTime asc")
	String findByMemu4(@Param("startTime") Calendar startTime, @Param("endTime") Calendar endTime);

	// 停车缴费
	@Query("select sum(md.number) from  MenuData md  where md.browseTime>=:startTime and md.browseTime<=:endTime and md.market=0 and type=5 order by md.browseTime asc")
	String findByMemu5(@Param("startTime") Calendar startTime, @Param("endTime") Calendar endTime);

	//我的券库
	@Query("select sum(md.number) from MenuData md  where md.browseTime>=:startTime and md.browseTime<=:endTime and md.market=0 and type=6 order by md.browseTime asc")
	String findByMemu6(@Param("startTime") Calendar startTime, @Param("endTime") Calendar endTime);
}
