package com.peazy.customer.model.args;

public class UserUpdateRequest {
	private String uuid;
	private String account;
	private String email;
	private String userName;
	private String userType;
	private Integer isActivated;
	private String employCode;
	private String password;
	private String currentUser;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Integer getIsActivated() {
		return isActivated;
	}
	public void setIsActivated(Integer isActivated) {
		this.isActivated = isActivated;
	}
	public String getEmployCode() {
		return employCode;
	}
	public void setEmployCode(String employCode) {
		this.employCode = employCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	
}
