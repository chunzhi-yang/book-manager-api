package com.gzhu.bm.vo;

import java.util.Date;
 
public class BookImgsVO implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Long imgsId;
    private Date createdTime;
    private String content;
    
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

    /**
     * 获取图片内容
     *
     * @return content - 图片内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置图片内容
     *
     * @param content 图片内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}