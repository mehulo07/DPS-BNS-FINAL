package com.bns.model;

import java.io.Serializable;

public class PieChartData implements Serializable{

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;
	
	private String categoryId;
	private String categoryDesc;
	private long csUnit;
	private long totalUnit;
	private float percentage;

	public PieChartData() {
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public long getCsUnit() {
		return csUnit;
	}

	public void setCsUnit(long csUnit) {
		this.csUnit = csUnit;
	}

	public long getTotalUnit() {
		return totalUnit;
	}

	public void setTotalUnit(long totalUnit) {
		this.totalUnit = totalUnit;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "PieChartData [categoryId=" + categoryId + ", categoryDesc=" + categoryDesc + ", csUnit=" + csUnit
				+ ", totalUnit=" + totalUnit + ", percentage=" + percentage + "]";
	}
		
}
