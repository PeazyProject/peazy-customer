package com.peazy.customer.enumerate;

public enum UserErrorCodeEnumImpl implements ErrorCodeEunm {
	USER_NOT_FOUND("0001"),
	PASSWORD_NOT_SAME("0002"),
	USER_IS_NOT_ACTIVATED("0003"),
	;

	private String code;
	
	private UserErrorCodeEnumImpl(String errorCode) {
		this.code = errorCode;
	}

	@Override
	public String getCategory() {
		return "User";
	}

	@Override
	public String getCode() {
		return this.code;
	}

}
