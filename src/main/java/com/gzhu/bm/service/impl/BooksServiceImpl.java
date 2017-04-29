package com.gzhu.bm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.Books;
import com.gzhu.bm.repo.BooksMapper;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BooksService;
import com.gzhu.bm.util.BeanMapper;
import com.gzhu.bm.vo.BooksVO;
@Service
public class BooksServiceImpl implements BooksService {

	@Resource
	BooksMapper booksMapper;
	
	@Override
	public int createSelective(BooksVO books) {
		return booksMapper.insertSelective(BeanMapper.map(books, Books.class));
	}

	@Override
	public BooksVO selectById(long id) {
		return BeanMapper.map(booksMapper.selectByPrimaryKey(id), BooksVO.class);
	}

	@Override
	public List<BooksVO> selectPage(BooksVO books, PaginationBean<BooksVO> page) {
		return BeanMapper.mapList(booksMapper.selectPage(BeanMapper.map(books, Books.class), page), BooksVO.class);
	}

	@Override
	public int selectCount(BooksVO books) {
		return booksMapper.selectCount(BeanMapper.map(books, Books.class));
	}

	@Override
	public Integer update(BooksVO booksVO) {
		return booksMapper.updateByPrimaryKeySelective(BeanMapper.map(booksVO, Books.class)); 
	}

}
