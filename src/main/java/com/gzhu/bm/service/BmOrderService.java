package com.gzhu.bm.service;

import java.util.List;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.vo.BmOrderVO;

public interface BmOrderService {
	
	int createSelective(BmOrderVO bmOrder);
	
	BmOrderVO selectById(long id);
	
	List<BmOrderVO> selectPage(BmOrderVO bmOrder,PaginationBean page);
	
	int selectCount(BmOrderVO bmOrder);
	 
}
