package com.bns.dto;

import java.io.Serializable;
import java.util.List;

public class FilterParam implements Serializable{

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;
		
	private int year;
	private List<Integer> month;
	private String status;
	private boolean search;
	private List<String> catalog_no;
	private List<String> categoryId;
	
	public FilterParam() {
	}

	public FilterParam(int year, List<Integer> month, String status, boolean search, List<String> catalog_no,
			List<String> categoryId) {
		this.year = year;
		this.month = month;
		this.status = status;
		this.search = search;
		this.catalog_no = catalog_no;
		this.categoryId = categoryId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Integer> getMonth() {
		return month;
	}

	public void setMonth(List<Integer> month) {
		this.month = month;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isSearch() {
		return search;
	}

	public void setSearch(boolean search) {
		this.search = search;
	}

	public List<String> getCatalog_no() {
		return catalog_no;
	}

	public void setCatalog_no(List<String> catalog_no) {
		this.catalog_no = catalog_no;
	}

	public List<String> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<String> categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "FilterParam [year=" + year + ", month=" + month + ", status=" + status + ", search=" + search
				+ ", catalog_no=" + catalog_no + ", categoryId=" + categoryId + "]";
	}
	
}
