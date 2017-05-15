package com.gzhu.bm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzhu.bm.entity.BmOrder;
import com.gzhu.bm.repo.BmOrderMapper;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmOrderService;
import com.gzhu.bm.util.BeanMapper;
import com.gzhu.bm.vo.BmOrderVO;

@Service
public class BmOrderServiceImpl implements BmOrderService {

	@Resource
	BmOrderMapper bmOrderMapper;
	 
	@Override
	public int createSelective(BmOrderVO bmOrder) {
		 return bmOrderMapper.insertSelective(BeanMapper.map(bmOrder, BmOrder.class));
	}

	@Override
	public BmOrderVO selectById(long id) {
		return BeanMapper.map(bmOrderMapper.selectByPrimaryKey(id), BmOrderVO.class);
	}

	@Override
	public List<BmOrderVO> selectPage(BmOrderVO bmOrder, PaginationBean<BmOrderVO> page) {
		return BeanMapper.mapList(bmOrderMapper.selectPage(BeanMapper.map(bmOrder, BmOrder.class), page), BmOrderVO.class);
	}

	@Override
	public int selectCount(BmOrderVO bmOrder) {
		return bmOrderMapper.selectCount(BeanMapper.map(bmOrder,BmOrder.class));
	}

	@Override
	public Integer updateOrder(BmOrderVO bmOrderVO) {
		return bmOrderMapper.updateByPrimaryKeySelective(BeanMapper.map(bmOrderVO, BmOrder.class));
	}

	@Override
	public Integer deleteById(Long id) {
		return bmOrderMapper.deleteByPrimaryKey(id);
	}

}
