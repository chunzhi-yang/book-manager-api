package com.gzhu.bm.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmRoleService;
import com.gzhu.bm.vo.BmRoleVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class BmRoleTest {

	@Autowired
	BmRoleService bmRoleService;
	
	@Test
	public void testSelect(){
		BmRoleVO bmRoleVO = new BmRoleVO(); 
		int count = bmRoleService.selectCount(bmRoleVO);
		PaginationBean<BmRoleVO> paginationBean= new PaginationBean<BmRoleVO>(2,1,count);
	 
		List<BmRoleVO>  list = new ArrayList<BmRoleVO>();
		if(count > 0){		
			list = bmRoleService.selectPage(bmRoleVO, paginationBean);
		}
		paginationBean.setData(list);
		 
	}
	
	@Test
	public void testInsert(){
		BmRoleVO bmRoleVO = new BmRoleVO(); 
		bmRoleVO.setCreatedTime(new Date());
		bmRoleVO.setRoleCode("R001");
		bmRoleVO.setRoleName("test"); 
		Integer result = bmRoleService.createSelective(bmRoleVO);
	}
	
	@Test
	public void testUpdate(){
		BmRoleVO bmRoleVO = new BmRoleVO(); 
		bmRoleVO.setCreatedTime(new Date());
		bmRoleVO.setBmRoleId(1l); 
	 
		Integer result = bmRoleService.updateRole(bmRoleVO);
	}
}
