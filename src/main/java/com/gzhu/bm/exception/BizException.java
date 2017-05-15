package com.gzhu.bm.exception;

import org.springframework.core.ErrorCoded;

public class BizException extends Exception implements ErrorCoded{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	public BizException(String errorCode,String msg){
		super(msg);
		this.errorCode = errorCode;		
	}

	@Override
	public String getErrorCode() { 
		return errorCode;
	}

}
