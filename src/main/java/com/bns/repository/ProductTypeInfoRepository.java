package com.bns.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.bns.mapper.ProductTypeInfoMapper;
import com.bns.model.ProductTypeInfo;

@PropertySource(value = "classpath:ProductTypeInfo.properties")
@Repository
public class ProductTypeInfoRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private Environment propSource;


	public List<ProductTypeInfo> getAllProductTypeList() {
		return jdbcTemplate.query(propSource.getProperty("getAllProductType"), new ProductTypeInfoMapper());
	}

	public ProductTypeInfo getProductTypeDetailById(String productTypeId) {
		return jdbcTemplate.queryForObject(propSource.getProperty("getProductTypeById"), new Object[] { productTypeId },
				new ProductTypeInfoMapper());
	}

	public boolean addProductType(ProductTypeInfo productTypeInfo) {
		
		Authentication  authentication =
				  SecurityContextHolder.getContext().getAuthentication();
		
		return jdbcTemplate.update(propSource.getProperty("addProductType"), productTypeInfo.getProductTypeId(),
				productTypeInfo.getProductTypeName(), productTypeInfo.getProductTypeDesc(), productTypeInfo.getStatus(),
				authentication.getName()) > 0;
	}

	public boolean inactiveProductType(String productTypeId) throws SQLException {
		Authentication  authentication =
				  SecurityContextHolder.getContext().getAuthentication();
			return jdbcTemplate.update(propSource.getProperty("inactiveProductType"), authentication.getName(), productTypeId) > 0;
	}

	public boolean updateProductType(ProductTypeInfo productTypeInfo, String productTypeId) {
		Authentication  authentication =
				  SecurityContextHolder.getContext().getAuthentication();
		
		return jdbcTemplate.update(propSource.getProperty("updateProductType"), productTypeInfo.getProductTypeName(),
				productTypeInfo.getProductTypeDesc(), productTypeInfo.getStatus(), authentication.getName(), productTypeId) > 0;

	}

}
