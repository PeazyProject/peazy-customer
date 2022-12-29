package com.peazy.customer.model.args;

public class CreateUserRequest {
	
	private String loginAccount;
	private String loginSecretCode;
	private String userName;
	private String email;

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getLoginSecretCode() {
		return loginSecretCode;
	}

	public void setLoginSecretCode(String loginSecretCode) {
		this.loginSecretCode = loginSecretCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
