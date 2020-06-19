package com.bns.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bns.model.ColorMaster;

public class ColorMasterMapper implements RowMapper<ColorMaster> {

	@Override
	public ColorMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		ColorMaster colorMaster = new ColorMaster();
		
		colorMaster.setColorId(rs.getString("COLOR_ID") == null ? "" : rs.getString("COLOR_ID"));
		colorMaster.setColorCode(rs.getString("COLOR_CODE") == null ? "" : rs.getString("COLOR_CODE"));
		colorMaster.setColorName(rs.getString("COLOR_NAME") == null ? "" : rs.getString("COLOR_NAME"));
		colorMaster.setStatus(rs.getString("STATUS") == null ? "" : rs.getString("STATUS"));
		
		return colorMaster;
	}

}
