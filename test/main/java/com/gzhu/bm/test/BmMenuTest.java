package com.gzhu.bm.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmMenuService;
import com.gzhu.bm.vo.BmMenuVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class BmMenuTest {

	@Autowired
	BmMenuService bmMenuService;
	
	@Test
	public void testSelect(){
		BmMenuVO queryVO = new BmMenuVO(); 
		int count = bmMenuService.selectCount(queryVO);
		PaginationBean<BmMenuVO> paginationBean= new PaginationBean<BmMenuVO>(1,10,count);
	 
		List<BmMenuVO>  list = new ArrayList<BmMenuVO>();
		if(count > 0){		
			list = bmMenuService.selectPage(queryVO, paginationBean);
		}
		paginationBean.setData(list);
		 
	}
	
	@Test
	public void testInsert(){
		BmMenuVO bmMenuVO = new BmMenuVO();
		bmMenuVO.setIsUnderControl(Byte.parseByte("0"));
		bmMenuVO.setLogisticUrl("app.login");
		bmMenuVO.setMenuCode("A0101");
		bmMenuVO.setMenuName("登录");
		bmMenuVO.setMenuType(Byte.parseByte("0"));
		bmMenuVO.setUrl("app/login");
		Integer result = bmMenuService.createSelective(bmMenuVO ); 
	}
	
	@Test
	public void testUpdate(){
		BmMenuVO bmMenuVO = new BmMenuVO();
		bmMenuVO.setBmMenuId(1l);
		bmMenuVO.setLogisticUrl("login.changepassword");
		bmMenuVO.setUrl("login/changepassword");
		Integer result = bmMenuService.updateMenu(bmMenuVO); 
	}
}
