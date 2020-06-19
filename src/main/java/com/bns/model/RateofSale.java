package com.bns.model;

import java.io.Serializable;
import java.util.Date;

public class RateofSale implements Serializable {

	/**
	 * @author vijay parmar
	 */
	private static final long serialVersionUID = 06664554541L;
	
	private String rateOfProductSaleId;
	
	//one to one
	private String productCategoryId;
		
	private String productCategoryName;
	
	private String productName;
		
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	private String laxPartNumber;
		
	private String stockCurrentStock;
		
	private String weekOfCover;
		
	private String stockPalletes;
		
	private String inTransitStockQtyOrdered;
		
	private String inTransitStockQtyReceived;
		
	private String inTransitWeekOfCover;
		
	private String inTransitStockPallets;
		
	private String inTransitStockDeliveryDate;
		
	private String inTransitStockReceivedDate;
		
	private String leadTime;
		
	private String currentMonthPurchasedPrice;
		
	private String currentMonthCountry;
		
	private String currentMonthSupplierName;
		
	private String prevMonthSupplierName;
		
	private String prevMonthCountry;
		
	private String unitSoldPerDay;
		
	private String unitSoldPerWeek;
		
	private String TwelveWeekTrendUnit;
		
	private String avgPrice;
		
	private String taxRate;
		
	private String monthOne;
		
	private String monthTwo;
		
	private String monthThree;
		
	private String monthFour;
		
	private String monthFive;
		
	private String monthSix;
		
	private String monthSeven;
		
	private String monthEight;
		
	private String monthNine;
		
	private String monthTen;
		
	private String monthEleven;
		
	private String monthTwelve;
		
	public RateofSale() {
		}

	public String getRateOfProductSaleId() {
			return rateOfProductSaleId;
		}

	public void setRateOfProductSaleId(String rateOfProductSaleId) {
			this.rateOfProductSaleId = rateOfProductSaleId;
		}

	public String getProductCategoryId() {
			return productCategoryId;
		}

	public void setProductCategoryId(String productCategoryId) {
			this.productCategoryId = productCategoryId;
		}

	public String getLaxPartNumber() {
			return laxPartNumber;
		}

	public void setLaxPartNumber(String laxPartNumber) {
			this.laxPartNumber = laxPartNumber;
		}

	public String getStockCurrentStock() {
			return stockCurrentStock;
		}

	public void setStockCurrentStock(String stockCurrentStock) {
			this.stockCurrentStock = stockCurrentStock;
		}

	public String getWeekOfCover() {
			return weekOfCover;
		}

	public void setWeekOfCover(String weekOfCover) {
			this.weekOfCover = weekOfCover;
		}

	public String getStockPalletes() {
			return stockPalletes;
		}

	public void setStockPalletes(String stockPalletes) {
			this.stockPalletes = stockPalletes;
		}

	public String getInTransitStockQtyOrdered() {
			return inTransitStockQtyOrdered;
		}

	public void setInTransitStockQtyOrdered(String inTransitStockQtyOrdered) {
			this.inTransitStockQtyOrdered = inTransitStockQtyOrdered;
		}

	public String getInTransitStockQtyReceived() {
			return inTransitStockQtyReceived;
		}

	public void setInTransitStockQtyReceived(String inTransitStockQtyReceived) {
			this.inTransitStockQtyReceived = inTransitStockQtyReceived;
		}

	public String getInTransitWeekOfCover() {
			return inTransitWeekOfCover;
		}

	public void setInTransitWeekOfCover(String inTransitWeekOfCover) {
			this.inTransitWeekOfCover = inTransitWeekOfCover;
		}

	public String getInTransitStockPallets() {
			return inTransitStockPallets;
		}

	public void setInTransitStockPallets(String inTransitStockPallets) {
			this.inTransitStockPallets = inTransitStockPallets;
		}

	public String getInTransitStockDeliveryDate() {
			return inTransitStockDeliveryDate;
		}

	public void setInTransitStockDeliveryDate(String inTransitStockDeliveryDate) {
			this.inTransitStockDeliveryDate = inTransitStockDeliveryDate;
		}

	public String getInTransitStockReceivedDate() {
			return inTransitStockReceivedDate;
		}

	public void setInTransitStockReceivedDate(String inTransitStockReceivedDate) {
			this.inTransitStockReceivedDate = inTransitStockReceivedDate;
		}

