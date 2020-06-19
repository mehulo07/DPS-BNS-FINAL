package com.bns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.model.CategoryInfo;
import com.bns.model.RateofSale;
import com.bns.service.ProductTypeInfoService;
import com.bns.service.RateOfSaleService;

import io.swagger.annotations.ApiModelProperty;

@RestController
@CrossOrigin()
@RequestMapping(value = "DPS/V1/rateofsale")
public class RateOfSaleController {
	
	@Autowired
	private RateOfSaleService rateOfSaleService;
	
	@PostMapping("/{categoryId}")
	@ApiModelProperty(value = "Get All Rate of Sale  ",notes = "Retrive all  data for rate of sell screen")
	public List<RateofSale> getAllRateOfSaleRecord(@PathVariable(value="categoryId") String categoryId){
		return rateOfSaleService.getRateOfSaleListByCategoryID(categoryId);
	}
	
	@PostMapping("/search/{categoryId}/{productName}")
	@ApiModelProperty(value = "Get All Record  ",notes = "Get All Record based on CategoryId Searched Product Name")
	public List<RateofSale> getAllRateOfSaleSearchedRecord(@PathVariable(value="categoryId") String categoryId,
			@PathVariable(value="productName") String productName)
	{
		return rateOfSaleService.getRateOfSaleListByCategoryIDAndPruductName(categoryId,productName);
	}

}
