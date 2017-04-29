package com.gzhu.bm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.BookImgs;
import com.gzhu.bm.repo.BookImgsMapper;
import com.gzhu.bm.service.BookImgsService;
import com.gzhu.bm.util.BeanMapper;
import com.gzhu.bm.vo.BookImgsVO;
@Service
public class BookImgsServiceImpl implements BookImgsService {
	
	@Resource
	BookImgsMapper bookImgsMapper;
	
	@Override
	public int createSelective(BookImgsVO bookImgs) {
		return bookImgsMapper.insertSelective(BeanMapper.map(bookImgs, BookImgs.class));
	}

	@Override
	public BookImgsVO selectById(long id) {
		return BeanMapper.map(bookImgsMapper.selectByPrimaryKey(id), BookImgsVO.class);
	}

	@Override
	public Integer updateImg(BookImgsVO bookImgsVO) {
		return bookImgsMapper.updateByPrimaryKeySelective(BeanMapper.map(bookImgsVO, BookImgs.class));
	}

}
