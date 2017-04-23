package com.gzhu.bm.service;

import java.util.List;

import com.gzhu.bm.entity.BmMenu;
import com.gzhu.bm.repo.util.PaginationBean;

public interface BmMenuService {
	int selectCount(BmMenu bmMenu);

	List<BmMenu> selectPage(BmMenu bmMenu,PaginationBean page);

	List<BmMenu> selectByUid(String uid); 
}
