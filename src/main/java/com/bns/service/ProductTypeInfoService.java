package com.bns.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bns.model.ProductTypeInfo;
import com.bns.repository.ProductTypeInfoRepository;

@Service
public class ProductTypeInfoService {
	
	@Autowired
	private ProductTypeInfoRepository productTypeInfoRepository; 
		
	
	 public List<ProductTypeInfo> getAllProductTypeList(){
		 return productTypeInfoRepository.getAllProductTypeList();
	 }
	 
	 public ProductTypeInfo getProductTypeDetailById(String productTypeId) {
		 return productTypeInfoRepository.getProductTypeDetailById(productTypeId);
	 }
	 
	 @Transactional
	 public boolean addProductType(ProductTypeInfo productTypeInfo) {
		 return productTypeInfoRepository.addProductType(productTypeInfo); 
	 }
	 
	 @Transactional
	 public boolean inactiveProductType(String productTypeId) throws SQLException {
		 return productTypeInfoRepository.inactiveProductType(productTypeId);
	 }
	 
	 @Transactional
	 public boolean updateProductType(ProductTypeInfo productTypeInfo, String productTypeId) {
		 return productTypeInfoRepository.updateProductType(productTypeInfo, productTypeId);
	 }
	
}
