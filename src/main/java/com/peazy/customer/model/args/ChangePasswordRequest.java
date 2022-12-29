package com.peazy.customer.model.args;

public class ChangePasswordRequest {
	private String uuid;
	private String newPassword;
	private String oldPassword;
	private String loginAccount;
	
	public String getUuid() {
		return uuid;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getLoginAccount() {
		return loginAccount;
	}
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}
	
}
