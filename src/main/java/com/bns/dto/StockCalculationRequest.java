package com.bns.dto;

import java.io.Serializable;
import java.util.List;

public class StockCalculationRequest implements Serializable{

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> categoryList;
	private String stockId;
	private boolean isSearch;
	private int currentPage;
	private int rowSize;
	private String searchField;
	private String searchString;
	private String sortOrder;
	private String sortBy;
	private List<Integer> monthArr;
	private int year;
	
	public StockCalculationRequest() {
	
	}

	public StockCalculationRequest(List<String> categoryList, String stockId, boolean isSearch, int currentPage,
			int rowSize, String searchField, String searchString, String sortOrder, String sortBy,
			List<Integer> monthArr, int year) {
		super();
		this.categoryList = categoryList;
		this.stockId = stockId;
		this.isSearch = isSearch;
		this.currentPage = currentPage;
		this.rowSize = rowSize;
		this.searchField = searchField;
		this.searchString = searchString;
		this.sortOrder = sortOrder;
		this.sortBy = sortBy;
		this.monthArr = monthArr;
		this.year = year;
	}


	public List<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public boolean isSearch() {
		return isSearch;
	}

	public void setSearch(boolean isSearch) {
		this.isSearch = isSearch;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public List<Integer> getMonthArr() {
		return monthArr;
	}

	public void setMonthArr(List<Integer> monthArr) {
		this.monthArr = monthArr;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "StockCalculationRequest [categoryList=" + categoryList + ", stockId=" + stockId + ", isSearch="
				+ isSearch + ", currentPage=" + currentPage + ", rowSize=" + rowSize + ", searchField=" + searchField
				+ ", searchString=" + searchString + ", sortOrder=" + sortOrder + ", sortBy=" + sortBy + ", monthArr="
				+ monthArr + ", year=" + year + "]";
	}
	
}
