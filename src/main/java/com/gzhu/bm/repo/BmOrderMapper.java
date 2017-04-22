package com.gzhu.bm.repo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzhu.bm.entity.BmOrder;
import com.gzhu.bm.repo.util.PaginationBean;

import tk.mybatis.mapper.common.Mapper;

public interface BmOrderMapper extends Mapper<BmOrder> { 

    List<BmOrder> selectPage(@Param("record")BmOrder bmOrder,@Param("page")PaginationBean page); 

    int selectCount(@Param("record") BmOrder record);
}