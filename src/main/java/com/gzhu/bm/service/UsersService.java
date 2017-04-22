package com.gzhu.bm.service;

import com.gzhu.bm.entity.Users;

public interface UsersService {

	int selectCount(Users users);

	int deleteById(Integer id);

	Users selectByUid(String uid);
	 
	int createSelective(Users users); 
	
	int updateByPrimaryKeySelective(Users record);

	Users findByAccountPassword(String account,String password);
}
