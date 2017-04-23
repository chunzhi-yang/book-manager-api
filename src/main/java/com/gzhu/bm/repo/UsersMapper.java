package com.gzhu.bm.repo;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.gzhu.bm.entity.Users;

import tk.mybatis.mapper.common.Mapper;
@MapperScan 
public interface UsersMapper extends Mapper<Users> {
    
	int selectCount(Users users); 
    
    Users selectByUid(String uid);  
    
    Users findByAccountPassword(@Param("account")String account,@Param("userPassword") String password);

	Users findByAccount(String account);
 
}