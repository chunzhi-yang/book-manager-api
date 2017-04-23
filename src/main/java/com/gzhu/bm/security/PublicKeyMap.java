package com.gzhu.bm.security;

public class PublicKeyMap {
	private String modules;
	private String exponent;
	public String getModules() {
		return modules;
	}
	public void setModules(String modules) {
		this.modules = modules;
	}
	public String getExponent() {
		return exponent;
	}
	public void setExponent(String exponent) {
		this.exponent = exponent;
	}
	@Override
	public String toString() {
		return "PublicKeyMap [modules=" + modules + ", exponent=" + exponent + "]";
	}
	
}
