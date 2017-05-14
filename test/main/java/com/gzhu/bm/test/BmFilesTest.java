package com.gzhu.bm.test;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.gzhu.bm.Constants;
import com.gzhu.bm.exception.BizException;
import com.gzhu.bm.service.BmFilesService;
import com.gzhu.bm.util.FileUtil;
import com.gzhu.bm.vo.BmFilesVO;
import com.gzhu.bm.vo.ChapterVO;

 

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
		Long start = System.currentTimeMillis();
		List<ChapterVO> list = FileUtil.getChaptersByFilePath("九仙图.txt");

		if(list.size() > 0){
			System.out.println((System.currentTimeMillis() - start) / 3600);
			System.out.println(JSON.toJSON(list).toString());
		}else{
			System.out.println("解析失败!");
		}
	}

	@Test
	public void createFolderTest() {
		File file = new File(Constants.FILE_PATH + File.separator + "20170425231904000");
		file.mkdirs();
	}
}
