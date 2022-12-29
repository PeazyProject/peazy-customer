package com.peazy.customer.model.response;

import java.util.Date;

public class UserProfile {

	private String uuid;
	private String loginAccount;
	private String userName;
	private String email;
	private String status;
	private String userType;
	private Integer errorCnt;
	private Date lastFailLoginDt;
	private Date lastChangePxdDt;
	private Date lastLoginDt;
	private Date lastLogoutDt;
	private String employCode;
	
	public String getLoginAccount() {
		return loginAccount;
	}
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getErrorCnt() {
		return errorCnt;
	}
	public void setErrorCnt(Integer errorCnt) {
		this.errorCnt = errorCnt;
	}
	public Date getLastFailLoginDt() {
		return lastFailLoginDt;
	}
	public void setLastFailLoginDt(Date lastFailLoginDt) {
		this.lastFailLoginDt = lastFailLoginDt;
	}
	public Date getLastChangePxdDt() {
		return lastChangePxdDt;
	}
	public void setLastChangePxdDt(Date lastChangePxdDt) {
		this.lastChangePxdDt = lastChangePxdDt;
	}
	public Date getLastLoginDt() {
		return lastLoginDt;
	}
	public void setLastLoginDt(Date lastLoginDt) {
		this.lastLoginDt = lastLoginDt;
	}
	public Date getLastLogoutDt() {
		return lastLogoutDt;
	}
	public void setLastLogoutDt(Date lastLogoutDt) {
		this.lastLogoutDt = lastLogoutDt;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
    public String getEmployCode() {
        return employCode;
    }
    public void setEmployCode(String employCode) {
        this.employCode = employCode;
    }
	
	@Override
	public String toString() {
		return "UserProfile [uuid=" + uuid + ", loginAccount=" + loginAccount + ", userName=" + userName + ", email="
				+ email + ", status=" + status + ", userType=" + userType + ", errorCnt=" + errorCnt
				+ ", lastFailLoginDt=" + lastFailLoginDt + ", lastChangePxdDt=" + lastChangePxdDt + ", lastLoginDt="
				+ lastLoginDt + ", lastLogoutDt=" + lastLogoutDt + ", employCode=" + employCode + "]";
	}
	
}
