package com.bns.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bns.model.StockParameter;

public class StockParameterMapper implements RowMapper<StockParameter> {

	@Override
	public StockParameter mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		StockParameter stockParameter = new StockParameter();
		
		stockParameter.setStockParamId(rs.getString("STOCK_CAT_ID") == null ?  "" : rs.getString("STOCK_CAT_ID"));
		stockParameter.setStockParamName(rs.getString("STOCK_CAT_NAME") == null ?  "" : rs.getString("STOCK_CAT_NAME"));
		stockParameter.setStockParamDesc(rs.getString("STOCK_CAT_DESC") == null ?  "" : rs.getString("STOCK_CAT_DESC"));
		stockParameter.setStatus(rs.getString("STATUS") == null ?  "" : rs.getString("STATUS"));
		stockParameter.setStockParamColorId(rs.getString("STOCK_CAT_COLOR_ID") == null ?  "" : rs.getString("STOCK_CAT_COLOR_ID"));
		
		return stockParameter;
	}

}
