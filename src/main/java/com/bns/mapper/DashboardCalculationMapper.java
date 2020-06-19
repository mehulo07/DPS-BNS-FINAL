
package com.bns.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.springframework.jdbc.core.RowMapper;

import com.bns.dto.DashboardCalculation;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DashboardCalculationMapper implements RowMapper<JSONArray> {

	@Override
	public JSONArray mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DashboardCalculation dashboardCalculation = new DashboardCalculation();
		LinkedHashMap<String , HashMap<Integer, Integer>> categoryWiseDataTemp  = new LinkedHashMap<String , HashMap<Integer, Integer>>();
		HashMap<Integer,Integer> monthWiseDataTemp = null;
		JSONArray jarr = new JSONArray();

		try
		{
			if(rs != null)
			{
				categoryWiseDataTemp.put("Overstock", null);
				categoryWiseDataTemp.put("Healthy Stock Level", null);
				categoryWiseDataTemp.put("Low Stock Level", null);
				categoryWiseDataTemp.put("Buffer Stock Level", null);
				categoryWiseDataTemp.put("Out Stock Level", null);
				
				dashboardCalculation.setCategoryId(rs.getString("PROD_CAT_ID"));
				dashboardCalculation.setCategoryName(rs.getString("PROD_CAT_DESC"));
				monthWiseDataTemp = categoryWiseDataTemp.get(rs.getString("stock_cat_desc"));
				
				if(monthWiseDataTemp != null) {
					monthWiseDataTemp.put(rs.getInt("MONTH"), rs.getInt("TOTAL"));
				}else {
					monthWiseDataTemp = new HashMap<>();
					for(int i =1 ; i < 13 ; i++) {
						monthWiseDataTemp.put(i, 0);	
					}
					monthWiseDataTemp.put(rs.getInt("MONTH"), rs.getInt("TOTAL"));
				}
				categoryWiseDataTemp.put(rs.getString("stock_cat_desc"), monthWiseDataTemp);
				
				while(rs.next()) {
					monthWiseDataTemp = categoryWiseDataTemp.get(rs.getString("stock_cat_desc"));
					if(monthWiseDataTemp != null) {
						monthWiseDataTemp.put(rs.getInt("MONTH"), rs.getInt("TOTAL"));
					}else {
						monthWiseDataTemp = new HashMap<>();
						for(int i =1 ; i < 13 ; i++) {
							monthWiseDataTemp.put(i, 0);	
						}
						monthWiseDataTemp.put(rs.getInt("MONTH"), rs.getInt("TOTAL"));
					}
					categoryWiseDataTemp.put(rs.getString("stock_cat_desc"), monthWiseDataTemp);
				}
			}
			dashboardCalculation.setCategoryWiseData(categoryWiseDataTemp);
			int rowId = 0;
			if(dashboardCalculation !=null) {
				
				if(dashboardCalculation.getCategoryWiseData()!=null) {
					for(Entry<String, HashMap<Integer, Integer>> outerObject : dashboardCalculation.getCategoryWiseData().entrySet()) {
						JSONObject obj = new JSONObject();
						JSONArray arr = new JSONArray();
							arr.add(outerObject.getKey());
							monthWiseDataTemp = outerObject.getValue();
							for(Entry<Integer,Integer> innerObject : monthWiseDataTemp.entrySet()) {
								arr.add(innerObject.getValue());
							}
							
							obj.put("id", "catParam"+rowId++);
							obj.put("cell", arr);
							jarr.add(obj);
						}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jarr;
	}
}

