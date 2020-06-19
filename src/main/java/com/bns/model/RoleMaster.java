package com.bns.model;

import java.io.Serializable;

public class RoleMaster implements Serializable{

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;

	private String roleId;
	private String roleName;
	private String status;
	
	public RoleMaster() {
	}
	
	public RoleMaster(String roleId, String roleName, String status) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.status = status;
	}

	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RoleMaster [roleId=" + roleId + ", roleName=" + roleName + ", status=" + status + "]";
	}
	
}
