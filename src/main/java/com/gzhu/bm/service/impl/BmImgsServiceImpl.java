package com.gzhu.bm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.BmImgs;
import com.gzhu.bm.repo.BmImgsMapper;
import com.gzhu.bm.service.BmImgsService;
import com.gzhu.bm.util.BeanMapper;
import com.gzhu.bm.vo.BmImgsVO;
@Service
public class BmImgsServiceImpl implements BmImgsService {
	
	@Resource
	BmImgsMapper bmImgsMapper;
	
	@Override
	public int createSelective(BmImgsVO bmImgsVO) {
		return bmImgsMapper.insertSelective(BeanMapper.map(bmImgsVO, BmImgs.class));
	}

	@Override
	public BmImgsVO selectById(long id) {
		return BeanMapper.map(bmImgsMapper.selectByPrimaryKey(id), BmImgsVO.class);
	}

	@Override
	public Integer updateImg(BmImgsVO bmImgsVO) {
		return bmImgsMapper.updateByPrimaryKeySelective(BeanMapper.map(bmImgsVO, BmImgs.class));
	}

}
