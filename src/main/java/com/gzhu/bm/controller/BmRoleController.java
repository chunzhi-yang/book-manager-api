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
import com.gzhu.bm.service.BmRoleService;
import com.gzhu.bm.vo.BmRoleVO;

@RestController
@RequestMapping("role")
public class BmRoleController {

	@Autowired
	BmRoleService bmRoleService;
	
	@RequestMapping(value="list",method=RequestMethod.POST)
	public ResponseEntity<PaginationBean<BmRoleVO>> getList(@ModelAttribute BmRoleVO bmRoleVO,@RequestParam(value="page",defaultValue="1")int page,@RequestParam(value="pageSize",defaultValue="10")int pageSize){
		
		int count = bmRoleService.selectCount(bmRoleVO);
		PaginationBean<BmRoleVO> paginationBean= new PaginationBean<BmRoleVO>(page,pageSize,count);
	 
		List<BmRoleVO>  list = new ArrayList<BmRoleVO>();
		if(count > 0){		
			list = bmRoleService.selectPage(bmRoleVO, paginationBean);
		}
		paginationBean.setData(list);
		return new ResponseEntity<>(paginationBean,HttpStatus.OK);
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public ResponseEntity<Integer> create(@ModelAttribute BmRoleVO bmRoleVO){
		Integer result = bmRoleService.createSelective(bmRoleVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@RequestMapping(value="update",method=RequestMethod.PUT)
	public ResponseEntity<Integer> update(@ModelAttribute BmRoleVO bmRoleVO){
		Integer result = bmRoleService.updateRole(bmRoleVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
}
