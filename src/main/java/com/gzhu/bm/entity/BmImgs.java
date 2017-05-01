package com.gzhu.bm.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bm_imgs")
public class BmImgs {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "bm_imgs_id")
    private Long bmImgsId;

    /**
     * 文件路径
     */
    @Column(name = "img_path")
    private String imgPath;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 获取主键ID
     *
     * @return bm_imgs_id - 主键ID
     */
    public Long getBmImgsId() {
        return bmImgsId;
    }

    /**
     * 设置主键ID
     *
     * @param bmImgsId 主键ID
     */
    public void setBmImgsId(Long bmImgsId) {
        this.bmImgsId = bmImgsId;
    }

    /**
     * 获取文件路径
     *
     * @return img_path - 文件路径
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * 设置文件路径
     *
     * @param imgPath 文件路径
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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
     * 获取更新时间
     *
     * @return updated_time - 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param updatedTime 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}