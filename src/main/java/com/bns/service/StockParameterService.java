package com.bns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.StockParameter;
import com.bns.repository.StockParameterRepository;

@Service
public class StockParameterService {

	@Autowired
	private StockParameterRepository stockParameterRepository;
	
	
	 public List<StockParameter> getAllStockParameterList() throws ResourceNotFoundException{
		 return stockParameterRepository.getAllStockParameterList();
	 }	
	 
	 public StockParameter getStockParameterById(String stockParamId) throws ResourceNotFoundException {
		 return stockParameterRepository.getStockParameterById(stockParamId);
	 }
	 
	 @Transactional
	 public boolean addStockParameter(StockParameter stockParameter) throws ResourceNotFoundException {
		  return stockParameterRepository.addStockParameter(stockParameter);
	 }
	 
	 @Transactional
	 public boolean updateStockParameter(String stockParamId,StockParameter stockParameter) throws ResourceNotFoundException{
		 return stockParameterRepository.updateStockParameter(stockParamId, stockParameter);
	 }
	 
	 @Transactional
	 public boolean deleteStockParameter(String stockParamId) throws ResourceNotFoundException{
		 return stockParameterRepository.deleteStockParameter(stockParamId);
	 }
}
