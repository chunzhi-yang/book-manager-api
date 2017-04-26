package com.gzhu.bm.repo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.gzhu.bm.entity.BmAccountLog;
import com.gzhu.bm.repo.util.PaginationBean;

import tk.mybatis.mapper.common.Mapper;

@MapperScan
public interface BmAccountLogMapper extends Mapper<BmAccountLog> {
	
    int selectCount(@Param("record")BmAccountLog bmAccountLog); 

    List<BmAccountLog> selectByPage(@Param("record")BmAccountLog bmAccountLog,@Param("page")PaginationBean page);
 
    List<BmAccountLog> selectByUid(@Param("uid")String uid);
}