package com.bns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.dto.DashboardClientRequest;
import com.bns.dto.StockCalculationRequest;
import com.bns.model.ProductCategoryAction;
import com.bns.repository.DashboardRepository;

import net.sf.json.JSONArray;

@Service
public class DashboardService {
	
	@Autowired
	private DashboardRepository dashboardRepository;
	
	public JSONArray getStockDataYearWiseService(DashboardClientRequest dashboardClientRequest) {
		
		if(!dashboardClientRequest.isSearch()) {
			return dashboardRepository.getStockDataYearWiseRepository(dashboardClientRequest);
		}else {
			
			//Get for multiple category and for month wise
		}
		return null;
	}
	
	public List<ProductCategoryAction> getProductCategoryWiseData(StockCalculationRequest stockCalculationRequest) {
		List<ProductCategoryAction> pList = null;
		
			int currentPage = stockCalculationRequest.getCurrentPage();
			int recordSize = stockCalculationRequest.getRowSize();
			int startIndex = currentPage * recordSize + 1;
			int endIndex = startIndex + recordSize - 1;

			pList = dashboardRepository.getProductCategoryWiseDataList(startIndex, endIndex , stockCalculationRequest ); 
		
		return pList;
	}
	
	public Long getTotalAllProductCategoryWiseData(String productCategoryValue, String productCategory) {
		return dashboardRepository.getTotalAllProductCategoryWiseData(productCategoryValue, productCategory);
	}
	
	public boolean getEditBNLeadTime(String id, String leadTime) {
		return dashboardRepository.getEditBNLeadTime(id, leadTime);
	}
}
