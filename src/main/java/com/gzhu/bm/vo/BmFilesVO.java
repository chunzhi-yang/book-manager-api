package com.gzhu.bm.vo;

import java.util.Date;

public class BmFilesVO implements java.io.Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long bmFilesId;
	 
	 private String filePath;
	 
	 private Date createdTime;
	 
	 private Date updatedTime;

	 

	public Long getBmFilesId() {
		return bmFilesId;
	}

	public void setBmFilesId(Long bmFilessId) {
		this.bmFilesId = bmFilessId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
