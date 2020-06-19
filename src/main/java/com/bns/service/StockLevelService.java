package com.bns.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bns.dto.CategoryEntryInfo;
import com.bns.dto.ProductEntryInfo;
import com.bns.model.ProductInfo;
import com.bns.model.TransactionSeq;
import com.bns.repository.StockLevelRepossitory;
import com.bns.repository.TransactionSeqRepository;
import com.bns.utility.DpsConstant;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class StockLevelService {

	@Autowired
	private StockLevelRepossitory stockLevelRepossitory;
	
	@Autowired
	private TransactionSeqRepository transactionSeqRepository; 
	
	public ResponseEntity<JSONArray> saveProductList(List<ProductEntryInfo> listOfProductEntryInfo) {
		JSONArray returnArr = new JSONArray();
		JSONObject retrunObj = new JSONObject();
		List<ProductInfo> productUpdateInfo = new ArrayList<ProductInfo>();		
		try {
			for(ProductEntryInfo productEntryInfo :  listOfProductEntryInfo) {
				stockLevelRepossitory.delete(productEntryInfo.getProductParamMaster());
				//Get transaction id
				TransactionSeq seq = transactionSeqRepository.getNewTransaction(DpsConstant.DPS_COMPANY_PREFIX);
				productEntryInfo.getProductParamMaster().setTransaction_id(seq.getTransaction_id());
				
				productUpdateInfo.add(productEntryInfo.getProductInfo());
				//Transaction saved.
				stockLevelRepossitory.save(productEntryInfo.getProductParamMaster() ,productUpdateInfo);
			}
			retrunObj.put("Message", "Product list is saved.");
			returnArr.add(retrunObj);
			return ResponseEntity.ok(returnArr);
		}catch(Exception e) {
			retrunObj.put("Message", "Exception while saving Stock parameter. "+e.getMessage());
			returnArr.add(retrunObj);
			return ResponseEntity.ok(returnArr);
		}
	}
	
	
	public ResponseEntity<JSONArray> saveCategoryParam(CategoryEntryInfo categoryEntryInfo ) {
		JSONArray returnArr = new JSONArray();
		JSONObject retrunObj = new JSONObject();
		List<ProductInfo> productUpdateInfo = new ArrayList<ProductInfo>();		
		try {
				stockLevelRepossitory.delete(categoryEntryInfo.getProductParamMaster());
				//Get transaction id
				TransactionSeq seq = transactionSeqRepository.getNewTransaction(DpsConstant.DPS_COMPANY_PREFIX);
				categoryEntryInfo.getProductParamMaster().setTransaction_id(seq.getTransaction_id());
				//add Pricematrix update date
				productUpdateInfo.addAll(categoryEntryInfo.getListOfProductInfo());
				//Transaction saved.
				stockLevelRepossitory.save(categoryEntryInfo.getProductParamMaster() ,productUpdateInfo);
			
			retrunObj.put("code", 200);
			retrunObj.put("Message", "Category param is saved.");
			returnArr.add(retrunObj);
			return ResponseEntity.ok(returnArr);
		}catch(Exception e) {
			retrunObj.put("code", ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR));
			retrunObj.put("Message", "Exception while saving category parameter. "+e.getMessage());
			returnArr.add(retrunObj);
			return ResponseEntity.ok(returnArr);
		}
	}
	
}
