package com.gzhu.bm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmAccountLogService;
import com.gzhu.bm.vo.BmAccountLogVO;

@RestController
@RequestMapping("accountLog")
public class BmAccountLogController {
	@Autowired
	BmAccountLogService bmAccountLogService;
	
	@RequestMapping(value="list/{uid}",method=RequestMethod.POST)
	public ResponseEntity<PaginationBean<BmAccountLogVO>> findByUid(@PathVariable String uid,@RequestParam(value="page",defaultValue="1")int page,@RequestParam(value="pageSize",defaultValue="10")int pageSize){
		BmAccountLogVO bmAccountLog = new BmAccountLogVO();
		bmAccountLog.setUid(uid);
		int count = bmAccountLogService.selectCount(bmAccountLog );
		PaginationBean<BmAccountLogVO> paginationBean = new PaginationBean<BmAccountLogVO>(page, pageSize, count);
		List<BmAccountLogVO> vo = bmAccountLogService.selectPage(bmAccountLog,paginationBean);
		paginationBean.setData(vo);
		return new ResponseEntity<>(paginationBean,HttpStatus.OK);
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public ResponseEntity<Integer> create(@RequestParam BmAccountLogVO bmAccountLogVO){
		Integer result = bmAccountLogService.createSelective(bmAccountLogVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
	 
	
	
}
