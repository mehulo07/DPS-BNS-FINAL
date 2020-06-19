package com.bns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bns.dto.FilterParam;
import com.bns.repository.SupplierInfoRepository;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class SupplierInfoService {
	
	@Autowired 
	private SupplierInfoRepository supplierInfoRepository;
	
	public ResponseEntity<JSONArray> getAllSupplierCount() {
		Long count;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		try {
			count = supplierInfoRepository.getAllSupplierCount();	
			jsonObject.put("Message", "Ok");
			jsonObject.put("count",count);
			jsonArray.add(jsonObject);
			return ResponseEntity.ok(jsonArray);
		}catch(Exception e) {
			jsonObject.put("Message", "Exception while get supplier count.");
			jsonObject.put("count",null);
			jsonArray.add(jsonObject);
			return ResponseEntity.ok(jsonArray);
		}
	}
	
	public ResponseEntity<JSONArray> getActiveSupplierCount(FilterParam filterParam) {
		Long count;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		try {
			count = supplierInfoRepository.getActiveSupplierCount(filterParam);	
			jsonObject.put("Message", "Ok");
			jsonObject.put("count",count);
			jsonArray.add(jsonObject);
			return ResponseEntity.ok(jsonArray);
		}catch(Exception e) {
			e.printStackTrace();
			jsonObject.put("Message", "Exception while get active supplier count.");
			jsonObject.put("count",null);
			jsonArray.add(jsonObject);
			return ResponseEntity.ok(jsonArray);
		}
	}
}
