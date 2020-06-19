package com.bns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bns.repository.RateOfSaleRepository;
import java.util.List;
import com.bns.model.RateofSale;

@Service
public class RateOfSaleService {
	
	@Autowired
	private RateOfSaleRepository rateOfSaleRepository;
	
	public List<RateofSale> getRateOfSaleListByCategoryID(String categoryId) {
		
		 return rateOfSaleRepository.getAllRateOfSaleByCategoryID(categoryId);
	 }
	
	public List<RateofSale> getRateOfSaleListByCategoryIDAndPruductName(String categoryId,String productName) {
		
		 return rateOfSaleRepository.getAllRateOfSaleByCategoryIDAndProductName(categoryId,productName);
	 }

}
