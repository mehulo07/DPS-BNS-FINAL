package com.bns.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bns.model.CategoryInfo;
import com.bns.repository.CategoryInfoRepository;

@Service
public class CategoryInfoService {
	
	@Autowired
	private CategoryInfoRepository categoryInfoRepository;
	
	 public List<CategoryInfo> getAllCategoryList(){
		 return categoryInfoRepository.getAllCategoryList();
	 }
	 
	 public CategoryInfo getCategoryDetailById(String categoryId) {
		 return categoryInfoRepository.getCategoryDetailById(categoryId);
	 }
	 
	 @Transactional
	 public boolean addCategory(CategoryInfo ctegoryInfo) {
		 return categoryInfoRepository.addCategory(ctegoryInfo); 
	 }
	 @Transactional
	 public boolean inactiveCategory(String categoryId) throws SQLException {
		 return categoryInfoRepository.inactiveCategory(categoryId);
	 }
	 
	 @Transactional
	 public boolean updateCategory(CategoryInfo  categoryInfo, String categoryId) {
		 return categoryInfoRepository.updateCategory(categoryInfo, categoryId);
	 }
}
