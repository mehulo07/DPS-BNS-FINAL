package com.bns.dto;

import java.io.Serializable;
import java.util.List;

import com.bns.model.ProductInfo;
import com.bns.model.ProductParamMaster;

public class CategoryEntryInfo implements Serializable {

	/**
	 *  @author mehul
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductParamMaster productParamMaster;
	private List<ProductInfo> listOfProductInfo;
	
	public CategoryEntryInfo() {
	}

	public CategoryEntryInfo(ProductParamMaster productParamMaster, List<ProductInfo> listOfProductInfo) {
		this.productParamMaster = productParamMaster;
		this.listOfProductInfo = listOfProductInfo;
	}

	public ProductParamMaster getProductParamMaster() {
		return productParamMaster;
	}

	public void setProductParamMaster(ProductParamMaster productParamMaster) {
		this.productParamMaster = productParamMaster;
	}

	public List<ProductInfo> getListOfProductInfo() {
		return listOfProductInfo;
	}

	public void setListOfProductInfo(List<ProductInfo> listOfProductInfo) {
		this.listOfProductInfo = listOfProductInfo;
	}

	@Override
	public String toString() {
		return "CategoryEntryInfo [productParamMaster=" + productParamMaster + ", listOfProductInfo="
				+ listOfProductInfo + "]";
	}
	
}
