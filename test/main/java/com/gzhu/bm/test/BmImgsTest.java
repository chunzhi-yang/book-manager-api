package com.gzhu.bm.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gzhu.bm.service.BmImgsService;
import com.gzhu.bm.vo.BmImgsVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class BmImgsTest {

	@Autowired
	BmImgsService bmImgsService;
	
 
	@Test
	public void testSelect(){
		BmImgsVO result = bmImgsService.selectById(2l); 
		System.out.println(result.getImgPath());
	}
	
	
	@Test
	public void testInsert(){
		BmImgsVO bmImgsVO = new BmImgsVO();
		bmImgsVO.setImgPath("<shshdsp>&scksmmscesmsmsmmcsm");
		bmImgsVO.setCreatedTime(new Date()); 
		Integer result = bmImgsService.createSelective(bmImgsVO );
	}
	
	@Test
	public void testUpdate(){
		BmImgsVO bmImgsVO = new BmImgsVO();
		bmImgsVO.setBmImgsId(1l);
		bmImgsVO.setCreatedTime(new Date());
		Integer result = bmImgsService.updateImg(bmImgsVO);
	}
}
