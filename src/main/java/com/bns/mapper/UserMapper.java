package com.bns.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bns.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		
		user.setUserId(rs.getString("USER_ID") != null ? rs.getString("USER_ID") : "");
		user.setUsername(rs.getString("USERNAME") != null ? rs.getString("USERNAME") : "");
		user.setPassword(rs.getString("PASSWORD") != null ? rs.getString("PASSWORD") : "");
		user.setStatus(rs.getString("STATUS") != null ? rs.getString("STATUS") : "");
		user.setUserRoleId(rs.getString("USER_ROLE_ID") != null ? rs.getString("USER_ROLE_ID") : "");
		
		return user;
	}

}
