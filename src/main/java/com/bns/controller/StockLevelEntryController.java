package com.bns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.dto.CategoryEntryInfo;
import com.bns.dto.ProductEntryInfo;
import com.bns.dto.StockFilter;
import com.bns.model.ProductInfo;
import com.bns.service.ProductInfoService;
import com.bns.service.StockLevelService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@CrossOrigin
@RestController
@RequestMapping(value = "DPS/V1/stockEntry")
public class StockLevelEntryController {

	@Autowired
	private ProductInfoService productInfoService;

	@Autowired
	private StockLevelService stockLevelService;

	@PostMapping("/searchProduct")
	public ResponseEntity<List<ProductInfo>> getProductList(@RequestBody ProductInfo productInfo) {
		System.out.println("productInfo is :" + productInfo);
		return productInfoService.getProductList(productInfo);
	}

	@PostMapping("/productEntry")
	public ResponseEntity<JSONArray> saveMultipleProductParam(@RequestBody List<ProductEntryInfo> productEntryInfo) {
		return stockLevelService.saveProductList(productEntryInfo);
	}

	@PostMapping("/categoryEntry")
	public ResponseEntity<JSONArray> saveCategoryParam(@RequestBody CategoryEntryInfo categoryEntryInfo) {
		return stockLevelService.saveCategoryParam(categoryEntryInfo);
	}

	@PostMapping("/getParamsByCategory")
	public JSONObject getParamsByCategory(@RequestBody StockFilter stockFilter) {

		JSONObject mainObj = new JSONObject();
		JSONArray jarr = null;
		int totalPages = 0;
		String sortBy = stockFilter.getStockCalculationRequest().getSortBy();
		int currentPage = stockFilter.getStockCalculationRequest().getCurrentPage();
		String sortOrder = stockFilter.getStockCalculationRequest().getSortOrder();
		int recordSize = stockFilter.getStockCalculationRequest().getRowSize();

		try {
			
			jarr = productInfoService.getParamsByCategoryAndProduct(currentPage, recordSize, stockFilter.getFilterParam(),
					true);
			Double noOfPages = Double
					.valueOf(Double.valueOf(1000).doubleValue() / Double.valueOf(recordSize).doubleValue());

			if((noOfPages.doubleValue() > 0.0D) && (noOfPages.doubleValue() < 1.0D)) {
				totalPages = 1;
			} else if (noOfPages.doubleValue() % 1.0D > 0.0D) {
				totalPages = noOfPages.intValue() + 1;
			} else {
				totalPages = noOfPages.intValue();
			}

			mainObj.put("page", Integer.valueOf(currentPage));
			mainObj.put("total", Integer.valueOf(totalPages));
			mainObj.put("records", 1);
			mainObj.put("rows", jarr);

		} catch (Exception e) {
			e.printStackTrace();
			mainObj.put("status", e.getLocalizedMessage());
		}
		return mainObj;
	}

	@PostMapping("/getParamsByProduct")
	public JSONObject getParamsByProduct(@RequestBody StockFilter stockFilter) {
		JSONObject mainObj = new JSONObject();
		JSONArray jarr = null;
		int totalPages = 0;
		System.out.println("");
		try {
			
			String sortBy = stockFilter.getStockCalculationRequest().getSortBy();
			int currentPage = stockFilter.getStockCalculationRequest().getCurrentPage();
			int recordSize = stockFilter.getStockCalculationRequest().getRowSize();
			String sortOrder = stockFilter.getStockCalculationRequest().getSortOrder();

			jarr = productInfoService.getParamsByCategoryAndProduct(currentPage, recordSize,stockFilter.getFilterParam(), false);
			Double noOfPages = Double
					.valueOf(Double.valueOf(1000).doubleValue() / Double.valueOf(recordSize).doubleValue());

			if ((noOfPages.doubleValue() > 0.0D) && (noOfPages.doubleValue() < 1.0D)) {
				totalPages = 1;
			} else if (noOfPages.doubleValue() % 1.0D > 0.0D) {
				totalPages = noOfPages.intValue() + 1;
			} else {
				totalPages = noOfPages.intValue();
			}

			mainObj.put("page", Integer.valueOf(currentPage));
			mainObj.put("total", Integer.valueOf(totalPages));
			mainObj.put("records", 1);
			mainObj.put("rows", jarr);

		} catch (Exception e) {
			e.printStackTrace();
			mainObj.put("status", e.getLocalizedMessage());
		}
		return mainObj;
	}
}
