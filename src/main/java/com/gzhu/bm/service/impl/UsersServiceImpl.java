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

	@Override
	public UsersVO findByAccount(String account) {
		 Users user = usersMapper.findByAccount(account);
		 return  new DozerBeanMapper().map(user, UsersVO.class);
	}

}
