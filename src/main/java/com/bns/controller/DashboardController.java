package com.bns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bns.dto.DashboardClientRequest;
import com.bns.dto.StockCalculationRequest;
import com.bns.model.ProductCategoryAction;
import com.bns.model.ProductInfo;
import com.bns.service.DashboardService;
import com.bns.service.ProductInfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@CrossOrigin()
@RequestMapping(value = "DPS/V1/dashboard")
public class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@Autowired
	private ProductInfoService productInfoService;
	
	@PostMapping("/stockData")
	public JSONObject getStockDataYearWise(@RequestBody DashboardClientRequest dashboardClientRequest) {
		JSONArray returnArr = null;
		JSONObject returnObj = new JSONObject();
		try {
			returnArr =  dashboardService.getStockDataYearWiseService(dashboardClientRequest);
			if(returnArr != null) {
				returnObj.put("data",returnArr);
				returnObj.put("status",200);
				returnObj.put("Message","Data Found");
			}else {
				returnObj.put("data",null);
				returnObj.put("status",ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR));
				returnObj.put("Message","Data Not Found");
			}
		}catch(Exception e) {
			returnObj.put("data",null);
			returnObj.put("status",ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR));
			returnObj.put("Message","Data Not Found(Exception Occure)");
		}
		
		
		return returnObj;  
	}
	
	
	@PostMapping(value = "/productCategoryWiseData")
	public JSONObject getProductCategoryWiseData(@RequestBody StockCalculationRequest stockCalculationRequest) {
		
		JSONObject obj = new JSONObject();
		Double noOfPages = 1.0;
		int totalPages = 0;
		
		List<ProductCategoryAction>  listOfProducts = dashboardService.getProductCategoryWiseData(stockCalculationRequest);

		if(!stockCalculationRequest.isSearch()) {
			noOfPages = Double.valueOf(Double.valueOf(dashboardService.getTotalAllProductCategoryWiseData(stockCalculationRequest.getCategoryList().get(0),stockCalculationRequest.getStockId())).doubleValue() / Double.valueOf(stockCalculationRequest.getRowSize()).doubleValue());
			if ((noOfPages.doubleValue() > 0.0D) && (noOfPages.doubleValue() < 1.0D)) {
				totalPages = 1;
			} else if (noOfPages.doubleValue() % 1.0D > 0.0D) {
				totalPages = noOfPages.intValue() + 1;
			} else {
				totalPages = noOfPages.intValue();
			}
		}else {
			totalPages = 1;
		}
		
		obj.put("page",stockCalculationRequest.getCurrentPage() );
		obj.put("total", Integer.valueOf(totalPages));
		obj.put("records", noOfPages);
		obj.put("rows", listOfProducts);

		return obj;
	}
	
	@PostMapping(value = "/updateBNLeadTime")
	public ResponseEntity<String> editBNLeadTime(@RequestParam String id,@RequestParam String leadTime) {
		if(dashboardService.getEditBNLeadTime(id, leadTime)) {
			return ResponseEntity.ok("Sucessfully updaetd.");
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception while update lead time.");
		}
	}
	
	@GetMapping("/searchProduct")
	public ResponseEntity<List<ProductInfo>> getProductList(@RequestParam String categoryId) {
		
		return productInfoService.getProductListByCategoryID(categoryId);
		
	}
	
	@GetMapping(value = "/getStockCategoryID")
	public JSONObject getStockCategoryID(@RequestParam String catalogNo) {
		JSONObject obj = new JSONObject();
		Long stockCategoryId = dashboardService.getStockIDByCatalogNo(catalogNo);
		obj.put("stockCategoryId",stockCategoryId);
		obj.put("catalogNo",catalogNo);
		return obj;
	}
	
	@GetMapping(value = "/getProductCategoryDetails")
	public JSONObject getStockCategoryI2D(
			@RequestParam String year,
			@RequestParam String month,
			@RequestParam String productCategoryId,
			@RequestParam String stockCategoryId,
			@RequestParam String catalogNo
			) {
		JSONObject obj = new JSONObject();
		obj.put("rows",dashboardService.getProductCategoryActionData(year,month,productCategoryId,
				stockCategoryId,catalogNo));
		return obj;
	}
	
	
	
}
