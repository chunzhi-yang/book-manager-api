package com.gzhu.bm.vo; 

public class RSAPublicKeyVo {
	String publicKeyExponent;
	String publicKeyModulus;
	public String getPublicKeyExponent() {
		return publicKeyExponent;
	}
	public void setPublicKeyExponent(String publicKeyExponent) {
		this.publicKeyExponent = publicKeyExponent;
	}
	public String getPublicKeyModulus() {
		return publicKeyModulus;
	}
	public void setPublicKeyModulus(String publicKeyModulus) {
		this.publicKeyModulus = publicKeyModulus;
	}
}
