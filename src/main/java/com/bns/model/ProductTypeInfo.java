package com.bns.model;

import java.io.Serializable;

public class ProductTypeInfo implements Serializable{

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;

	private String productTypeId;
	private String productTypeName;
	private String productTypeDesc;
	private String status;

	public ProductTypeInfo() {
	}

	public ProductTypeInfo(String productTypeId, String productTypeName, String productTypeDesc, String status) {
		this.productTypeId = productTypeId;
		this.productTypeName = productTypeName;
		this.productTypeDesc = productTypeDesc;
		this.status = status;
	}

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public String getProductTypeDesc() {
		return productTypeDesc;
	}

	public void setProductTypeDesc(String productTypeDesc) {
		this.productTypeDesc = productTypeDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductTypeInfo [productTypeId=" + productTypeId + ", productTypeName=" + productTypeName
				+ ", productTypeDesc=" + productTypeDesc + ", status=" + status + "]";
	}
	
}
