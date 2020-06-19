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

import com.bns.model.ProductTypeInfo;
import com.bns.service.ProductTypeInfoService;

import io.swagger.annotations.ApiModelProperty;

@RestController
@CrossOrigin()
@RequestMapping(value = "DPS/V1/productType")
public class ProductTypeInfoController {
	
	@Autowired
	private ProductTypeInfoService productTypeInfoService;
	
	@GetMapping("/")
	@ApiModelProperty(value = "Get All product type",notes = "Retrive all active product list list to client.")
	public List<ProductTypeInfo> getAllProductType(){
		return productTypeInfoService.getAllProductTypeList();
	}
	
	@PostMapping("/{id}")
	public ProductTypeInfo getProductTypeDetailById(@PathVariable(value="id") String productTypeId ) {
		return productTypeInfoService.getProductTypeDetailById(productTypeId);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> addProductType(@RequestBody ProductTypeInfo productTypeInfo) {
		if(productTypeInfoService.addProductType(productTypeInfo)) 
			return ResponseEntity.ok().body("New product type added.");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("New category is not addded to List.");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> inactiveProductType(@PathVariable(value="id") String productTypeId ) throws SQLException {
		System.out.println("productTypeId is :"+productTypeId);
		if(productTypeInfoService.inactiveProductType(productTypeId)) 
			return ResponseEntity.ok().body("product type is inactivated");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception while inactivate category.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateProductType(@PathVariable(value="id") String productTypeId  , @RequestBody ProductTypeInfo productTypeInfo) {
		if(productTypeInfoService.updateProductType(productTypeInfo,productTypeId)) 
			return ResponseEntity.ok().body("Category updated with new value");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception while update category.");
	}
	
}
