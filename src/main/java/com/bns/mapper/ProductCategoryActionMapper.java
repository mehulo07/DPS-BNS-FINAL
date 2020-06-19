package com.bns.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bns.model.ProductCategoryAction;

public class ProductCategoryActionMapper implements RowMapper<ProductCategoryAction>{

	@Override
	public ProductCategoryAction mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductCategoryAction pca = new ProductCategoryAction();
		
		pca.setId(rs.getString("ID"));
		pca.setProcductCategory(rs.getString("PROD_CAT_ID"));
		pca.setStockCategory(rs.getString("STOCK_CAT_ID"));
		pca.setPartNo(rs.getString("CATALOG_NO"));
		pca.setPartDesc(rs.getString("DESCRIPTION"));
		
		pca.setCsProfit(rs.getString("PROFIT_NCSO"));
		pca.setCsUnits(rs.getString("CS_UNIT"));
		pca.setCsWeeks(rs.getString("CS_COVER"));
		pca.setCsPallets(rs.getString("CS_PALLET"));
		pca.setRosUnits(rs.getString("RS_UNIT"));
		pca.setRosTrend(rs.getString("RS_TREND"));
		pca.setItsUnits(rs.getString("ITS_UNIT"));
		pca.setItsWeeks(rs.getString("ITS_COVER"));
		pca.setItsDelevery(rs.getString("ITS_DELIVERY_DATE_NEW"));
		pca.setItsPallets(rs.getString("ITS_PALLET"));
		pca.setBnUnits(rs.getString("BN_UNIT"));
		pca.setBnWeeks(rs.getString("BN_COVER"));
		pca.setBnLead(rs.getString("BN_LEAD_TIME"));
		
		return pca;
	}
}


