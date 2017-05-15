package com.gzhu.bm.service;

import java.util.List;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.vo.BookShelfVO;

public interface BookShelfService {
	
	List<BookShelfVO> selectByUid(String uid, PaginationBean<BookShelfVO> page);
	
	int createSelective(BookShelfVO bookShelf);
	
	int deleteById(long id);
	
	int createBatch(List<BookShelfVO> bookShelfs);

	int selectCount(String uid);
}
