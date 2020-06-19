package com.bns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.StockParameter;
import com.bns.service.StockParameterService;

import io.swagger.annotations.ApiModelProperty;

@RestController
@CrossOrigin()
@RequestMapping(value = "DPS/V1/StockParameter")
public class StockParameterController {

	@Autowired
	private StockParameterService stockParameterService;
	
	@GetMapping("/")
	@ApiModelProperty(value = "Get All Stock Parameter",notes = "Retrive all active Stock Parameter list to client.")
	public List<StockParameter> getAllStockParameter() throws ResourceNotFoundException{
		return stockParameterService.getAllStockParameterList();
	}
	
	@PostMapping("/{id}")
	@ApiModelProperty(value = "Get Stock Parameter Details",notes = "Retrive active Stock Parameter Details by id to client.")
	public StockParameter getStockParameterById(@PathVariable(value="id") String stockParamId) throws ResourceNotFoundException{
		return stockParameterService.getStockParameterById(stockParamId);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> addStockParameter(@RequestBody StockParameter stockParameter) throws ResourceNotFoundException{
		if(stockParameterService.addStockParameter(stockParameter)) 
			return ResponseEntity.ok("Stock parameter added into system");
		else
			return ResponseEntity.badRequest().body("Exception while adding stock parameter.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateStockParameter(@PathVariable(value = "id") String stockParamId, @RequestBody StockParameter stockParameter) throws ResourceNotFoundException{
		if(stockParameterService.updateStockParameter(stockParamId , stockParameter)) 
			return ResponseEntity.ok("Stock parameter updated sucessfully.");
		else
			return ResponseEntity.badRequest().body("Exception while updating stock parameter.");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStockParam(@PathVariable(value="id") String stockParamId) throws ResourceNotFoundException{
		if(stockParameterService.deleteStockParameter(stockParamId)) 
			return ResponseEntity.ok("Stock parameter deleted sucessfully.");
		else
			return ResponseEntity.badRequest().body("Exception while deleting stock parameter.");
	}
	
}
