package com.bns.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bns.dto.DashboardClientRequest;
import com.bns.dto.StockCalculationRequest;
import com.bns.mapper.DashboardCalculationMapper;
import com.bns.mapper.ProductCategoryActionMapper;
import com.bns.model.ProductCategoryAction;

import net.sf.json.JSONArray;

@PropertySource(value = "classpath:dashboard.properties" ,ignoreResourceNotFound=true)
@Repository
public class DashboardRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment propSource;
	
	@Autowired
	private NamedParameterJdbcTemplate namejdbcTemplate;
	
	
	public JSONArray getStockDataYearWiseRepository(DashboardClientRequest dashboardClientRequest) {
		return  jdbcTemplate.queryForObject(propSource.getProperty("getCalculatedDataForDashBoard"), new Object[] { dashboardClientRequest.getYear(), dashboardClientRequest.getCategoryList().get(0)} , new DashboardCalculationMapper());
	}
	
	public List<ProductCategoryAction> getProductCategoryWiseDataList(int startIndex,int endIndex, StockCalculationRequest stockCalculationRequest) {
		
		System.out.println("stockCalculationRequest is :"+stockCalculationRequest);
		
		List<ProductCategoryAction> returnObj = null;
		String query  =  propSource.getProperty("getProductCategoryWiseDataList") ;
		StringBuilder categoryBuilder = new StringBuilder();
		
		int categoryListLength = stockCalculationRequest.getCategoryList().size();
		int monthListLength = stockCalculationRequest.getMonthArr().size();
		List<String> categoryList = stockCalculationRequest.getCategoryList();
		List<Integer> monthList = stockCalculationRequest.getMonthArr();
		
		StringBuffer monthQuery =  new StringBuffer();

		if(stockCalculationRequest.getCategoryList().size() > 1) {
	        for(int i = 0 ; i < categoryListLength ; i++) {
	        	if(i == categoryListLength) {
	        		categoryBuilder.append("'"+categoryList.get(i)+"'");
	        	}else {
	        		categoryBuilder.append("'"+categoryList.get(i)+"',");
	        	}
	        }
	        query = query.replace("@1",categoryBuilder);
		}else {
			query = query.replace("@1","'"+categoryList.get(0)+"'");
		}

		
		if(stockCalculationRequest.getMonthArr().size() > 1) {
	        for(int i = 0 ; i < monthListLength ; i++) {
	        	if(i == monthListLength) {
	        		monthQuery.append(monthList.get(i));
	        	}else {
	        		monthQuery.append(monthList.get(i)+",");
	        	}
	        }
		}else {
			monthQuery.append(monthList.get(0));
		}

		System.out.println("monthQuery is :"+monthQuery);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("productCategoryValue",stockCalculationRequest.getStockId());
		paramMap.put("startIndex", startIndex);
		paramMap.put("endIndex", endIndex);
		paramMap.put("month", monthQuery);
		paramMap.put("year", stockCalculationRequest.getYear());
		
		if(stockCalculationRequest.isSearch()) {
			paramMap.put("catalogNo", stockCalculationRequest.getSearchString());
			query = query.replace("@", " AND   CATALOG_NO = :catalogNo ");
		}else {
			query = query.replace("@", " ");
		}
		
		System.out.println("Final Query is :"+query);
		System.out.println("");
		RowMapper<ProductCategoryAction> rowMapper = new ProductCategoryActionMapper();
		System.out.println("paramMap is :"+paramMap);
		try {
			returnObj = namejdbcTemplate.query(query, paramMap, rowMapper);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return returnObj;
	}
	
	public Long getTotalAllProductCategoryWiseData(String productCategoryValue, String productCategory) {
		String query = propSource.getProperty("getTotalAllProductCategoryWiseData") ;
		return jdbcTemplate.queryForObject(query, new Object[] { productCategory , productCategoryValue}, Long.class);
	}
	
	public boolean getEditBNLeadTime(String id, String leadTime) {
		String query = propSource.getProperty("getEditBNLeadTime") ;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("BN_LEAD_TIME", Integer.parseInt(( (leadTime == null  ||  leadTime.trim().equals("")) ? "0" : leadTime)));
		paramMap.put("id", Integer.parseInt(id));
		
		return namejdbcTemplate.update(query,paramMap) > 0;
	}
}
