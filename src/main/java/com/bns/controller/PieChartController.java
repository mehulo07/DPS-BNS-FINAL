package com.bns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.dto.FilterParam;
import com.bns.service.PieChartService;

import net.sf.json.JSONArray;

@RestController
@CrossOrigin()
@RequestMapping(value = "DPS/V1/pieChart")
public class PieChartController {
	
	@Autowired
	private PieChartService pieChartService;
	
	@PostMapping("/")
	public ResponseEntity<JSONArray> getPieChartData(@RequestBody FilterParam filterParam){
		return pieChartService.getPieChartData(filterParam); 
	}
}
