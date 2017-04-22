package com.gzhu.bm.repo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzhu.bm.entity.BookShelf;
import com.gzhu.bm.repo.util.PaginationBean;

import tk.mybatis.mapper.common.Mapper;

public interface BookShelfMapper extends Mapper<BookShelf> {
	
    int selectCountByUid(String uid); 

    List<BookShelf> selectByUid(@Param("uid")String uid,@Param("page")PaginationBean page); 
}