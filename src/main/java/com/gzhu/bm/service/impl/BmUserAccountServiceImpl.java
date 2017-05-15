package com.gzhu.bm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.BmUserAccount;
import com.gzhu.bm.repo.BmUserAccountMapper;
import com.gzhu.bm.service.BmUserAccountService;
import com.gzhu.bm.util.BeanMapper;
import com.gzhu.bm.vo.BmUserAccountVO;

@Service
public class BmUserAccountServiceImpl implements BmUserAccountService {

	@Resource 
	BmUserAccountMapper  bmUserAccountMapper;
	
	@Override
	public int createSelective(BmUserAccountVO bmUserAccount) {
		return bmUserAccountMapper.insertSelective(BeanMapper.map(bmUserAccount, BmUserAccount.class));
	}

	@Override
	public BmUserAccountVO selectByUid(String uid) {
		return BeanMapper.map(bmUserAccountMapper.selectByUid(uid), BmUserAccountVO.class);
	}

	@Override
	public int updateByIdSelective(BmUserAccountVO bmUserAccount) {
		return bmUserAccountMapper.updateByPrimaryKeySelective(BeanMapper.map(bmUserAccount, BmUserAccount.class));
	}

}
