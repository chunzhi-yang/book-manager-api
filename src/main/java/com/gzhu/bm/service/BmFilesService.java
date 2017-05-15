package com.gzhu.bm.service;

import com.gzhu.bm.vo.BmFilesVO;

public interface BmFilesService {
	
	int createSelective(BmFilesVO BmFilesVO); 
	
	BmFilesVO selectById(long id);

	Integer updateImg(BmFilesVO BmFilesVO);
}
