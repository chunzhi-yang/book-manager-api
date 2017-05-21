package com.gzhu.bm.repo.util;

import java.util.List;

public class PaginationBean<T> implements java.io.Serializable {
	
	//分页的工具类
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int page;
	
	private int pageSize;
	
	private int total;
	
	private List<SortBean> order;
	
	private List<T> data;
	
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public PaginationBean(int page,int pageSize,int total){
		this.page = page;
		this.pageSize = pageSize;
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<SortBean> getOrder() {
		return order;
	}

	public void setOrder(List<SortBean> order) {
		this.order = order;
	}
	
}
