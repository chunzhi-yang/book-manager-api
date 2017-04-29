package com.gzhu.bm.test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmOrderService;
import com.gzhu.bm.vo.BmOrderVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class BmOrderTest {

	@Autowired
	BmOrderService bmOrderService;
	
	@Test
	public void testSelect(){
		BmOrderVO bmOrderVO = new BmOrderVO();
		bmOrderVO.setUid("20170425231430000");
		int count = bmOrderService.selectCount(bmOrderVO);
		PaginationBean<BmOrderVO> paginationBean = new PaginationBean<BmOrderVO>(1,10,count);
		List<BmOrderVO> list = bmOrderService.selectPage(bmOrderVO, paginationBean);
		paginationBean.setData(list);
		 
	}
	@Test
	public void testSelectById(){
		bmOrderService.selectById(1);
	}
	
	
	@Test
	public void testInsert(){
		BmOrderVO bmOrderVO = new BmOrderVO();
		bmOrderVO.setUid("20170429231430000");
		bmOrderVO.setBooksId(1l);
		bmOrderVO.setOrderChapters(10l);
		bmOrderVO.setOrderDate(new Date());
		bmOrderVO.setOrderFee(BigDecimal.valueOf(1.2));
		bmOrderVO.setOrderType((byte)1);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 5);
		bmOrderVO.setPayTime(cal.getTime());
		bmOrderVO.setPayType((byte)1); 
		Integer result = bmOrderService.createSelective(bmOrderVO);
	}
	
	@Test
	public void testUpdate(){
		BmOrderVO bmOrderVO = new BmOrderVO();
		bmOrderVO.setBmOrderId(1l);
		bmOrderVO.setOrderChapters(100l);
		bmOrderVO.setBooksId(2l);
		Integer result = bmOrderService.updateOrder(bmOrderVO);
	}
	
	@Test
	public void testDelete(){
		Integer result = bmOrderService.deleteById(2l);
	}
}