	public String getLeadTime() {
			return leadTime;
		}

	public void setLeadTime(String leadTime) {
			this.leadTime = leadTime;
		}

	public String getCurrentMonthPurchasedPrice() {
			return currentMonthPurchasedPrice;
		}

	public void setCurrentMonthPurchasedPrice(String currentMonthPurchasedPrice) {
			this.currentMonthPurchasedPrice = currentMonthPurchasedPrice;
		}

	public String getCurrentMonthCountry() {
			return currentMonthCountry;
		}

	public void setCurrentMonthCountry(String currentMonthCountry) {
			this.currentMonthCountry = currentMonthCountry;
		}

		public String getPrevMonthSupplierName() {
			return prevMonthSupplierName;
		}

		public void setPrevMonthSupplierName(String prevMonthSupplierName) {
			this.prevMonthSupplierName = prevMonthSupplierName;
		}

		public String getPrevMonthCountry() {
			return prevMonthCountry;
		}

		public void setPrevMonthCountry(String prevMonthCountry) {
			this.prevMonthCountry = prevMonthCountry;
		}

		public String getUnitSoldPerDay() {
			return unitSoldPerDay;
		}

		public void setUnitSoldPerDay(String unitSoldPerDay) {
			this.unitSoldPerDay = unitSoldPerDay;
		}

		public String getUnitSoldPerWeek() {
			return unitSoldPerWeek;
		}

		public void setUnitSoldPerWeek(String unitSoldPerWeek) {
			this.unitSoldPerWeek = unitSoldPerWeek;
		}

		public String getTwelveWeekTrendUnit() {
			return TwelveWeekTrendUnit;
		}

		public void setTwelveWeekTrendUnit(String twelveWeekTrendUnit) {
			TwelveWeekTrendUnit = twelveWeekTrendUnit;
		}

		public String getAvgPrice() {
			return avgPrice;
		}

		public void setAvgPrice(String avgPrice) {
			this.avgPrice = avgPrice;
		}

		public String getTaxRate() {
			return taxRate;
		}

		public void setTaxRate(String taxRate) {
			this.taxRate = taxRate;
		}

		public String getMonthOne() {
			return monthOne;
		}

		public void setMonthOne(String monthOne) {
			this.monthOne = monthOne;
		}

		public String getMonthTwo() {
			return monthTwo;
		}

		public void setMonthTwo(String monthTwo) {
			this.monthTwo = monthTwo;
		}

		public String getMonthThree() {
			return monthThree;
		}

		public void setMonthThree(String monthThree) {
			this.monthThree = monthThree;
		}

		public String getMonthFour() {
			return monthFour;
		}

		public void setMonthFour(String monthFour) {
			this.monthFour = monthFour;
		}

		public String getMonthFive() {
			return monthFive;
		}

		public void setMonthFive(String monthFive) {
			this.monthFive = monthFive;
		}

		public String getMonthSix() {
			return monthSix;
		}

		public void setMonthSix(String monthSix) {
			this.monthSix = monthSix;
		}

		public String getMonthSeven() {
			return monthSeven;
		}

		public void setMonthSeven(String monthSeven) {
			this.monthSeven = monthSeven;
		}

		public String getMonthEight() {
			return monthEight;
		}

		public void setMonthEight(String monthEight) {
			this.monthEight = monthEight;
		}

		public String getMonthNine() {
			return monthNine;
		}

		public void setMonthNine(String monthNine) {
			this.monthNine = monthNine;
		}

		public String getMonthTen() {
			return monthTen;
		}

		public void setMonthTen(String monthTen) {
			this.monthTen = monthTen;
		}

		public String getMonthEleven() {
			return monthEleven;
		}

		public void setMonthEleven(String monthEleven) {
			this.monthEleven = monthEleven;
		}

		public String getMonthTwelve() {
			return monthTwelve;
		}

		public void setMonthTwelve(String monthTwelve) {
			this.monthTwelve = monthTwelve;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public String getCurrentMonthSupplierName() {
			return currentMonthSupplierName;
		}

		public void setCurrentMonthSupplierName(String currentMonthSupplierName) {
			this.currentMonthSupplierName = currentMonthSupplierName;
		}
		
		public String getProductCategoryName() {
			return productCategoryName;
		}

		public void setProductCategoryName(String productCategoryName) {
			this.productCategoryName = productCategoryName;
		}
		
		
		
		
	
	

}
