package com.gzhu.bm.vo;

import java.util.List;

public class BookShelfListVO implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<BookShelfVO> data;

	public List<BookShelfVO> getData() {
		return data;
	}

	public void setData(List<BookShelfVO> data) {
		this.data = data;
	}

}
