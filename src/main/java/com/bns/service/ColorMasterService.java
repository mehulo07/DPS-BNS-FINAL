package com.bns.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bns.model.ColorMaster;
import com.bns.repository.ColorMasterRepository;

@Service
public class ColorMasterService {
	
	@Autowired
	private ColorMasterRepository colorMasterRepository;
	
	public List<ColorMaster> getAllColorList(){
		return colorMasterRepository.getAllColorList();
	}

	public ColorMaster getColorDetailById(String productTypeId) {
		 return colorMasterRepository.getColorDetailById(productTypeId);
	}
	 
	@Transactional
	public boolean addColor(ColorMaster colorMaster) {
		return colorMasterRepository.addColor(colorMaster); 
	}
	 
	@Transactional
	public boolean inactiveColor(String colorMaster) throws SQLException {
		return colorMasterRepository.inactiveColor(colorMaster);
	}
	 
	@Transactional
	public boolean updateColor(ColorMaster colorMaster, String colorId) {
		return colorMasterRepository.updateColor(colorMaster, colorId);
	}
	
}
