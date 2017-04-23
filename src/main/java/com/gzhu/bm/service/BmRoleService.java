package com.gzhu.bm.service;

import java.util.List;

import com.gzhu.bm.entity.BmRole;
import com.gzhu.bm.repo.util.PaginationBean;

public interface BmRoleService {
	List<BmRole> selectByUid(String uid); 
	    
	int selectCount(BmRole record);
	    
	List<BmRole> selectPage(BmRole record,PaginationBean page);
}
