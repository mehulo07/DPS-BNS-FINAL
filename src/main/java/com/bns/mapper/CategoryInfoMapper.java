package com.bns.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bns.model.CategoryInfo;

public class CategoryInfoMapper implements RowMapper<CategoryInfo> {

	@Override
	public CategoryInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		CategoryInfo categoryInfo = new CategoryInfo();
		
		categoryInfo.setCategoryId(rs.getString("PROD_CAT_ID") == null ? "" : rs.getString("PROD_CAT_ID"));
		categoryInfo.setCategoryName(rs.getString("PROD_CAT_NAME") == null ? "" : rs.getString("PROD_CAT_NAME"));
		categoryInfo.setCategoryDescription(rs.getString("PROD_CAT_DESC") == null ? "" : rs.getString("PROD_CAT_DESC"));
		categoryInfo.setStatus(rs.getString("STATUS") == null ? "" : rs.getString("STATUS"));
		
		return categoryInfo;
	}

}
