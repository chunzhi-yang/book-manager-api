package com.gzhu.bm.repo.util;

import java.util.List;

public class PaginationBean {
	
	private int page;
	
	private int pageSize;
	
	private int total;
	
	private List<SortBean> order;
	
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