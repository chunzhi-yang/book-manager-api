package com.gzhu.bm.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmAccountLogService;
import com.gzhu.bm.vo.BmAccountLogVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class BmAccountLogTest {
	@Autowired
	BmAccountLogService bmAccountLogService;
	
	 
	@Test
	public void findByUid(){
		BmAccountLogVO bmAccountLog = new BmAccountLogVO();
		bmAccountLog.setUid("20170425231430000");
		int count = bmAccountLogService.selectCount(bmAccountLog );
		PaginationBean<BmAccountLogVO> paginationBean = new PaginationBean<BmAccountLogVO>(1, 10, count);
		List<BmAccountLogVO> vo = bmAccountLogService.selectPage(bmAccountLog,paginationBean);
		paginationBean.setData(vo);
		 
	}
	
	 @Test
	public void create(){
		
		BmAccountLogVO bmAccountLogVO = new BmAccountLogVO();
		bmAccountLogVO.setAfterRemain(BigDecimal.valueOf(100d));
		bmAccountLogVO.setBeforeRemain(BigDecimal.valueOf(90d));
		bmAccountLogVO.setChangeTime(new Date());
		bmAccountLogVO.setChangeType(Byte.parseByte("1"));
		bmAccountLogVO.setPayType(Byte.parseByte("1"));
		bmAccountLogVO.setUid("20170425231430000");
		Integer result = bmAccountLogService.createSelective(bmAccountLogVO ); 
	}
	
	
}
