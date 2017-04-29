package com.gzhu.bm.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gzhu.bm.service.BookImgsService;
import com.gzhu.bm.vo.BookImgsVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class BookImgsTest {

	@Autowired
	BookImgsService bookImgsService;
	
 
	@Test
	public void testSelect(){
		BookImgsVO result = bookImgsService.selectById(1l); 
		System.out.println(result.getContent());
	}
	
	
	@Test
	public void testInsert(){
		BookImgsVO bookImgsVO = new BookImgsVO();
		bookImgsVO.setContent("<shshdsp>&scksmmscesmsmsmmcsm");
		bookImgsVO.setCreatedTime(new Date()); 
		Integer result = bookImgsService.createSelective(bookImgsVO );
	}
	
	@Test
	public void testUpdate(){
		BookImgsVO bookImgsVO = new BookImgsVO();
		bookImgsVO.setImgsId(1l);
		bookImgsVO.setCreatedTime(new Date());
		Integer result = bookImgsService.updateImg(bookImgsVO);
	}
}
