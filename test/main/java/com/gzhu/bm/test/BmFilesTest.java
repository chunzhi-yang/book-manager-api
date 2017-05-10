package com.gzhu.bm.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.gzhu.bm.exception.BizException;
import com.gzhu.bm.service.BmFilesService;
import com.gzhu.bm.util.FileUtil;
import com.gzhu.bm.vo.BmFilesVO;

 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class BmFilesTest {

	@Autowired
	BmFilesService bmFilesService;
	
 
	
	
	
	@Test
	public void testInsert(){
		BmFilesVO bmFilesVO = new BmFilesVO();
		bmFilesVO.setFilePath("<shshdsp>&scksmmscesmsmsmmcsm");
		bmFilesVO.setCreatedTime(new Date()); 
		Integer result = bmFilesService.createSelective(bmFilesVO );
	}
	
	@Test
	public void testUpdate(){
		BmFilesVO bmFilesVO = new BmFilesVO();
		bmFilesVO.setBmFilesId(1l);
		bmFilesVO.setCreatedTime(new Date());
		Integer result = bmFilesService.updateImg(bmFilesVO);
	}
	
	@Test
	public void testSelect(){
		BmFilesVO result = bmFilesService.selectById(2l); 
		System.out.println(result.getFilePath());
	}
	
	@Test
	public void parseChapter() throws BizException{
		Map<String,Object> map = new HashMap<String,Object>();
		for(int page = 1;page< 3;page++){
			map = FileUtil.getChaptersByFilePath("重生之娇娇女.txt", "20170425231430000");
		}
		System.out.println(JSON.toJSON(map));
		
	}
}
