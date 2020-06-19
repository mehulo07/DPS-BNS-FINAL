package com.bns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bns.dto.FilterParam;
import com.bns.repository.CountryInfoRepository;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class CountryInfoService {
	
	@Autowired
	private CountryInfoRepository countryInfoRepository;
	
	public ResponseEntity<JSONArray> getAllCountryCount() {
		Long count;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		try {
			count = countryInfoRepository.getAllCountryCount();	
			jsonObject.put("Message", "Ok");
			jsonObject.put("count",count);
			jsonArray.add(jsonObject);
			return ResponseEntity.ok(jsonArray);
		}catch(Exception e) {
			e.printStackTrace();
			jsonObject.put("Message", "Exception while get country count.");
			jsonObject.put("count",null);
			jsonArray.add(jsonObject);
			return ResponseEntity.ok(jsonArray);
		}
	}
	
	public ResponseEntity<JSONArray> getActiveCountryCount(FilterParam filterParam) {
		Long count;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		try {
			count = countryInfoRepository.getActiveCountryCount(filterParam);	
			jsonObject.put("Message", "Ok");
			jsonObject.put("count",count);
			jsonArray.add(jsonObject);
			return ResponseEntity.ok(jsonArray);
		}catch(Exception e) {
			e.printStackTrace();
			jsonObject.put("Message", "Exception while get active country count.");
			jsonObject.put("count",null);
			jsonArray.add(jsonObject);
			return ResponseEntity.ok(jsonArray);
		}
	}

}
