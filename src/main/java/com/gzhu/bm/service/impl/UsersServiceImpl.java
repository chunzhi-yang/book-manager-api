package com.gzhu.bm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.Users;
import com.gzhu.bm.repo.UsersMapper;
import com.gzhu.bm.service.UsersService;
import com.gzhu.bm.util.BeanMapper;
import com.gzhu.bm.vo.UsersVO;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Resource
	private UsersMapper usersMapper;
	
	 
	
	@Override
	public int selectCount(UsersVO users) {
		return usersMapper.selectCount(BeanMapper.map(users,Users.class));
	}

	@Override
	public int deleteById(Integer id) {
		return usersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public UsersVO selectByUid(String uid) {
		Users user =  usersMapper.selectByUid(uid);
		return  BeanMapper.map(user, UsersVO.class);
	}

	@Override
	public int createSelective(UsersVO users) {
		return usersMapper.insertSelective(BeanMapper.map(users, Users.class));
	}

	@Override
	public int updateByPrimaryKeySelective(UsersVO record) {		 
		return usersMapper.updateByPrimaryKeySelective(BeanMapper.map(record,Users.class));
	}

	@Override
	public UsersVO findByAccountPassword(String account, String password) {
		Users user =  usersMapper.findByAccountPassword(account, password);
		return BeanMapper.map(user, UsersVO.class);
	}

	@Override
	public UsersVO findByAccount(String account) {
		 Users user = usersMapper.findByAccount(account);
		 return  BeanMapper.map(user, UsersVO.class);
	}

}
