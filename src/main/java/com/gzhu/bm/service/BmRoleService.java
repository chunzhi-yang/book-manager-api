package com.gzhu.bm.service;

import java.util.List;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.vo.BmRoleVO;

public interface BmRoleService {
	List<BmRoleVO> selectByUid(String uid); 
	    
	int selectCount(BmRoleVO record);
	    
	List<BmRoleVO> selectPage(BmRoleVO record,PaginationBean<BmRoleVO> page);

	Integer createSelective(BmRoleVO bmRoleVO);

	Integer updateRole(BmRoleVO bmRoleVO);
}
