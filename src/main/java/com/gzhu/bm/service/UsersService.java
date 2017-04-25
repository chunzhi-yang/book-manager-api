package com.gzhu.bm.service;

import com.gzhu.bm.vo.UsersVO;

public interface UsersService {

	int selectCount(UsersVO users);

	int deleteById(Integer id);

	UsersVO selectByUid(String uid);
	 
	int createSelective(UsersVO users); 
	
	int updateByPrimaryKeySelective(UsersVO record);

	UsersVO findByAccountPassword(String account,String password);

	UsersVO findByAccount(String account);
}
