package com.gzhu.bm.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bm_user_account")
public class BmUserAccount {
    /**
     * 主键
     */
    @Id
    @Column(name = "bm_user_account_id")
    private Long bmUserAccountId;

    /**
     * uid
     */
    private String uid;

    /**
     * 余额
     */
    private Long remain;

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
     * 获取主键
     *
     * @return bm_user_account_id - 主键
     */
    public Long getBmUserAccountId() {
        return bmUserAccountId;
    }

    /**
     * 设置主键
     *
     * @param bmUserAccountId 主键
     */
    public void setBmUserAccountId(Long bmUserAccountId) {
        this.bmUserAccountId = bmUserAccountId;
    }

    /**
     * 获取uid
     *
     * @return uid - uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置uid
     *
     * @param uid uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取余额
     *
     * @return remain - 余额
     */
    public Long getRemain() {
        return remain;
    }

    /**
     * 设置余额
     *
     * @param remain 余额
     */
    public void setRemain(Long remain) {
        this.remain = remain;
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
     * @return updatedTime - 更新时间
     */
    public Date getupdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param updatedTime 更新时间
     */
    public void setupdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}