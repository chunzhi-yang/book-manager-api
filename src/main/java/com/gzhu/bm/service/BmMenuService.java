package com.gzhu.bm.service;

import java.util.List;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.vo.BmMenuVO;

public interface BmMenuService {
	int selectCount(BmMenuVO bmMenu);

	List<BmMenuVO> selectPage(BmMenuVO bmMenu,PaginationBean page);

	List<BmMenuVO> selectByUid(String uid); 
}
