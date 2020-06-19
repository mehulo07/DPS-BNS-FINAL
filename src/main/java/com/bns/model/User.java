package com.bns.model;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String username;
	private String password;
	private String status;
	private String userRoleId;
	
	public User() {
	}

	
	public User(String userId, String username, String password, String status, String userRoleId) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.status = status;
		this.userRoleId = userRoleId;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", status=" + status
				+ ", userRoleId=" + userRoleId + "]";
	}
	
}
