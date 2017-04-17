package com.gzhu.bm.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "book_imgs")
public class BookImgs {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "imgs_id")
    private Long imgsId;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 图片内容
     */
    private String content;

    /**
     * 获取主键ID
     *
     * @return imgs_id - 主键ID
     */
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