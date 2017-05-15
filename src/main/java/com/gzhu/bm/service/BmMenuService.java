package com.gzhu.bm.service;

import java.util.List;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.vo.BmMenuVO;

public interface BmMenuService {
	int selectCount(BmMenuVO bmMenu);

	List<BmMenuVO> selectPage(BmMenuVO bmMenu,PaginationBean<BmMenuVO> page);
	 
	Integer createSelective(BmMenuVO bmOrderVO);

	Integer updateMenu(BmMenuVO bmOrderVO);

	List<BmMenuVO> selectByRoleCode(String roleCode); 
}
