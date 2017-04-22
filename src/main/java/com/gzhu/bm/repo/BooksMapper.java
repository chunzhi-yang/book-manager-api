package com.gzhu.bm.repo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzhu.bm.entity.Books;
import com.gzhu.bm.repo.util.PaginationBean;

import tk.mybatis.mapper.common.Mapper;

public interface BooksMapper extends Mapper<Books> {
    
    List<Books> selectPage(@Param("record")Books books,@Param("page")PaginationBean page);

    int selectCount(Books books); 
}