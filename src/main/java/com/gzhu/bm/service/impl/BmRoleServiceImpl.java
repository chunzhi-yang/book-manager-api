package com.gzhu.bm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.BmRole;
import com.gzhu.bm.repo.BmRoleMapper;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmRoleService;

@Service
public class BmRoleServiceImpl implements BmRoleService {
	
	@Resource
	private BmRoleMapper bmRoleMapper;
	
	@Override
	public List<BmRole> selectByUid(String uid) {
		return bmRoleMapper.selectByUid(uid);
	}

	@Override
	public int selectCount(BmRole record) {
		return bmRoleMapper.selectCount(record);
	}

	@Override
	public List<BmRole> selectPage(BmRole record, PaginationBean page) {
		return bmRoleMapper.selectPage(record, page);
	}

}
