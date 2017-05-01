package com.gzhu.bm.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BooksService;
import com.gzhu.bm.vo.BooksVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class BooksTest {

	@Autowired
	BooksService booksService;
	
	@Test 
	public void testSelect(){
		BooksVO booksVO = new BooksVO();
		int count = booksService.selectCount(booksVO );
		PaginationBean<BooksVO> paginationBean= new PaginationBean<BooksVO>(1,10,count);
	 
		List<BooksVO>  list = new ArrayList<BooksVO>();
		if(count > 0){		
			list = booksService.selectPage(booksVO, paginationBean);
		}
		paginationBean.setData(list);
	}
	
	@Test 
	public void testInsert(){
		BooksVO booksVO = new BooksVO();
		booksVO.setAuthor("chunzhi");
		booksVO.setBookName("有神1111");
		booksVO.setCategory(Byte.valueOf("2"));
		booksVO.setFilePath("111.txt");
		booksVO.setCost(BigDecimal.valueOf(0.1d)); 
		booksVO.setDescription("大话已有");
		booksVO.setFreeChapters(1l);
		booksVO.setHotScore(8l);
		booksVO.setImgPath("111.jpg");
		booksVO.setOrderDiscount((short) 8);
		Integer result = booksService.createSelective(booksVO );
	}
	

	@Test 
	public void testUpdate(){
		BooksVO booksVO = new BooksVO();
		booksVO.setBooksId(1l);
		booksVO.setAuthor("chunzhi01.yang");
		Integer result = booksService.update(booksVO);
	}
}
