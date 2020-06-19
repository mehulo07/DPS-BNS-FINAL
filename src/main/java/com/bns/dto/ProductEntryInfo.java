package com.bns.dto;

import java.io.Serializable;

import com.bns.model.ProductInfo;
import com.bns.model.ProductParamMaster;

public class ProductEntryInfo implements Serializable{

	/**
	 * @author mehul
	 */
	
	private static final long serialVersionUID = 1L;
	
	private ProductParamMaster productParamMaster;
	private ProductInfo productInfo;
	
	public ProductEntryInfo() {
	}

	public ProductEntryInfo(ProductParamMaster productParamMaster, ProductInfo productInfo) {
		this.productParamMaster = productParamMaster;
		this.productInfo = productInfo;
	}

	public ProductParamMaster getProductParamMaster() {
		return productParamMaster;
	}

	public void setProductParamMaster(ProductParamMaster productParamMaster) {
		this.productParamMaster = productParamMaster;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	@Override
	public String toString() {
		return "MultipleProductEntryInfo [productParamMaster=" + productParamMaster + ", productInfo=" + productInfo
				+ "]";
	} 
	
}
