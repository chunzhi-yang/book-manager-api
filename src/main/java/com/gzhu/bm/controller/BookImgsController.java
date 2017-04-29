package com.gzhu.bm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzhu.bm.service.BookImgsService;
import com.gzhu.bm.vo.BookImgsVO;

@RestController
@RequestMapping("bookImgs")
public class BookImgsController {

	@Autowired
	BookImgsService bookImgsService;
	
 
	@RequestMapping(value="{id}",method=RequestMethod.POST)
	public ResponseEntity<BookImgsVO> create(@PathVariable Long id){
		BookImgsVO result = bookImgsService.selectById(id);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public ResponseEntity<Integer> create(@ModelAttribute BookImgsVO bookImgsVO){
		Integer result = bookImgsService.createSelective(bookImgsVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@RequestMapping(value="update",method=RequestMethod.PUT)
	public ResponseEntity<Integer> update(@ModelAttribute BookImgsVO bookImgsVO){
		Integer result = bookImgsService.updateImg(bookImgsVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
}
