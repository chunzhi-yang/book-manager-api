package com.gzhu.bm.repo;

import org.mybatis.spring.annotation.MapperScan;

import com.gzhu.bm.entity.BookImgs;

import tk.mybatis.mapper.common.Mapper;
@MapperScan
public interface BookImgsMapper extends Mapper<BookImgs> { 
	
    BookImgs selectByBookId(Integer bookId);
 
}