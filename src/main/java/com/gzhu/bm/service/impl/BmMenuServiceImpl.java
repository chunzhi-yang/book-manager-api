package com.gzhu.bm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.BmMenu;
import com.gzhu.bm.repo.BmMenuMapper;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmMenuService;
import com.gzhu.bm.vo.BmMenuVO;

@Service
public class BmMenuServiceImpl implements BmMenuService {

	@Resource
	private BmMenuMapper bmMenuMapper;
	
	private DozerBeanMapper mapper;
	
	@Override
	public int selectCount(BmMenuVO bmMenu) {
		return bmMenuMapper.selectCount(mapper.map(bmMenu,BmMenu.class));
	}

	@Override
	public List<BmMenuVO> selectPage(BmMenuVO bmMenu, PaginationBean page) {
		List<BmMenu> list =  bmMenuMapper.selectPage(mapper.map(bmMenu,BmMenu.class), page);
		List<BmMenuVO> result = new ArrayList<BmMenuVO>(); 
		for(BmMenu bm: list){
			result.add(mapper.map(bm, BmMenuVO.class));
		}
		return result;
	}

	@Override
	public List<BmMenuVO> selectByUid(String uid) {
		List<BmMenu> list =  bmMenuMapper.selectByUid(uid);
		List<BmMenuVO> result = new ArrayList<BmMenuVO>(); 
		for(BmMenu bm: list){
			result.add(mapper.map(bm, BmMenuVO.class));
		}
		return result;
	}

}
