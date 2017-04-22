package com.gzhu.bm.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "bm_account_log")
public class BmAccountLog {
    /**
     * 主键
     */
    @Id
    @Column(name = "bm_account_log_id")
    private Long bmAccountLogId;

    /**
     * uid
     */
    private Long uid;

    /**
     * 变动类型0充值1支付
     */
    @Column(name = "change_type")
    private Byte changeType;

    /**
     * 变动前余额
     */
    @Column(name = "before_remain")
    private BigDecimal beforeRemain;

    /**
     * 变动后余额
     */
    @Column(name = "after_remain")
    private BigDecimal afterRemain;

    /**
     * 发生时间
     */
    @Column(name = "change_time")
    private Date changeTime;

    /**
     * 支付方式0微信1支付宝
     */
    @Column(name = "pay_type")
    private Byte payType;

    /**
     * 获取主键
     *
     * @return bm_account_log_id - 主键
     */
    public Long getBmAccountLogId() {
        return bmAccountLogId;
    }

    /**
     * 设置主键
     *
     * @param bmAccountLogId 主键
     */
    public void setBmAccountLogId(Long bmAccountLogId) {
        this.bmAccountLogId = bmAccountLogId;
    }

    /**
     * 获取uid
     *
     * @return uid - uid
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置uid
     *
     * @param uid uid
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取变动类型0充值1支付
     *
     * @return change_type - 变动类型0充值1支付
     */
    public Byte getChangeType() {
        return changeType;
    }

    /**
     * 设置变动类型0充值1支付
     *
     * @param changeType 变动类型0充值1支付
     */
    public void setChangeType(Byte changeType) {
        this.changeType = changeType;
    }

    /**
     * 获取变动前余额
     *
     * @return before_remain - 变动前余额
     */
    public BigDecimal getBeforeRemain() {
        return beforeRemain;
    }

    /**
     * 设置变动前余额
     *
     * @param beforeRemain 变动前余额
     */
    public void setBeforeRemain(BigDecimal beforeRemain) {
        this.beforeRemain = beforeRemain;
    }

    /**
     * 获取变动后余额
     *
     * @return after_remain - 变动后余额
     */
    public BigDecimal getAfterRemain() {
        return afterRemain;
    }

    /**
     * 设置变动后余额
     *
     * @param afterRemain 变动后余额
     */
    public void setAfterRemain(BigDecimal afterRemain) {
        this.afterRemain = afterRemain;
    }

    /**
     * 获取发生时间
     *
     * @return change_time - 发生时间
     */
    public Date getChangeTime() {
        return changeTime;
    }

    /**
     * 设置发生时间
     *
     * @param changeTime 发生时间
     */
    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    /**
     * 获取支付方式0微信1支付宝
     *
     * @return pay_type - 支付方式0微信1支付宝
     */
    public Byte getPayType() {
        return payType;
    }

    /**
     * 设置支付方式0微信1支付宝
     *
     * @param payType 支付方式0微信1支付宝
     */
    public void setPayType(Byte payType) {
        this.payType = payType;
    }
}