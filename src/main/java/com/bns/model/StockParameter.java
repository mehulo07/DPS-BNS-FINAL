package com.bns.model;

import java.io.Serializable;

public class StockParameter implements Serializable {

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;
	
	private String stockParamId;
	private String stockParamName;
	private String stockParamDesc;
	private String status;
	private String stockParamColorId;

	public StockParameter() {
	}

	public StockParameter(String stockParamId, String stockParamName, String stockParamDesc, String status,
			String stockParamColorId) {
		this.stockParamId = stockParamId;
		this.stockParamName = stockParamName;
		this.stockParamDesc = stockParamDesc;
		this.status = status;
		this.stockParamColorId = stockParamColorId;
	}

	public String getStockParamId() {
		return stockParamId;
	}

	public void setStockParamId(String stockParamId) {
		this.stockParamId = stockParamId;
	}

	public String getStockParamName() {
		return stockParamName;
	}

	public void setStockParamName(String stockParamName) {
		this.stockParamName = stockParamName;
	}

	public String getStockParamDesc() {
		return stockParamDesc;
	}

	public void setStockParamDesc(String stockParamDesc) {
		this.stockParamDesc = stockParamDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStockParamColorId() {
		return stockParamColorId;
	}

	public void setStockParamColorId(String stockParamColorId) {
		this.stockParamColorId = stockParamColorId;
	}

	@Override
	public String toString() {
		return "StockParameter [stockParamId=" + stockParamId + ", stockParamName=" + stockParamName
				+ ", stockParamDesc=" + stockParamDesc + ", status=" + status + ", stockParamColorId="
				+ stockParamColorId + "]";
	}

}
