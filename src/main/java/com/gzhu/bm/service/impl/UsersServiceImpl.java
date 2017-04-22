package com.gzhu.bm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gzhu.bm.entity.Users;
import com.gzhu.bm.repo.UsersMapper;
import com.gzhu.bm.service.UsersService;

public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public int selectCount(Users users) {
		return usersMapper.selectCount(users);
	}

	@Override
	public int deleteById(Integer id) {
		return usersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Users selectByUid(String uid) {
		return usersMapper.selectByUid(uid);
	}

	@Override
	public int createSelective(Users users) {
		return usersMapper.insertSelective(users);
	}

	@Override
	public int updateByPrimaryKeySelective(Users record) {		 
		return usersMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Users findByAccountPassword(String account, String password) {
		return usersMapper.findByAccountPassword(account, password);
	}

}
