package com.gzhu.bm.service;

import java.util.List;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.vo.BooksVO;

public interface BooksService {
	
	int createSelective(BooksVO books);
	
	BooksVO selectById(long id);
	
	List<BooksVO> selectPage(BooksVO books,PaginationBean page);
	
	int selectCount(BooksVO books);

	Integer update(BooksVO booksVO);
}
