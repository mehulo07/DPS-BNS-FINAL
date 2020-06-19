package com.bns.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bns.model.RoleMaster;

public class RoleMasterMapper implements RowMapper<RoleMaster> {

	@Override
	public RoleMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoleMaster roleMaster = new RoleMaster();
		
		roleMaster.setRoleId(rs.getString("ROLE_ID") != null ? rs.getString("ROLE_ID") : "");
		roleMaster.setRoleName(rs.getString("ROLE_NAME") != null ? rs.getString("ROLE_NAME") : "");
		roleMaster.setStatus(rs.getString("STATUS") != null ? rs.getString("STATUS") : "");
		
		return roleMaster;
	}

}
