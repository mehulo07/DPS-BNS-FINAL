package com.bns.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bns.dto.FilterParam;
import com.bns.mapper.PieChartDataMapper;
import com.bns.model.PieChartData;

@PropertySource(value = "classpath:dashboard.properties")
@Repository
public class PieChartRepository {
	
	
	@Autowired
	private Environment propSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public List<PieChartData> getPieChartData(FilterParam filterParam){
		
		System.out.println("filterParam is :"+filterParam);
		List<PieChartData> returnObj = null;
		String query = propSource.getProperty("getPieChartData");
		
		try {
			MapSqlParameterSource parameters = new MapSqlParameterSource();
		    parameters.addValue("year", filterParam.getYear());
		    parameters.addValue("monthParam", filterParam.getMonth());
		    parameters.addValue("categoryParam", filterParam.getCategoryId());
		    
			System.out.println("Final uery for pie chart data :"+query);
			System.out.println("parameters is :"+parameters);
			
			returnObj = namedParameterJdbcTemplate.query(query, parameters , new PieChartDataMapper());
			
			//returnObj = namedParameterJdbcTemplate.query(query ,parameters , new PieChartDataMapper());
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception while get pieChartdata");
		}
		
		return returnObj;
	}
	
}
