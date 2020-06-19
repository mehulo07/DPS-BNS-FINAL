package com.bns.model;

import java.io.Serializable;

public class UserInfo implements Serializable{

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;

	private String userId;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNo;
	private String deptId;
	
	public UserInfo() {
	}

	public UserInfo(String userId, String firstName, String lastName, String address, String phoneNo, String deptId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.deptId = deptId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", phoneNo=" + phoneNo + ", deptId=" + deptId + "]";
	}

}
