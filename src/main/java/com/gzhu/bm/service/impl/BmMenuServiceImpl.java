package com.gzhu.bm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.BmMenu;
import com.gzhu.bm.repo.BmMenuMapper;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmMenuService;
import com.gzhu.bm.util.BeanMapper;
import com.gzhu.bm.vo.BmMenuVO;

@Service
public class BmMenuServiceImpl implements BmMenuService {

	@Resource
	private BmMenuMapper bmMenuMapper;
	
 
	
	@Override
	public int selectCount(BmMenuVO bmMenu) {
		return bmMenuMapper.selectCount(BeanMapper.map(bmMenu,BmMenu.class));
	}

	@Override
	public List<BmMenuVO> selectPage(BmMenuVO bmMenu, PaginationBean<BmMenuVO> page) {
		List<BmMenu> list =  bmMenuMapper.selectPage(BeanMapper.map(bmMenu,BmMenu.class), page);
		List<BmMenuVO> result = new ArrayList<BmMenuVO>(); 
		for(BmMenu bm: list){
			result.add(BeanMapper.map(bm, BmMenuVO.class));
		}
		return result;
	}

 
	@Override
	public Integer createSelective(BmMenuVO bmOrderVO) {
		return bmMenuMapper.insertSelective(BeanMapper.map(bmOrderVO,BmMenu.class));
	}

	@Override
	public Integer updateMenu(BmMenuVO bmOrderVO) {
		return bmMenuMapper.updateByPrimaryKeySelective(BeanMapper.map(bmOrderVO,BmMenu.class));
	}

	@Override
	public List<BmMenuVO> selectByRoleCode(String roleCode) {
		return BeanMapper.mapList(bmMenuMapper.selectByRoleCode(roleCode), BmMenuVO.class);
	}

}
