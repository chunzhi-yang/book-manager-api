package com.gzhu.bm.repo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.gzhu.bm.entity.BmRole;
import com.gzhu.bm.repo.util.PaginationBean;

import tk.mybatis.mapper.common.Mapper;
@MapperScan
public interface BmRoleMapper extends Mapper<BmRole> { 

    List<BmRole> selectByUid(@Param("uid")String uid); 
    
    int selectCount(@Param("record")BmRole record);
    
    List<BmRole> selectPage(@Param("record") BmRole record,@Param("page")PaginationBean page);
}