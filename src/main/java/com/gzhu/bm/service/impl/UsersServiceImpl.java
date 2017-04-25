package com.gzhu.bm.service.impl;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.Users;
import com.gzhu.bm.repo.UsersMapper;
import com.gzhu.bm.service.UsersService;
import com.gzhu.bm.vo.UsersVO;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Resource
	private UsersMapper usersMapper;
	
	private DozerBeanMapper mapper = new DozerBeanMapper();
	
	@Override
	public int selectCount(UsersVO users) {
		return usersMapper.selectCount(mapper.map(users,Users.class));
	}

	@Override
	public int deleteById(Integer id) {
		return usersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public UsersVO selectByUid(String uid) {
		Users user =  usersMapper.selectByUid(uid);
		return  mapper.map(user, UsersVO.class);
	}

	@Override
	public int createSelective(UsersVO users) {
		return usersMapper.insertSelective(mapper.map(users, Users.class));
	}

	@Override
	public int updateByPrimaryKeySelective(UsersVO record) {		 
		return usersMapper.updateByPrimaryKeySelective(mapper.map(record,Users.class));
	}

	@Override
	public UsersVO findByAccountPassword(String account, String password) {
		Users user =  usersMapper.findByAccountPassword(account, password);
		return mapper.map(user, UsersVO.class);
	}

	@Override
	public UsersVO findByAccount(String account) {
		 Users user = usersMapper.findByAccount(account);
		 return  mapper.map(user, UsersVO.class);
	}

}
