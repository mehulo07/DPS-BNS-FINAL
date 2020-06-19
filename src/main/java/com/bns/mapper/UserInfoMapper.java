
package com.bns.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bns.model.UserInfo;

public class UserInfoMapper implements RowMapper<UserInfo> {

	@Override
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserInfo userInfo = new UserInfo();
		
		userInfo.setUserId(rs.getString("USER_ID") == null ? "" : rs.getString("USER_ID"));
		userInfo.setFirstName(rs.getString("USER_FIRSTNAME") == null ? "" : rs.getString("USER_FIRSTNAME"));
		userInfo.setLastName(rs.getString("USER_LASTNAME") == null ? "" : rs.getString("USER_LASTNAME"));
		userInfo.setAddress(rs.getString("ADDRESS") == null ? "" : rs.getString("ADDRESS"));
		userInfo.setPhoneNo(rs.getString("PHONE_NO") == null ? "" : rs.getString("PHONE_NO"));
		userInfo.setDeptId(rs.getString("DEPT_ID") == null ? "" : rs.getString("DEPT_ID"));
		
		return userInfo;
	}

}
