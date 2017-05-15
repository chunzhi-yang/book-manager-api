package com.gzhu.bm.controller;

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
import com.gzhu.bm.service.BmOrderService;
import com.gzhu.bm.vo.BmOrderVO;

@RestController
@RequestMapping("order")
public class BmOrderController {

	@Autowired
	BmOrderService bmOrderService;
	
	@RequestMapping("list")
	public ResponseEntity<PaginationBean<BmOrderVO>> list(@ModelAttribute BmOrderVO BmOrderVO,@RequestParam(value="page",defaultValue="1")int page,@RequestParam(value="pageSize",defaultValue="10")int pageSize){
		int count = bmOrderService.selectCount(BmOrderVO);
		PaginationBean<BmOrderVO> paginationBean = new PaginationBean<BmOrderVO>(page,pageSize,count);
		List<BmOrderVO> list = bmOrderService.selectPage(BmOrderVO, paginationBean);
		paginationBean.setData(list);
		return new ResponseEntity<PaginationBean<BmOrderVO>>(paginationBean,HttpStatus.OK);		
	}
	
	@RequestMapping("{id}")
	public ResponseEntity<BmOrderVO> getDetail(@PathVariable Long id){
		return new ResponseEntity<BmOrderVO>(bmOrderService.selectById(id),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public ResponseEntity<Integer> create(@RequestParam BmOrderVO bmOrderVO){
		Integer result = bmOrderService.createSelective(bmOrderVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ResponseEntity<Integer> update(@RequestParam BmOrderVO bmOrderVO){
		Integer result = bmOrderService.updateOrder(bmOrderVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@RequestMapping(value="delete",method=RequestMethod.DELETE)
	public ResponseEntity<Integer> delete(@RequestParam Long id){
		Integer result = bmOrderService.deleteById(id);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
	
}
