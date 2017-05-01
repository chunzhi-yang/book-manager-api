package com.gzhu.bm.service;

import com.gzhu.bm.vo.BmImgsVO;

public interface BmImgsService {
	
	int createSelective(BmImgsVO bmImgsVO); 
	
	BmImgsVO selectById(long id);

	Integer updateImg(BmImgsVO bmImgsVO);
}
