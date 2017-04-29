package com.gzhu.bm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BookShelfService;
import com.gzhu.bm.vo.BookShelfVO;
import com.gzhu.bm.vo.BooksVO;

@RestController
@RequestMapping("booksShelf")
public class BookShelfController {

	@Autowired
	BookShelfService bookShelfService;
	
	@RequestMapping(value="list/{uid}",method=RequestMethod.POST)
	public ResponseEntity<PaginationBean<BooksVO>> getList(@PathVariable String uid,@RequestParam(value="page",defaultValue="1")int page,@RequestParam(value="pageSize",defaultValue="10")int pageSize){
		
		int count = bookShelfService.selectCount(uid);
		PaginationBean<BooksVO> paginationBean= new PaginationBean<BooksVO>(page,pageSize,count);
	 
		List<BooksVO>  list = new ArrayList<BooksVO>();
		if(count > 0){		
			list = bookShelfService.selectByUid(uid, paginationBean);
		}
		paginationBean.setData(list);
		return new ResponseEntity<>(paginationBean,HttpStatus.OK);
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public ResponseEntity<Integer> create(@ModelAttribute BookShelfVO bookShelfVO){
		Integer result = bookShelfService.createSelective(bookShelfVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@RequestMapping(value="createBatch",method=RequestMethod.POST)
	public ResponseEntity<Integer> create(@ModelAttribute List<BookShelfVO> BookShelfVOList){
		Integer result = bookShelfService.createBatch(BookShelfVOList);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Integer> delete(@PathVariable Long id){
		Integer result = bookShelfService.deleteById(id);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
}
