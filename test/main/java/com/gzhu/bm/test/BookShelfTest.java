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
import com.gzhu.bm.service.BookShelfService;
import com.gzhu.bm.vo.BookShelfVO;
import com.gzhu.bm.vo.BooksVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class BookShelfTest {

	@Autowired
	BookShelfService bookShelfService;
	
	@Test
	public void testSelect(){
		int count = bookShelfService.selectCount("20170425230453000");
		PaginationBean<BooksVO> paginationBean= new PaginationBean<BooksVO>(1,10,count);
	 
		List<BooksVO>  list = new ArrayList<BooksVO>();
		if(count > 0){		
			list = bookShelfService.selectByUid("20170425230453000", paginationBean);
		}
		paginationBean.setData(list);
	}
	
	@Test
	public void testCreate(){
		BookShelfVO bookShelfVO = new BookShelfVO();
		bookShelfVO.setBooksId(1l);
		bookShelfVO.setCreatedTime(new Date());
		bookShelfVO.setReadProcess(BigDecimal.valueOf(0.12d));
		bookShelfVO.setUpdatedTime(new Date());
		bookShelfVO.setUid("20170425230453000");
		Integer result = bookShelfService.createSelective(bookShelfVO );
	}
	@Test
	public void testCreateBatch(){
		BookShelfVO bookShelfVO = new BookShelfVO();
		bookShelfVO.setBooksId(3l);
		bookShelfVO.setCreatedTime(new Date());
		bookShelfVO.setReadProcess(BigDecimal.valueOf(0.12d));
		bookShelfVO.setUpdatedTime(new Date());
		bookShelfVO.setUid("20170425230453000");
		List<BookShelfVO> bookShelfVOList = new ArrayList<>();
		
		bookShelfVOList.add(bookShelfVO);
		bookShelfVO = new BookShelfVO();
		bookShelfVO.setBooksId(2l);
		bookShelfVO.setCreatedTime(new Date());
		bookShelfVO.setReadProcess(BigDecimal.valueOf(0.12d));
		bookShelfVO.setUpdatedTime(new Date());
		bookShelfVO.setUid("20170425230453000");
		bookShelfVOList.add(bookShelfVO);
		Integer result = bookShelfService.createBatch(bookShelfVOList );
	}
	
	@Test
	public void testDelete(){
		Integer result = bookShelfService.deleteById(1);
	}
}
