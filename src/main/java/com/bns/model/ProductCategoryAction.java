package com.bns.model;

import java.io.Serializable;

public class ProductCategoryAction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String procductCategory;
	private String stockCategory;
	private String partNo;
	private String partDesc;
	private String csProfit;
	private String csUnits;
	private String csWeeks;
	private String csPallets;
	private String rosUnits;
	private String rosTrend;
	private String itsUnits;
	private String itsWeeks;
	private String itsDelevery;
	private String itsPallets;
	private String bnUnits;
	private String bnWeeks;
	private String bnLead;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProcductCategory() {
		return procductCategory;
	}
	public void setProcductCategory(String procductCategory) {
		this.procductCategory = procductCategory;
	}
	public String getStockCategory() {
		return stockCategory;
	}
	public void setStockCategory(String stockCategory) {
		this.stockCategory = stockCategory;
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public String getPartDesc() {
		return partDesc;
	}
	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}
	public String getCsProfit() {
		return csProfit;
	}
	public void setCsProfit(String csProfit) {
		this.csProfit = csProfit;
	}
	public String getCsUnits() {
		return csUnits;
	}
	public void setCsUnits(String csUnits) {
		this.csUnits = csUnits;
	}
	public String getCsWeeks() {
		return csWeeks;
	}
	public void setCsWeeks(String csWeeks) {
		this.csWeeks = csWeeks;
	}
	public String getCsPallets() {
		return csPallets;
	}
	public void setCsPallets(String csPallets) {
		this.csPallets = csPallets;
	}
	public String getRosUnits() {
		return rosUnits;
	}
	public void setRosUnits(String rosUnits) {
		this.rosUnits = rosUnits;
	}
	public String getRosTrend() {
		return rosTrend;
	}
	public void setRosTrend(String rosTrend) {
		this.rosTrend = rosTrend;
	}
	public String getItsUnits() {
		return itsUnits;
	}
	public void setItsUnits(String itsUnits) {
		this.itsUnits = itsUnits;
	}
	public String getItsWeeks() {
		return itsWeeks;
	}
	public void setItsWeeks(String itsWeeks) {
		this.itsWeeks = itsWeeks;
	}
	public String getItsDelevery() {
		return itsDelevery;
	}
	public void setItsDelevery(String itsDelevery) {
		this.itsDelevery = itsDelevery;
	}
	public String getItsPallets() {
		return itsPallets;
	}
	public void setItsPallets(String itsPallets) {
		this.itsPallets = itsPallets;
	}
	public String getBnUnits() {
		return bnUnits;
	}
	public void setBnUnits(String bnUnits) {
		this.bnUnits = bnUnits;
	}
	public String getBnWeeks() {
		return bnWeeks;
	}
	public void setBnWeeks(String bnWeeks) {
		this.bnWeeks = bnWeeks;
	}
	public String getBnLead() {
		return bnLead;
	}
	public void setBnLead(String bnLead) {
		this.bnLead = bnLead;
	}
	
	@Override
	public String toString() {
		return "ProductCategoryAction [id=" + id + ", procductCategory=" + procductCategory + ", stockCategory="
				+ stockCategory + ", partNo=" + partNo + ", partDesc=" + partDesc + ", csProfit=" + csProfit
				+ ", csUnits=" + csUnits + ", csWeeks=" + csWeeks + ", csPallets=" + csPallets + ", rosUnits="
				+ rosUnits + ", rosTrend=" + rosTrend + ", itsUnits=" + itsUnits + ", itsWeeks=" + itsWeeks
				+ ", itsDelevery=" + itsDelevery + ", itsPallets=" + itsPallets + ", bnUnits=" + bnUnits + ", bnWeeks="
				+ bnWeeks + ", bnLead=" + bnLead + "]";
	}

}
