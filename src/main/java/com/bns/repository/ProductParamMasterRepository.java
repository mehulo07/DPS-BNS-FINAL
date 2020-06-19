package com.bns.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bns.dto.FilterParam;
import com.bns.mapper.ProductParamDetailMapper;
import com.bns.mapper.ProductParamMasterMapper;
import com.bns.model.ProductParamDetail;
import com.bns.model.ProductParamMaster;

@PropertySource(value = "classpath:productSetting.properties")
@Repository
public class ProductParamMasterRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment propSource;
	
	
	public ProductParamMaster getStockEntryMasterByTransactionId(String transactionId, String status) {
		ProductParamMaster productParamMaster = null;
			productParamMaster = jdbcTemplate.queryForObject(propSource.getProperty("getProductParamMasterByTransactionId"), new Object[] {transactionId}, new ProductParamMasterMapper());
		return productParamMaster;
	}
	
	
	public ProductParamMaster getStockEntryMasterByCategoryandCatalog(FilterParam productSeattingSearch, String catalog_no ,Date from , Date to) {
		ProductParamMaster productParamMaster = null;
		
		System.out.println("productSeattingSearch is :"+productSeattingSearch.toString());
		
		System.out.println("catalog_no is :"+catalog_no);
		
		System.out.println("catalog is :"+productSeattingSearch.getCategoryId());
		
		System.out.println("head Query is :"+propSource.getProperty("getProductParamHead"));
		System.out.println("category id si :"+catalog_no);
		System.out.println("catalog_no is :"+catalog_no);
		System.out.println("status is :"+productSeattingSearch.getStatus());
		System.out.println("from :"+from);
		System.out.println("To is :"+to);
			productParamMaster = jdbcTemplate.queryForObject(propSource.getProperty("getProductParamHead"), 
						new Object[] { productSeattingSearch.getCategoryId().get(0), catalog_no == null ? "-" : catalog_no
								, productSeattingSearch.getStatus() , String.valueOf(from) , String.valueOf(to) }, new ProductParamMasterMapper());
			
			System.out.println("productParamMaster is YAHH :"+productParamMaster);
			
		return productParamMaster;
	}
	
	public List<ProductParamDetail> getStockDetailByTransactionId(String transactionId) {
		List<ProductParamDetail> roductParamDetail = null;
		try {
			roductParamDetail= jdbcTemplate.query(propSource.getProperty("getProductDetailByTransactionId"),
					new Object[] { transactionId }, new ProductParamDetailMapper());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return roductParamDetail;
	}
}
