package com.gzhu.bm.repo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.gzhu.bm.entity.BmOrder;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.vo.BmOrderVO;

import tk.mybatis.mapper.common.Mapper;
@MapperScan
public interface BmOrderMapper extends Mapper<BmOrder> { 

	List<BmOrder> selectPage(@Param("record") BmOrder bmOrder, @Param("page") PaginationBean<BmOrderVO> page);

    int selectCount(@Param("record") BmOrder record);
}