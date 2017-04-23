package com.gzhu.bm.service;

import com.gzhu.bm.entity.Users;
import com.gzhu.bm.vo.UsersVO;

public interface UsersService {

	int selectCount(Users users);

	int deleteById(Integer id);

	Users selectByUid(String uid);
	 
	int createSelective(Users users); 
	
	int updateByPrimaryKeySelective(Users record);

	Users findByAccountPassword(String account,String password);

	UsersVO findByAccount(String account);
}
