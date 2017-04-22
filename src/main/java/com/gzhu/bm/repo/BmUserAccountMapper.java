package com.gzhu.bm.repo;

import com.gzhu.bm.entity.BmUserAccount;

import tk.mybatis.mapper.common.Mapper;

public interface BmUserAccountMapper extends Mapper<BmUserAccount> { 

    BmUserAccount selectByUid(BmUserAccount example); 
}