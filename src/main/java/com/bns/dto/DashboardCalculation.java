package com.bns.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class DashboardCalculation implements Serializable {

	/**
	 * @author mehul 
	 */
	private static final long serialVersionUID = 1L;
	
	private String categoryId;
	private String categoryName;
	private LinkedHashMap<String , HashMap<Integer, Integer>> categoryWiseData  = new LinkedHashMap();
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public LinkedHashMap<String, HashMap<Integer, Integer>> getCategoryWiseData() {
		return categoryWiseData;
	}
	public void setCategoryWiseData(LinkedHashMap<String, HashMap<Integer, Integer>> categoryWiseData) {
		this.categoryWiseData = categoryWiseData;
	}
	@Override
	public String toString() {
		return "DashboardCalculation [categoryId=" + categoryId + ", categoryName=" + categoryName
				+ ", categoryWiseData=" + categoryWiseData + "]";
	}
}
