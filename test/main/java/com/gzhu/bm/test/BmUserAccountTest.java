package com.gzhu.bm.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.gzhu.bm.service.BmUserAccountService;
import com.gzhu.bm.vo.BmUserAccountVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class BmUserAccountTest {

	@Autowired
	BmUserAccountService bmUserAccountService;
	@Test
	public void testSelect(){
		System.out.println(JSON.toJSON(bmUserAccountService.selectByUid("20170425231430000")));
	}
	
	@Test
	public void testInsert(){
		BmUserAccountVO bmUserAccountVO = new BmUserAccountVO();
		bmUserAccountVO.setCreatedTime(new Date());
		bmUserAccountVO.setRemain(BigDecimal.valueOf(1000.00));
		bmUserAccountVO.setUid("20170425231430000");
		bmUserAccountVO.setUpdatedTime(new Date()); 
		Integer result = bmUserAccountService.createSelective(bmUserAccountVO );
	}
	@Test
	public void testUpdate(){
		BmUserAccountVO bmUserAccountVO = new BmUserAccountVO();
		bmUserAccountVO.setBmUserAccountId(1l);
		bmUserAccountVO.setRemain(BigDecimal.valueOf(888.08));
		Integer result = bmUserAccountService.updateByIdSelective(bmUserAccountVO);
	}

	@Test
	public void testMatch() {
		System.out.println(
				Pattern.compile("/book-manager-api/+login/signin").matcher("/book-manager-api/login/signin")
						.matches());

	}
}
