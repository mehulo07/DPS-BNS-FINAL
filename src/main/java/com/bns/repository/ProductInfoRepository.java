package com.bns.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bns.mapper.ProductInfoMapper;
import com.bns.mapper.StringDataMapper;
import com.bns.model.ProductInfo;

@PropertySource(value = "classpath:productSetting.properties")
@Repository
public class ProductInfoRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment propSource;
	
	public List<ProductInfo> getProductList(ProductInfo productInfoBean) throws Exception {
		String tempProdName =  productInfoBean.getProductDesc() + "%";
		List<ProductInfo> retrunObj = null;
		
		try {
			retrunObj = jdbcTemplate.query(propSource.getProperty("getProductList"),new Object[] { productInfoBean.getContract() , productInfoBean.getCategory() , tempProdName , productInfoBean.getLimit() }, new ProductInfoMapper());
		}catch(Exception e) {
			System.out.println("matching product not found :"+e);
		}
		
		return retrunObj;	
	}
	
	
	public String getProductNameByCatalogNo(Object catalogNo, Object contract) {
		String productDesc = null;
		try {
			productDesc = jdbcTemplate.queryForObject(propSource.getProperty("getProductName"),
					new Object[] { (String) contract , (String) catalogNo},  new StringDataMapper());
		}catch(Exception e) {
			System.out.println("Exception while get product data"+e);
		}
			
		return productDesc;
	}
	
	public List<ProductInfo> getProductListForDashboard(String catId) throws Exception {
		List<ProductInfo> retrunObj = null;
		try {
			 if(catId=="" || catId==null)
				retrunObj = jdbcTemplate.query(propSource.getProperty("getProductListForDashBoard"),
						new ProductInfoMapper());
			 else
				 retrunObj = jdbcTemplate.query(propSource.getProperty("getProductListForDashBoardByCategoryID"),
						 new Object[] { (String) catId }, new ProductInfoMapper());
			
		}catch(Exception e) {
			System.out.println("matching product not found :"+e);
		}
		
		return retrunObj;	
	}
	
	
	
}
