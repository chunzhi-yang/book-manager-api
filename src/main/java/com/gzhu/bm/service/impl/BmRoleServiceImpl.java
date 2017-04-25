package com.gzhu.bm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.BmMenu;
import com.gzhu.bm.entity.BmRole;
import com.gzhu.bm.repo.BmRoleMapper;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmRoleService;
import com.gzhu.bm.vo.BmMenuVO;
import com.gzhu.bm.vo.BmRoleVO;

@Service
public class BmRoleServiceImpl implements BmRoleService {
	
	@Resource
	private BmRoleMapper bmRoleMapper;
	
	private DozerBeanMapper mapper = new DozerBeanMapper();
	
	@Override
	public List<BmRoleVO> selectByUid(String uid) {
		 
		List<BmRole> list =  bmRoleMapper.selectByUid(uid);
		List<BmRoleVO> result = new ArrayList<BmRoleVO>(); 
		for(BmRole bm: list){
			result.add(mapper.map(bm, BmRoleVO.class));
		}
		return result;
	}

	@Override
	public int selectCount(BmRoleVO record) {
		return bmRoleMapper.selectCount(mapper.map(record,BmRole.class));
	}

	@Override
	public List<BmRoleVO> selectPage(BmRoleVO record, PaginationBean page) {
		List<BmRole> list = bmRoleMapper.selectPage(mapper.map(record,BmRole.class), page);
		List<BmRoleVO> result = new ArrayList<BmRoleVO>();
		for(BmRole bm:list){
			result.add(mapper.map(bm, BmRoleVO.class));
		}
		return result;
	}

}
