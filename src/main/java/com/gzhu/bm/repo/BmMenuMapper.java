package com.gzhu.bm.repo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.gzhu.bm.entity.BmMenu;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.vo.BmMenuVO;

import tk.mybatis.mapper.common.Mapper;
@MapperScan
public interface BmMenuMapper extends Mapper<BmMenu> {
	
    int selectCount(@Param("record")BmMenu bmMenu); 

    List<BmMenu> selectPage(@Param("record")BmMenu bmMenu,@Param("page")PaginationBean<BmMenuVO> page);
    
    List<BmMenu> selectByUid(@Param("uid")String uid); 
}