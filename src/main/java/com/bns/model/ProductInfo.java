package com.bns.model;

import java.io.Serializable;

public class ProductInfo implements Serializable {

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 8096340022868708880L;
	
	private String catalogNo;
	private String productDesc;
	private String category;
	private String contract;
	private String ncsoProfitableFlag;
	private String leadTime;
	private int limit;
	
	public ProductInfo() {
	}
	
	public ProductInfo(String catalogNo, String productDesc, String category, String contract,
			String ncsoProfitableFlag, String leadTime, int limit) {
		this.catalogNo = catalogNo;
		this.productDesc = productDesc;
		this.category = category;
		this.contract = contract;
		this.ncsoProfitableFlag = ncsoProfitableFlag;
		this.leadTime = leadTime;
		this.limit = limit;
	}

	public String getCatalogNo() {
		return catalogNo;
	}
	public void setCatalogNo(String catalogNo) {
		this.catalogNo = catalogNo;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getNcsoProfitableFlag() {
		return ncsoProfitableFlag;
	}
	public void setNcsoProfitableFlag(String ncsoProfitableFlag) {
		this.ncsoProfitableFlag = ncsoProfitableFlag;
	}
	public String getLeadTime() {
		return leadTime;
	}
	public void setLeadTime(String leadTime) {
		this.leadTime = leadTime;
	}

	@Override
	public String toString() {
		return "ProductInfo [catalogNo=" + catalogNo + ", productDesc=" + productDesc + ", category=" + category
				+ ", contract=" + contract + ", ncsoProfitableFlag=" + ncsoProfitableFlag + ", leadTime=" + leadTime
				+ ", limit=" + limit + "]";
	}

}
