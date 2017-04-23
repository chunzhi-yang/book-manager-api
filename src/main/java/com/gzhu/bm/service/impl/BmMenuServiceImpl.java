package com.gzhu.bm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.BmMenu;
import com.gzhu.bm.repo.BmMenuMapper;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmMenuService;

@Service
public class BmMenuServiceImpl implements BmMenuService {

	@Resource
	private BmMenuMapper bmMenuMapper;
	
	@Override
	public int selectCount(BmMenu bmMenu) {
		return bmMenuMapper.selectCount(bmMenu);
	}

	@Override
	public List<BmMenu> selectPage(BmMenu bmMenu, PaginationBean page) {
		return bmMenuMapper.selectPage(bmMenu, page);
	}

	@Override
	public List<BmMenu> selectByUid(String uid) {
		return bmMenuMapper.selectByUid(uid);
	}

}
