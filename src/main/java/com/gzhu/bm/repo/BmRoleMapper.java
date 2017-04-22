package com.gzhu.bm.repo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzhu.bm.entity.BmRole;
import com.gzhu.bm.repo.util.PaginationBean;

import tk.mybatis.mapper.common.Mapper;

public interface BmRoleMapper extends Mapper<BmRole> { 

    List<BmRole> selectByUid(String uid); 
    
    int selectCount(BmRole record);
    
    List<BmRole> selectPage(@Param("record") BmRole record,@Param("page")PaginationBean page);
}