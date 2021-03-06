
package com.bns.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bns.dto.RateOfSaleRequest;
import com.bns.dto.StockCalculationRequest;
import com.bns.mapper.CategoryInfoMapper;
import com.bns.mapper.ProductCategoryActionMapper;
import com.bns.mapper.RateOfSaleMapper;
import com.bns.mapper.UserInfoMapper;
import com.bns.model.CategoryInfo;
import com.bns.model.ProductCategoryAction;
import com.bns.model.RateofSale;
import java.util.*;

@PropertySource(value = "classpath:RateOfSale.properties")
@Repository
public class RateOfSaleRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namejdbcTemplate;

	@Autowired
	private Environment propSource;

	public List<RateofSale> getAllRateOfSaleByCategoryIDWithPagination(String productCategoryId,String startIndex,String endIndex) {
		return jdbcTemplate.query(propSource.getProperty("getAllRateOfSaleByCategoryIDWithPagination"), 
				new Object[] {productCategoryId,startIndex,endIndex},new RateOfSaleMapper());
		}
	
	public List<RateofSale> getAllRateOfSaleByCategoryIDAndProductName(String categoryId,String productName) {
		return jdbcTemplate.query(propSource.getProperty("getAllRateOfSaleByCategoryIDAndProductName"), new Object[] {categoryId,productName},new RateOfSaleMapper());
	}
	
	public List<RateofSale> getAllRateOfSaleByCategoryID(String productCategoryId) {
		return jdbcTemplate.query(propSource.getProperty("getAllRateOfSaleByCategoryID"), 
				new Object[] {productCategoryId},new RateOfSaleMapper());
		}
	
	

}
