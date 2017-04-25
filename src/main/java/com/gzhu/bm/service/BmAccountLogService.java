package com.gzhu.bm.service;

import java.util.List;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.vo.BmAccountLogVO;

public interface BmAccountLogService {
	
	int createSelective(BmAccountLogVO bmAccountLog);
	
	List<BmAccountLogVO> selectByUid(String uid);
	
	BmAccountLogVO selectById(long id);
	
	int selectCount(BmAccountLogVO bmAccountLog);
	
	List<BmAccountLogVO> selectPage(BmAccountLogVO bmAccountLog,PaginationBean page);
}
