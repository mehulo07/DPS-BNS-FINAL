package com.bns.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.model.CategoryInfo;
import com.bns.service.CategoryInfoService;

import io.swagger.annotations.ApiModelProperty;

@RestController
@CrossOrigin()
@RequestMapping(value = "DPS/V1/category")
public class CategotyInfoController {

	@Autowired
	private CategoryInfoService categoryInfoService;
	
	@GetMapping("/")
	@ApiModelProperty(value = "Get All Categoy ",notes = "Retrive all active category list to client.")
	public List<CategoryInfo> getAllCategory(){
		return categoryInfoService.getAllCategoryList();
	}
	
	@GetMapping("/{id}")
	public CategoryInfo getCategoryDetailById(@PathVariable(value="id") String categoryId ) {
		return categoryInfoService.getCategoryDetailById(categoryId);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> addCategory(@RequestBody CategoryInfo categoryInfo) {
		if(categoryInfoService.addCategory(categoryInfo)) 
			return ResponseEntity.ok().body("New category added to list");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("New category is not addded to List.");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> inactiveCategory(@PathVariable(value="id") String categoryId ) throws SQLException {
		if(categoryInfoService.inactiveCategory(categoryId)) 
			return ResponseEntity.ok().body("Category is inactivated");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception while inactivate category.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCategory(@PathVariable(value="id") String categoryId  , @RequestBody CategoryInfo categoryInfo) {
		if(categoryInfoService.updateCategory(categoryInfo,categoryId)) 
			return ResponseEntity.ok().body("Category updated with new value");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception while update category.");
	}
}
