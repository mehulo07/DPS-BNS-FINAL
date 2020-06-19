package com.bns.dto;

import java.io.Serializable;
import java.util.List;

public class DashboardClientRequest implements Serializable{
	
	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> categoryList=null;
	private int year;
	private int monthFrom;
	private int monthTo;
	private boolean isSearch;

	public DashboardClientRequest() {
	}
	
	public DashboardClientRequest(List<String> categoryList, int year, int monthFrom, int monthTo, boolean isSearch) {
		this.categoryList = categoryList;
		this.year = year;
		this.monthFrom = monthFrom;
		this.monthTo = monthTo;
		this.isSearch = isSearch;
	}

	public List<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonthFrom() {
		return monthFrom;
	}

	public void setMonthFrom(int monthFrom) {
		this.monthFrom = monthFrom;
	}

	public int getMonthTo() {
		return monthTo;
	}

	public void setMonthTo(int monthTo) {
		this.monthTo = monthTo;
	}

	public boolean isSearch() {
		return isSearch;
	}

	public void setSearch(boolean isSearch) {
		this.isSearch = isSearch;
	}

	@Override
	public String toString() {
		return "ClientRequest [categoryList=" + categoryList + ", year=" + year + ", monthFrom=" + monthFrom
				+ ", monthTo=" + monthTo + ", isSearch=" + isSearch + "]";
	}
	
}
