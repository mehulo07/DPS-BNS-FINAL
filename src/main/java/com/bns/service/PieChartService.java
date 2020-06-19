package com.bns.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bns.dto.FilterParam;
import com.bns.model.PieChartData;
import com.bns.repository.PieChartRepository;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class PieChartService {
	
	@Autowired
	private PieChartRepository pieChartRepository;
	
	public ResponseEntity<JSONArray> getPieChartData(FilterParam filterParam){
		List<PieChartData> obj = pieChartRepository.getPieChartData(filterParam);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		
		if(Optional.ofNullable(obj).isPresent()) {
			jsonObject.put("Message", "Data found");
			jsonObject.put("data",obj);
			jsonArray.add(jsonObject); 
			return ResponseEntity.ok(jsonArray);
		}else {
			jsonObject.put("Message", "Data not found");
			jsonObject.put("data",null);
			jsonArray.add(jsonObject); 
			return ResponseEntity.ok(jsonArray);
		}
	}
	
}
