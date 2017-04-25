package com.gzhu.bm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmAccountLogService;
import com.gzhu.bm.vo.BmAccountLogVO;

@Service
public class BmAccountLogServiceImpl implements BmAccountLogService {

	@Override
	public int createSelective(BmAccountLogVO bmAccountLog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BmAccountLogVO> selectByUid(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BmAccountLogVO selectById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCount(BmAccountLogVO bmAccountLog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BmAccountLogVO> selectPage(BmAccountLogVO bmAccountLog, PaginationBean page) {
		// TODO Auto-generated method stub
		return null;
	}

}
