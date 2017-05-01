package com.gzhu.bm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.BmFiles;
import com.gzhu.bm.repo.BmFilesMapper;
import com.gzhu.bm.service.BmFilesService;
import com.gzhu.bm.util.BeanMapper;
import com.gzhu.bm.vo.BmFilesVO;
@Service
public class BmFilesServiceImpl implements BmFilesService {
	
	@Resource
	BmFilesMapper BmFilesMapper;
	
	@Override
	public int createSelective(BmFilesVO BmFilesVO) {
		return BmFilesMapper.insertSelective(BeanMapper.map(BmFilesVO, BmFiles.class));
	}

	@Override
	public BmFilesVO selectById(long id) {
		return BeanMapper.map(BmFilesMapper.selectByPrimaryKey(id), BmFilesVO.class);
	}

	@Override
	public Integer updateImg(BmFilesVO BmFilesVO) {
		return BmFilesMapper.updateByPrimaryKeySelective(BeanMapper.map(BmFilesVO, BmFiles.class));
	}

}
