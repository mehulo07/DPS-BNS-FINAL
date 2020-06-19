package com.bns.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bns.model.PieChartData;

public class PieChartDataMapper implements RowMapper<PieChartData> {

	@Override
	public PieChartData mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PieChartData pieChartData = new PieChartData(); 
		
		pieChartData.setCategoryId(rs.getString("STOCK_CAT_ID") == null ? "" : rs.getString("STOCK_CAT_ID"));
		pieChartData.setCategoryDesc(rs.getString("STOCK_CAT_DESC") == null ? "" : rs.getString("STOCK_CAT_DESC"));
		pieChartData.setCsUnit(rs.getLong("CS_UNITS"));
		pieChartData.setTotalUnit(rs.getLong("TOTAL_UNITS"));
		pieChartData.setPercentage(rs.getFloat("PERCENTAGE"));
		
		return pieChartData;
	}

}
