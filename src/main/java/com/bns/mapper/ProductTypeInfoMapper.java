package com.bns.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bns.model.ProductTypeInfo;

public class ProductTypeInfoMapper implements RowMapper<ProductTypeInfo> {

	@Override
	public ProductTypeInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductTypeInfo productTypeInfo = new ProductTypeInfo();
		
		productTypeInfo.setProductTypeId(rs.getString("PROD_TYPE_ID")== null ? "" : rs.getString("PROD_TYPE_ID"));
		productTypeInfo.setProductTypeName(rs.getString("PROD_TYPE_NAME")== null ? "" : rs.getString("PROD_TYPE_NAME"));
		productTypeInfo.setProductTypeDesc(rs.getString("PROD_TYPE_DESC")== null ? "" : rs.getString("PROD_TYPE_DESC"));
		productTypeInfo.setStatus(rs.getString("STATUS")== null ? "" : rs.getString("STATUS"));
		
		return productTypeInfo;
	}

}
