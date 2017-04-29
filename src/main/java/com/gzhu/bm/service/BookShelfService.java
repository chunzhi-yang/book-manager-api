package com.gzhu.bm.service;

import java.util.List;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.vo.BookShelfVO;
import com.gzhu.bm.vo.BooksVO;

public interface BookShelfService {
	
	List<BooksVO> selectByUid(String uid,PaginationBean<BooksVO> page);
	
	int createSelective(BookShelfVO bookShelf);
	
	int deleteById(long id);
	
	int createBatch(List<BookShelfVO> bookShelfs);

	int selectCount(String uid);
}
