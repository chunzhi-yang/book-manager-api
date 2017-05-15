package com.gzhu.bm.vo;

import java.math.BigDecimal;
import java.util.Date; 
public class BmOrderVO implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
    private Long bmOrderId;
    private Byte orderType;
    private String uid;
    private Long booksId;
    private Date orderDate;
    private Long orderChapters;
    private BigDecimal orderFee;
    private Date payTime;
    private Byte payType;

    public Long getBmOrderId() {
        return bmOrderId;
    }

    /**
     * 设置主键
     *
     * @param bmOrderId 主键
     */
    public void setBmOrderId(Long bmOrderId) {
        this.bmOrderId = bmOrderId;
    }

    /**
     * 获取0单章1全本
     *
     * @return order_type - 0单章1全本
     */
    public Byte getOrderType() {
        return orderType;
    }

    /**
     * 设置0单章1全本
     *
     * @param orderType 0单章1全本
     */
    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
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
     * 获取booksid
     *
     * @return books_id - booksid
     */
    public Long getBooksId() {
        return booksId;
    }

    /**
     * 设置booksid
     *
     * @param booksId booksid
     */
    public void setBooksId(Long booksId) {
        this.booksId = booksId;
    }

    /**
     * 获取下单时间
     *
     * @return order_date - 下单时间
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * 设置下单时间
     *
     * @param orderDate 下单时间
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * 获取购买的章节数
     *
     * @return order_chapters - 购买的章节数
     */
    public Long getOrderChapters() {
        return orderChapters;
    }

    /**
     * 设置购买的章节数
     *
     * @param orderChapters 购买的章节数
     */
    public void setOrderChapters(Long orderChapters) {
        this.orderChapters = orderChapters;
    }

    /**
     * 获取费用
     *
     * @return order_fee - 费用
     */
    public BigDecimal getOrderFee() {
        return orderFee;
    }

    /**
     * 设置费用
     *
     * @param orderFee 费用
     */
    public void setOrderFee(BigDecimal orderFee) {
        this.orderFee = orderFee;
    }

    /**
     * 获取支付时间
     *
     * @return pay_time - 支付时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置支付时间
     *
     * @param payTime 支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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