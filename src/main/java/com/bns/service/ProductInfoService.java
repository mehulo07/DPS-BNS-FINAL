package com.bns.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bns.dto.FilterParam;
import com.bns.model.ProductInfo;
import com.bns.model.ProductParamMaster;
import com.bns.model.TransactionSeq;
import com.bns.repository.ProductInfoRepository;
import com.bns.repository.ProductParamMasterRepository;
import com.bns.repository.StockLevelRepossitory;
import com.bns.utility.DateUtility;
import com.bns.utility.DpsConstant;

import net.sf.json.JSONArray;

@Service
public class ProductInfoService {
	
	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	@Autowired
	private ProductParamMasterRepository productParamMasterRepository;
	
	@Autowired
	private StockLevelRepossitory stockLevelRepossitory;
	
	@Autowired
	private DateUtility dateUtility;
	
	public ResponseEntity<List<ProductInfo>> getProductList(ProductInfo productInfoBean ) {
		List<ProductInfo> searchProdList = null;
		try {
			searchProdList = productInfoRepository.getProductList(productInfoBean);
			if(searchProdList != null)
				return ResponseEntity.ok().body(searchProdList);
			else
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	public JSONArray getParamsByCategoryAndProduct(Integer currentPage, Integer recordSize,FilterParam filterParam , Boolean byCategory) {

		JSONArray jarr = new JSONArray();
		currentPage--;
		int startIndex = currentPage * recordSize + 1;
		int endIndex = startIndex + recordSize - 1;
		ProductParamMaster categoryProductParamMaster = null;
		java.sql.Date firstDay , lastDay;
		List<Integer> month = null;
		List<TransactionSeq> transactions = null;
		List<ProductParamMaster> productParamMasterList = new ArrayList();
		int year;
		try {
			
			year = filterParam.getYear();
			month = filterParam.getMonth();
			
			firstDay = dateUtility.getFirstDateInSQLFormate( year, month.get(0) );
			lastDay = dateUtility.getLastDateInSQLFormate( year , month.get(0) );
			
			System.err.println("cataog no is :"+filterParam.getCatalog_no());
			
			if( filterParam.getCatalog_no() == null ) {
				categoryProductParamMaster = productParamMasterRepository.getStockEntryMasterByCategoryandCatalog(filterParam,null,firstDay,lastDay);
				System.out.println("categoryProductParamMaster is null ?? "+categoryProductParamMaster);
				if(categoryProductParamMaster != null) {
					categoryProductParamMaster.setProductParamDetailBeanList(productParamMasterRepository.getStockDetailByTransactionId(categoryProductParamMaster.getTransaction_id()));
					//getAllTransaction
					transactions = stockLevelRepossitory.getTransactionListByCategoryId(filterParam.getCategoryId().get(0),firstDay,lastDay);
					//iterate transactions
					for (TransactionSeq tempTransactionSeq: transactions) {
						ProductParamMaster tempProductParamMaster = null;
						tempProductParamMaster = productParamMasterRepository.getStockEntryMasterByTransactionId(tempTransactionSeq.getTransaction_id(), DpsConstant.STATUS_ACTIVE);
						tempProductParamMaster.setCatalog_Desc(productInfoRepository.getProductNameByCatalogNo(tempProductParamMaster.getCatalog_no(), DpsConstant.DPS_PRODUCT_CONTRACT));
						if(tempProductParamMaster != null) {
							tempProductParamMaster.setProductParamDetailBeanList(productParamMasterRepository.getStockDetailByTransactionId(tempProductParamMaster.getTransaction_id()));
							productParamMasterList.add(tempProductParamMaster);
						}
					}
				}
			}else {
				System.out.println("inside search by product");
				categoryProductParamMaster = productParamMasterRepository.getStockEntryMasterByCategoryandCatalog(filterParam, filterParam.getCatalog_no().get(0),firstDay,lastDay);
				if(categoryProductParamMaster != null) {
					categoryProductParamMaster.setCatalog_Desc(productInfoRepository.getProductNameByCatalogNo(categoryProductParamMaster.getCatalog_no(), DpsConstant.DPS_PRODUCT_CONTRACT));
					categoryProductParamMaster.setProductParamDetailBeanList(productParamMasterRepository.getStockDetailByTransactionId(categoryProductParamMaster.getTransaction_id()));
				}
				ProductParamMaster tempProductParamMaster = null;
				tempProductParamMaster = productParamMasterRepository.getStockEntryMasterByCategoryandCatalog(filterParam, filterParam.getCatalog_no().get(0),firstDay,lastDay);
				if(tempProductParamMaster  != null) {
					tempProductParamMaster.setCatalog_Desc(productInfoRepository.getProductNameByCatalogNo(categoryProductParamMaster.getCatalog_no(), DpsConstant.DPS_PRODUCT_CONTRACT));
					tempProductParamMaster .setProductParamDetailBeanList(productParamMasterRepository.getStockDetailByTransactionId(categoryProductParamMaster.getTransaction_id()));
					productParamMasterList.add(tempProductParamMaster);
				}
			}
			int rowId = 0;
			
			if(byCategory) {
				//ByCategory
				if(categoryProductParamMaster!=null) {
					jarr.add(categoryProductParamMaster);
					jarr.add(productParamMasterList);
				}
			}else {
				//By Product
				for(ProductParamMaster list : productParamMasterList) {
						jarr.add(list);
				}
			}
		} finally {}
		return jarr;
	}
}