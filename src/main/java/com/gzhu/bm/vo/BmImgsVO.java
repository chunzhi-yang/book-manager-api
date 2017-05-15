package com.gzhu.bm.vo;

import java.util.Date;

public class BmImgsVO implements java.io.Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long bmImgsId;
	 
	 private String imgPath;
	 
	 private Date createdTime;
	 
	 private Date updatedTime;

	public Long getBmImgsId() {
		return bmImgsId;
	}

	public void setBmImgsId(Long bmImgsId) {
		this.bmImgsId = bmImgsId;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
}
