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
import com.gzhu.bm.service.BmMenuService;
import com.gzhu.bm.vo.BmMenuVO;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("menu")
public class BmMenuController {

	@Autowired
	BmMenuService bmMenuService;
	
	@RequestMapping(value="list",method=RequestMethod.POST)
	public ResponseEntity<PaginationBean<BmMenuVO>> getList(@ModelAttribute BmMenuVO queryVO,@RequestParam(value="page",defaultValue="1")int page,@RequestParam(value="pageSize",defaultValue="10")int pageSize){
		
		int count = bmMenuService.selectCount(queryVO);
		PaginationBean<BmMenuVO> paginationBean= new PaginationBean<BmMenuVO>(page,pageSize,count);
	 
		List<BmMenuVO>  list = new ArrayList<BmMenuVO>();
		if(count > 0){		
			list = bmMenuService.selectPage(queryVO, paginationBean);
		}
		paginationBean.setData(list);
		return new ResponseEntity<>(paginationBean,HttpStatus.OK);
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public ResponseEntity<Integer> create(@ModelAttribute BmMenuVO bmOrderVO){
		Integer result = bmMenuService.createSelective(bmOrderVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@RequestMapping(value="update",method=RequestMethod.PUT)
	public ResponseEntity<JSONObject> update(@ModelAttribute BmMenuVO bmOrderVO) {
		Integer result = bmMenuService.updateMenu(bmOrderVO);
		return new ResponseEntity<>(JSONObject.fromObject(result),
				result.intValue() > 0 ? HttpStatus.OK : HttpStatus.SERVICE_UNAVAILABLE);
	}
}
