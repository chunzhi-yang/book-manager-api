package com.gzhu.bm.vo;

import java.math.BigDecimal;
import java.util.Date;


public class BmAccountLogVO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long bmAccountLogId;
	private Long uid;
	private Byte changeType;
	private BigDecimal beforeRemain;
	private BigDecimal afterRemain;
	private Date changeTime;
	private Byte payType;
	
	public Long getBmAccountLogId() {
		return bmAccountLogId;
	}
	public void setBmAccountLogId(Long bmAccountLogId) {
		this.bmAccountLogId = bmAccountLogId;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Byte getChangeType() {
		return changeType;
	}
	public void setChangeType(Byte changeType) {
		this.changeType = changeType;
	}
	public BigDecimal getBeforeRemain() {
		return beforeRemain;
	}
	public void setBeforeRemain(BigDecimal beforeRemain) {
		this.beforeRemain = beforeRemain;
	}
	public BigDecimal getAfterRemain() {
		return afterRemain;
	}
	public void setAfterRemain(BigDecimal afterRemain) {
		this.afterRemain = afterRemain;
	}
	public Date getChangeTime() {
		return changeTime;
	}
	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
	public Byte getPayType() {
		return payType;
	}
	public void setPayType(Byte payType) {
		this.payType = payType;
	}
	

}