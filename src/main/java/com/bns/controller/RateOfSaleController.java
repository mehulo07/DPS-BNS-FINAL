package com.bns.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bns.model.CategoryInfo;
import com.bns.model.RateofSale;
import com.bns.service.ProductTypeInfoService;
import com.bns.service.RateOfSaleService;

import io.swagger.annotations.ApiModelProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
@RequestMapping(value = "DPS/V1/rateofsale")
public class RateOfSaleController {

	@Autowired
	private RateOfSaleService rateOfSaleService;

	@GetMapping("/{categoryId}")
	@ApiModelProperty(value = "Get All Rate of Sale  ", notes = "Retrive all  data for rate of sell screen")
	public List<RateofSale> getAllRateOfSaleRecord(@PathVariable(value = "categoryId") String categoryId) {
		return rateOfSaleService.getRateOfSaleListByCategoryID(categoryId);
	}

	@GetMapping("/search/{categoryId}/{productName}")
	@ApiModelProperty(value = "Get All Searched Record ", notes = "Get All Record based on CategoryId Searched Product Name")
	public List<RateofSale> getAllRateOfSaleSearchedRecord(@PathVariable(value = "categoryId") String categoryId,
			@PathVariable(value = "productName") String productName) {
		return rateOfSaleService.getRateOfSaleListByCategoryIDAndProductName(categoryId, productName);
	}

		

	@GetMapping(value = "/download/")
	@ApiModelProperty(value = "Get All Record Excel ", notes = "Get Excel File")
	public ResponseEntity<InputStreamResource>  getAllRateOfSaleSearchedRecordExcel(
			@RequestParam("categoryId") String categoryId,
			@RequestParam("productName") String productName,
			@RequestParam("columns") String columns) throws IOException{
		List<RateofSale> rateofSaleList = null;
		
		if(!(productName=="" || productName==null))
		
			rateofSaleList = rateOfSaleService.getRateOfSaleListByCategoryIDAndProductName(categoryId,
				productName);
		else {
			rateofSaleList = rateOfSaleService.getRateOfSaleListByCategoryID(categoryId);
		}
		
		if(rateofSaleList!=null && rateofSaleList.size()>0) {
			ByteArrayInputStream in = rateOfSaleService.customersToExcel(rateofSaleList,columns);
			// return IOUtils.toByteArray(in);
			HttpHeaders headers = new org.springframework.http.HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=report.xlsx");
			DateFormat dform =  new SimpleDateFormat("dd/MM/yy"); 
			Date obj = new Date();
			String FILE_NAME ="Report-"+dform.format(obj);
			  Workbook workbook = new XSSFWorkbook(); 
			//  return rateOfSaleService.getRateOfSaleListByCategoryIDAndPruductName(categoryId,productName);
			 
			  return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
		}
		return null;
		
	}

}
