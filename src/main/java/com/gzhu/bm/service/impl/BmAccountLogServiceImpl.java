package com.gzhu.bm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.BmAccountLog;
import com.gzhu.bm.repo.BmAccountLogMapper;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmAccountLogService;
import com.gzhu.bm.util.BeanMapper;
import com.gzhu.bm.vo.BmAccountLogVO;

@Service
public class BmAccountLogServiceImpl implements BmAccountLogService {

	@Resource
	BmAccountLogMapper bmAccountLogMapper;
	
	 
	
	@Override
	public int createSelective(BmAccountLogVO bmAccountLog) {
		return bmAccountLogMapper.insertSelective(BeanMapper.map(bmAccountLog,BmAccountLog.class));
	}

	@Override
	public List<BmAccountLogVO> selectByUid(String uid) {
		return BeanMapper.mapList(bmAccountLogMapper.selectByUid(uid),BmAccountLogVO.class);
	}

	@Override
	public BmAccountLogVO selectById(long id) {
		return BeanMapper.map(bmAccountLogMapper.selectByPrimaryKey(id),BmAccountLogVO.class);
	}

	@Override
	public int selectCount(BmAccountLogVO bmAccountLog) {
		return bmAccountLogMapper.selectCount(BeanMapper.map(bmAccountLog,BmAccountLog.class));
	}

	@Override
	public List<BmAccountLogVO> selectPage(BmAccountLogVO bmAccountLog, PaginationBean<BmAccountLogVO> page) {
		return BeanMapper.mapList(bmAccountLogMapper.selectByPage(BeanMapper.map(bmAccountLog,BmAccountLog.class),page),BmAccountLogVO.class);
	}

}
