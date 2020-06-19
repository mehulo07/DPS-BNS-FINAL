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

import com.bns.model.ColorMaster;
import com.bns.service.ColorMasterService;

import io.swagger.annotations.ApiModelProperty;

@CrossOrigin()
@RestController
@RequestMapping(value = "DPS/V1/color")
public class ColorMasterController {
	
	@Autowired
	private ColorMasterService colorMasterService;
	
	@GetMapping("/")
	@ApiModelProperty(value = "Get All color",notes = "Retrive all active color list to client.")
	public List<ColorMaster> getAllColor(){
		System.out.println("write by vijay");
		return colorMasterService.getAllColorList();
	}
	
	@PostMapping("/{id}")
	public ColorMaster getColorById(@PathVariable(value="id") String colorId ) {
		return colorMasterService.getColorDetailById(colorId);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> addColor(@RequestBody ColorMaster colorMaster) {
		if(colorMasterService.addColor(colorMaster)) 
			return ResponseEntity.ok().body("New color added to list");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("New color is not addded to List.");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> inactiveColor(@PathVariable(value="id") String colorId ) throws SQLException {
		if(colorMasterService.inactiveColor(colorId)) 
			return ResponseEntity.ok().body("Color is inactivated");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception while inactivate color.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateColor(@PathVariable(value="id") String colorId  , @RequestBody ColorMaster colorMaster) {
		if(colorMasterService.updateColor(colorMaster,colorId)) 
			return ResponseEntity.ok().body("Color updated with new value");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception while update color.");
	}
	
	
}
