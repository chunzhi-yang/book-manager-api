package com.gzhu.bm.vo;

import java.util.Date;
 
public class BookImgsVO implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Long imgsId;
    private Date createdTime;
    private String filePath;
    
    public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Long getImgsId() {
        return imgsId;
    }

    /**
     * 设置主键ID
     *
     * @param imgsId 主键ID
     */
    public void setImgsId(Long imgsId) {
        this.imgsId = imgsId;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}