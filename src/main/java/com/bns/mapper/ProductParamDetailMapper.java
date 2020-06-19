package com.bns.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bns.model.ProductParamDetail;

public class ProductParamDetailMapper implements RowMapper<ProductParamDetail> {

	@Override
	public ProductParamDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductParamDetail productParamDetail = new ProductParamDetail();
		
		productParamDetail.setTransaction_id(rs.getString("TRANSACTION_ID"));
		productParamDetail.setStk_cat_id(rs.getString("STK_CAT_ID"));
		productParamDetail.setStk_cat_name(rs.getString("STOCK_CAT_NAME"));
		productParamDetail.setStk_cat_to(rs.getInt("STK_CAT_TO"));
		
		return productParamDetail;
	
	}

}
