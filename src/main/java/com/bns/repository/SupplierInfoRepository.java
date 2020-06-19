package com.bns.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bns.dto.FilterParam;
import com.bns.utility.DateUtility;

@PropertySource(value = "classpath:SupplierInfo.properties")
@Repository
public class SupplierInfoRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private Environment propSource;
	
	@Autowired
	private DateUtility dateUtility;
	
	public Long getAllSupplierCount() {
		return jdbcTemplate.queryForObject(propSource.getProperty("allSupplierCount"), Long.class); 
	}
	
	public Long getActiveSupplierCount(FilterParam filterParam) {
		
		String firstDayOfYear = dateUtility.firstDatOfYear(filterParam.getYear());
		String lastDayOfYear = dateUtility.lastDatOfYear(filterParam.getYear());
		
		String query = propSource.getProperty("activeSupplierCount");
		String queryBuilder = "";
		System.out.println("firstDayOfYear is :"+firstDayOfYear);
		System.out.println("lastDayOfYear is :"+lastDayOfYear);
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
	    parameters.addValue("startDate", firstDayOfYear);
	    parameters.addValue("endDate", lastDayOfYear);
		int i =0;
			
			while(i < filterParam.getCategoryId().size()) {
				if(i==filterParam.getCategoryId().size()-1) {
					queryBuilder = queryBuilder  + "IFSAPP.DPS_COM_API.GET_PROD_CAT_DESC('"+filterParam.getCategoryId().get(i)+"')";
				}else {
					queryBuilder = queryBuilder  + "IFSAPP.DPS_COM_API.GET_PROD_CAT_DESC('"+filterParam.getCategoryId().get(i)+"'),";
				}
				i++;
			}
			System.out.println("befour query is :"+query);
			query = query.replace("@categoryDesc", queryBuilder);
			System.out.println("after query is :"+query);
			
			return namedParameterJdbcTemplate.queryForObject(query, parameters , Long.class);
	}
	
}
