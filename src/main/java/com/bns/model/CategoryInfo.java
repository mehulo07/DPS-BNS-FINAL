package com.bns.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "CategoryInfo")
public class CategoryInfo implements Serializable{

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;

	private String categoryId;
	private String categoryName;
	private String categoryDescription;
	private String status;

	public CategoryInfo() {
	}

	public CategoryInfo(String categoryId, String categoryName, String categoryDescription, String status) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.status = status;
	}

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

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CategoryInfo [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", status=" + status + "]";
	}
	
	
	
}
