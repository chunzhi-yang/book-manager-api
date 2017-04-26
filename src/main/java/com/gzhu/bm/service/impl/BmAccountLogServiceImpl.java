package com.gzhu.bm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.BmAccountLog;
import com.gzhu.bm.repo.BmAccountLogMapper;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmAccountLogService;
import com.gzhu.bm.vo.BmAccountLogVO;

@Service
public class BmAccountLogServiceImpl implements BmAccountLogService {

	@Resource
	BmAccountLogMapper bmAccountLogMapper;
	private DozerBeanMapper mapper = new DozerBeanMapper();
	@Override
	public int createSelective(BmAccountLogVO bmAccountLog) {
		return bmAccountLogMapper.insertSelective(mapper.map(bmAccountLog,BmAccountLog.class));
	}

	@Override
	public List<BmAccountLogVO> selectByUid(String uid) {
		return null;
	}

	@Override
	public BmAccountLogVO selectById(long id) {
		return mapper.map(bmAccountLogMapper.selectByPrimaryKey(id),BmAccountLogVO.class);
	}

	@Override
	public int selectCount(BmAccountLogVO bmAccountLog) {
		return bmAccountLogMapper.selectCount(mapper.map(bmAccountLog,BmAccountLog.class));
	}

	@Override
	public List<BmAccountLogVO> selectPage(BmAccountLogVO bmAccountLog, PaginationBean<BmAccountLogVO> page) {
		// TODO Auto-generated method stub
		return null;
	}

}
