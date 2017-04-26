package com.gzhu.bm.repo;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.gzhu.bm.entity.Users;

import tk.mybatis.mapper.common.Mapper;
@MapperScan 
public interface UsersMapper extends Mapper<Users> {
    
	int selectCount(@Param("record")Users users); 
    
    Users selectByUid(@Param("uid")String uid);  
    
    Users findByAccountPassword(@Param("userName")String account,@Param("userPassword") String password);

	Users findByAccount(@Param("userName")String account);
 
}