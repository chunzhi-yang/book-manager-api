package com.gzhu.bm.service;

import com.gzhu.bm.vo.BookImgsVO;

public interface BookImgsService {
	
	int createSelective(BookImgsVO bookImgs); 
	
	BookImgsVO selectById(long id);
}
