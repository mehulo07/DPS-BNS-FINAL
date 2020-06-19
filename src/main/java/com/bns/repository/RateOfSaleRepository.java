
package com.bns.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bns.mapper.CategoryInfoMapper;
import com.bns.mapper.RateOfSaleMapper;
import com.bns.mapper.UserInfoMapper;
import com.bns.model.CategoryInfo;
import com.bns.model.RateofSale;
import java.util.*;

@PropertySource(value = "classpath:RateOfSale.properties")
@Repository
public class RateOfSaleRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private Environment propSource;

	public List<RateofSale> getAllRateOfSaleByCategoryID(String categoryId) {
		return jdbcTemplate.query(propSource.getProperty("getAllRateOfSaleByCategoryID"), new Object[] {categoryId},new RateOfSaleMapper());
		}
	
	public List<RateofSale> getAllRateOfSaleByCategoryIDAndProductName(String categoryId,String productName) {
		return jdbcTemplate.query(propSource.getProperty("getAllRateOfSaleByCategoryIDAndProductName"), new Object[] {categoryId,productName},new RateOfSaleMapper());
	}

}
