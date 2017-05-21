package com.gzhu.bm.repo;

import com.gzhu.bm.entity.BmFiles;
import tk.mybatis.mapper.common.Mapper;
//创建一个接口继承一个公共接口，可以是它提供一些公用，无需再写
public interface BmFilesMapper extends Mapper<BmFiles> {
}