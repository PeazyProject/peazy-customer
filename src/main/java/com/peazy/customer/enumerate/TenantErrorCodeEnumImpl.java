package com.peazy.customer.enumerate;

public enum TenantErrorCodeEnumImpl implements ErrorCodeEunm {

	TENANT_NOT_FOUND("0001");
	
	private String code;

	private TenantErrorCodeEnumImpl(String errorCode) {
		this.code = errorCode;
	}

	@Override
	public String getCategory() {
		return "Tenant";
	}

	@Override
	public String getCode() {
		return this.code;
	}

}
