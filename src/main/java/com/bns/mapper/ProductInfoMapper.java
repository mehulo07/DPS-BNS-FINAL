package com.bns.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bns.model.ProductInfo;

public class ProductInfoMapper implements RowMapper<ProductInfo> {

	@Override
	public ProductInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductInfo productInfo  = new ProductInfo();
		
		productInfo.setCatalogNo(rs.getString("CATALOG_NO") == null ? "" : rs.getString("CATALOG_NO"));
		productInfo.setProductDesc(rs.getString("CATALOG_DESC") == null ? "" : rs.getString("CATALOG_DESC"));
		productInfo.setCategory(rs.getString("CATALOG_TYPE") == null ? "" : rs.getString("CATALOG_TYPE"));
		productInfo.setContract(rs.getString("CONTRACT") == null ? "" : rs.getString("CONTRACT"));
		productInfo.setNcsoProfitableFlag(rs.getString("PROFIT_NCSO") == null ? "" : rs.getString("PROFIT_NCSO"));
		productInfo.setLeadTime(rs.getString("LEAD_TIME") == null ? "" : rs.getString("LEAD_TIME"));
		
		return productInfo;
	}

}
