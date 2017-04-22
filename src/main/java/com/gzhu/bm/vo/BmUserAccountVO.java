package com.gzhu.bm.vo;

import java.util.Date;
 
public class BmUserAccountVO implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
    private Long bmUserAccountId;
    private String uid;
    private Double remain;
    private Date createdTime;
    private Date uodatedTime;

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
    public Double getRemain() {
        return remain;
    }

    /**
     * 设置余额
     *
     * @param remain 余额
     */
    public void setRemain(Double remain) {
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
     * @return uodated_time - 更新时间
     */
    public Date getUodatedTime() {
        return uodatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param uodatedTime 更新时间
     */
    public void setUodatedTime(Date uodatedTime) {
        this.uodatedTime = uodatedTime;
    }
}