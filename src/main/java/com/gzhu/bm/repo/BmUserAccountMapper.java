package com.gzhu.bm.repo;

import org.mybatis.spring.annotation.MapperScan;

import com.gzhu.bm.entity.BmUserAccount;

import tk.mybatis.mapper.common.Mapper;
@MapperScan
public interface BmUserAccountMapper extends Mapper<BmUserAccount> { 

    BmUserAccount selectByUid(String uid); 
}