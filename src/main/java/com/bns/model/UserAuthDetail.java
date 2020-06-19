
package com.bns.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserAuthDetail implements Serializable {


	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String userName;
	private String password;
	private List<SimpleGrantedAuthority> roles;
	private boolean active;
    
	public UserAuthDetail() {
		
	}
	
	public UserAuthDetail(String userId, String userName, String password, List<SimpleGrantedAuthority> roles,
			boolean active) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.active = active;
	}



	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<SimpleGrantedAuthority> getRoles() {
		return roles;
	}
	public void setRoles(List<SimpleGrantedAuthority> roles) {
		this.roles = roles;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserAuthDetail [userId=" + userId + ", userName=" + userName + ", password=" + password + ", roles="
				+ roles + ", active=" + active + "]";
	}

}	
	
	
