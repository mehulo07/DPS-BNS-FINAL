package com.bns.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bns.exception.ResourceNotFoundException;
import com.bns.mapper.StockParameterMapper;
import com.bns.model.ProductParamMaster;
import com.bns.model.StockParameter;

@PropertySource(value = "classpath:StockParameter.properties")
@Repository
public class StockParameterRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private Environment propSource;
	

	public List<StockParameter> getAllStockParameterList()  throws ResourceNotFoundException{
		return jdbcTemplate.query(propSource.getProperty("getAllStockParameter"), new StockParameterMapper());
	}
	
	public StockParameter getStockParameterById(String stockParamId)  throws ResourceNotFoundException{
		Optional<StockParameter> stockParameter = Optional.of(jdbcTemplate.queryForObject(propSource.getProperty("getStockParameterById") ,new Object[] {stockParamId} ,new StockParameterMapper()));
		stockParameter.orElseThrow(() -> new ResourceNotFoundException
				("Stock Parameter is not found with given id :"+stockParamId));
		return stockParameter.get();
	}
	
	public boolean addStockParameter(StockParameter stockParameter) throws ResourceNotFoundException{
		return jdbcTemplate.update(propSource.getProperty("addStockParameter") ,new Object[] {stockParameter.getStockParamId() ,stockParameter.getStockParamName() 
				, stockParameter.getStockParamDesc() , stockParameter.getStatus() , stockParameter.getStockParamColorId(),"mehul"}) > 0;
	}
	
	public boolean updateStockParameter(String stockParamId,StockParameter stockParameter) throws ResourceNotFoundException{
		
		Authentication  obj=  SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println("name is :"+obj.getName());
		System.out.println("Principal is :"+obj.getPrincipal());
		System.out.println("credential is :"+obj.getCredentials());
		
		return jdbcTemplate.update(propSource.getProperty("updateStockParameter") ,new Object[] {stockParameter.getStockParamName() 
				, stockParameter.getStockParamDesc() , stockParameter.getStatus() , stockParameter.getStockParamColorId(),"mehul" , stockParamId }) > 0;
	}

	public boolean deleteStockParameter(String stockParamId) throws ResourceNotFoundException{
		
		Authentication  obj=  SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println("name is :"+obj.getName());
		System.out.println("Principal is :"+obj.getPrincipal());
		System.out.println("credential is :"+obj.getCredentials());
		
		return jdbcTemplate.update(propSource.getProperty("inactiveStockParameter") ,new Object[] {"mehul" , stockParamId }) > 0;
	}
}
