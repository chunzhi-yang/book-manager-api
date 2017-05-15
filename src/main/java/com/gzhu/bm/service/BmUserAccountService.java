package com.gzhu.bm.service;

import com.gzhu.bm.vo.BmUserAccountVO;

public interface BmUserAccountService {
	
	int createSelective(BmUserAccountVO bmUserAccount);
	
	BmUserAccountVO selectByUid(String uid);
	
	int updateByIdSelective(BmUserAccountVO bmUserAccount);
}
