package com.gzhu.bm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.BookShelf;
import com.gzhu.bm.repo.BookShelfMapper;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BookShelfService;
import com.gzhu.bm.util.BeanMapper;
import com.gzhu.bm.vo.BookShelfVO;
import com.gzhu.bm.vo.BooksVO;
@Service
public class BookShelfServiceImpl implements BookShelfService {
	
	@Resource
	BookShelfMapper bookShelfMapper;
	
	@Override
	public List<BooksVO> selectByUid(String uid, PaginationBean<BooksVO> page) {
		return BeanMapper.mapList(bookShelfMapper.selectByUid(uid, page), BooksVO.class);
	}

	@Override
	public int createSelective(BookShelfVO bookShelf) {
		return bookShelfMapper.insertSelective(BeanMapper.map(bookShelf,BookShelf.class));
	}

	@Override
	public int deleteById(long id) {
		return bookShelfMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int createBatch(List<BookShelfVO> bookShelfs) {
		return bookShelfMapper.createBatch(BeanMapper.mapList(bookShelfs,BookShelf.class));
	}

	@Override
	public int selectCount(String uid) {
		return bookShelfMapper.selectCountByUid(uid);
	}

}
