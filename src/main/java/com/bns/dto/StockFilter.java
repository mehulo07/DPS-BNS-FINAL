package com.bns.dto;

import java.io.Serializable;

public class StockFilter implements Serializable{

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;

	
	private FilterParam filterParam;
	private StockCalculationRequest stockCalculationRequest;
	
	public StockFilter() {
	}

	public StockFilter(FilterParam filterParam, StockCalculationRequest stockCalculationRequest) {
		super();
		this.filterParam = filterParam;
		this.stockCalculationRequest = stockCalculationRequest;
	}

	public FilterParam getFilterParam() {
		return filterParam;
	}

	public void setFilterParam(FilterParam filterParam) {
		this.filterParam = filterParam;
	}

	public StockCalculationRequest getStockCalculationRequest() {
		return stockCalculationRequest;
	}

	public void setStockCalculationRequest(StockCalculationRequest stockCalculationRequest) {
		this.stockCalculationRequest = stockCalculationRequest;
	}

	@Override
	public String toString() {
		return "StockFilter [filterParam=" + filterParam + ", stockCalculationRequest=" + stockCalculationRequest + "]";
	}
	
}
