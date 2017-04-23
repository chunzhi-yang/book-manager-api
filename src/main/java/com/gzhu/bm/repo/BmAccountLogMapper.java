package com.gzhu.bm.repo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.gzhu.bm.entity.BmAccountLog;
import com.gzhu.bm.repo.util.PaginationBean;

import tk.mybatis.mapper.common.Mapper;

@MapperScan
public interface BmAccountLogMapper extends Mapper<BmAccountLog> {
	
    int selectCount(BmAccountLog bmAccountLog); 

    List<BmAccountLog> selectByPage(BmAccountLog bmAccountLog,@Param("page")PaginationBean page);
 
}