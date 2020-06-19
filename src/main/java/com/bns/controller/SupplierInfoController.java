package com.bns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.dto.FilterParam;
import com.bns.service.SupplierInfoService;

import net.sf.json.JSONArray;

@RestController
@CrossOrigin()
@RequestMapping(value = "DPS/V1/supplier")
public class SupplierInfoController {

	@Autowired
	private SupplierInfoService supplierInfoService; 
	
	@GetMapping("/allCount")
	public ResponseEntity<JSONArray> getAllSupplierCount() {
		return supplierInfoService.getAllSupplierCount();
	}
	
	@PostMapping("/activeCount")
	public ResponseEntity<JSONArray> getActiveSupplierCount(@RequestBody FilterParam filterParam) {
		return supplierInfoService.getActiveSupplierCount(filterParam);
	}
	
}
