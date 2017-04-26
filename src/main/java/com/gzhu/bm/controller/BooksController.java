package com.gzhu.bm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BooksService;
import com.gzhu.bm.vo.BooksVO;

@RestController
@RequestMapping("books")
public class BooksController {

	@Autowired
	BooksService booksService;
	
	@RequestMapping(value="list",method=RequestMethod.POST)
	public ResponseEntity<PaginationBean<BooksVO>> getList(@ModelAttribute BooksVO booksVO,@RequestParam(value="page",defaultValue="1")int page,@RequestParam(value="pageSize",defaultValue="10")int pageSize){
		
		int count = booksService.selectCount(booksVO);
		PaginationBean<BooksVO> paginationBean= new PaginationBean<BooksVO>(page,pageSize,count);
	 
		List<BooksVO>  list = new ArrayList<BooksVO>();
		if(count > 0){		
			list = booksService.selectPage(booksVO, paginationBean);
		}
		paginationBean.setData(list);
		return new ResponseEntity<>(paginationBean,HttpStatus.OK);
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public ResponseEntity<Integer> create(@ModelAttribute BooksVO booksVO){
		Integer result = booksService.createSelective(booksVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
	

	@RequestMapping(value="update",method=RequestMethod.PUT)
	public ResponseEntity<Integer> update(@ModelAttribute BooksVO booksVO){
		Integer result = booksService.update(booksVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
}
