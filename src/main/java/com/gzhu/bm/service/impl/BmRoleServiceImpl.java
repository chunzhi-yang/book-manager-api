package com.gzhu.bm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.BmRole;
import com.gzhu.bm.repo.BmRoleMapper;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmRoleService;
import com.gzhu.bm.util.BeanMapper;
import com.gzhu.bm.vo.BmRoleVO;

@Service
public class BmRoleServiceImpl implements BmRoleService {
	
	@Resource
	private BmRoleMapper bmRoleMapper;
	
	 
	@Override
	public List<BmRoleVO> selectByUid(String uid) {
		 
		List<BmRole> list =  bmRoleMapper.selectByUid(uid);
		List<BmRoleVO> result = new ArrayList<BmRoleVO>(); 
		for(BmRole bm: list){
			result.add(BeanMapper.map(bm, BmRoleVO.class));
		}
		return result;
	}

	@Override
	public int selectCount(BmRoleVO record) {
		return bmRoleMapper.selectCount(BeanMapper.map(record,BmRole.class));
	}

	@Override
	public List<BmRoleVO> selectPage(BmRoleVO record, PaginationBean<BmRoleVO> page) {
		List<BmRole> list = bmRoleMapper.selectPage(BeanMapper.map(record,BmRole.class), page);		 
		return BeanMapper.mapList(list, BmRoleVO.class);
	}

	@Override
	public Integer createSelective(BmRoleVO bmRoleVO) {
		return bmRoleMapper.insertSelective(BeanMapper.map(bmRoleVO, BmRole.class));
	}

	@Override
	public Integer updateRole(BmRoleVO bmRoleVO) {
		return bmRoleMapper.updateByPrimaryKeySelective(BeanMapper.map(bmRoleVO, BmRole.class));
	}

}
