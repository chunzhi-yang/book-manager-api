package com.gzhu.bm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzhu.bm.service.BmUserAccountService;
import com.gzhu.bm.vo.BmUserAccountVO;

@RestController
@RequestMapping("userAccount")
public class BmUserAccountController {

	@Autowired
	BmUserAccountService bmUserAccountService;
	
	@RequestMapping(value="{uid}",method=RequestMethod.POST)
	public ResponseEntity<BmUserAccountVO> getList(@PathVariable String uid){ 
		 
		return new ResponseEntity<>(bmUserAccountService.selectByUid(uid),HttpStatus.OK);
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public ResponseEntity<Integer> create(@ModelAttribute BmUserAccountVO bmUserAccountVO){
		Integer result = bmUserAccountService.createSelective(bmUserAccountVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@RequestMapping(value="update",method=RequestMethod.PUT)
	public ResponseEntity<Integer> update(@ModelAttribute BmUserAccountVO bmUserAccountVO){
		Integer result = bmUserAccountService.updateByIdSelective(bmUserAccountVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
}
