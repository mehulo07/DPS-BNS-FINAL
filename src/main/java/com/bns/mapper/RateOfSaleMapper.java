package com.bns.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bns.model.CategoryInfo;
import com.bns.model.RateofSale;

public class RateOfSaleMapper implements RowMapper<RateofSale> {

	@Override
	public RateofSale mapRow(ResultSet rs, int rowNum) throws SQLException {
		RateofSale rateofSale = new RateofSale();
		rateofSale.setRateOfProductSaleId(rs.getString("RATE_OF_PRODUCT_SALE_ID") == null ? "" : rs.getString("RATE_OF_PRODUCT_SALE_ID"));
		rateofSale.setProductCategoryId(rs.getString("PROD_CAT_ID") == null ? "" : rs.getString("PROD_CAT_ID"));
		rateofSale.setProductCategoryName(rs.getString("PROD_CAT_NAME") == null ? "" : rs.getString("PROD_CAT_NAME"));
		rateofSale.setProductName(rs.getString("PRODUCT_NAME") == null ? "" : rs.getString("PRODUCT_NAME"));
		rateofSale.setLaxPartNumber(rs.getString("LAX_PART_NUMBER") == null ? "" : rs.getString("LAX_PART_NUMBER"));
		rateofSale.setStockCurrentStock(rs.getString("STOCK_CURRENT_STOCK") == null ? "" : rs.getString("STOCK_CURRENT_STOCK"));
		rateofSale.setWeekOfCover(rs.getString("STOCK_WEEK_OF_COVER") == null ? "" : rs.getString("STOCK_WEEK_OF_COVER"));
		rateofSale.setWeekOfCover(rs.getString("STOCK_PALLETS") == null ? "" : rs.getString("STOCK_PALLETS"));
		rateofSale.setInTransitStockQtyOrdered(rs.getString("IN_TRANSIT_STOCK_QTY_ORDERED") == null ? "" : rs.getString("IN_TRANSIT_STOCK_QTY_ORDERED"));
		rateofSale.setInTransitStockQtyReceived(rs.getString("IN_TRANSIT_STOCK_QTY_RECEIVED") == null ? "" : rs.getString("IN_TRANSIT_STOCK_QTY_RECEIVED"));
		rateofSale.setInTransitWeekOfCover(rs.getString("IN_TRANSIT_STOCK_WEEK_OF_COVER") == null ? "" : rs.getString("IN_TRANSIT_STOCK_WEEK_OF_COVER"));
		rateofSale.setInTransitStockPallets(rs.getString("IN_TRANSIT_STOCK_PALLETS") == null ? "" : rs.getString("IN_TRANSIT_STOCK_PALLETS"));
		rateofSale.setInTransitStockDeliveryDate(rs.getString("IN_TRANSIT_STOCK_DELIVERY_DATE") == null ? "" : rs.getString("IN_TRANSIT_STOCK_DELIVERY_DATE"));
		rateofSale.setInTransitStockReceivedDate(rs.getString("IN_TRANSIT_STOCK_RECEIVED_DATE") == null ? "" : rs.getString("IN_TRANSIT_STOCK_RECEIVED_DATE"));
		rateofSale.setLeadTime(rs.getString("LEAD_TIME") == null ? "" : rs.getString("LEAD_TIME"));
		rateofSale.setCurrentMonthPurchasedPrice(rs.getString("CURRENT_MONTH_PURCHASED_PRICE") == null ? "" : rs.getString("CURRENT_MONTH_PURCHASED_PRICE"));
		rateofSale.setCurrentMonthSupplierName(rs.getString("CURRENT_MONTH_SUPPLIER_NAME") == null ? "" : rs.getString("CURRENT_MONTH_SUPPLIER_NAME"));
		rateofSale.setCurrentMonthCountry(rs.getString("CURRENT_MONTH_COUNTRY") == null ? "" : rs.getString("CURRENT_MONTH_COUNTRY"));
		rateofSale.setPrevMonthSupplierName(rs.getString("PREV_MONTH_SUPPLIER_NAME") == null ? "" : rs.getString("PREV_MONTH_SUPPLIER_NAME"));
		rateofSale.setPrevMonthCountry(rs.getString("PREV_MONTH_COUNTRY") == null ? "" : rs.getString("PREV_MONTH_COUNTRY"));
		rateofSale.setUnitSoldPerDay(rs.getString("UNITS_SOLD_PER_DAY") == null ? "" : rs.getString("UNITS_SOLD_PER_DAY"));
		rateofSale.setUnitSoldPerWeek(rs.getString("UNITS_SOLD_PER_WEEK") == null ? "" : rs.getString("UNITS_SOLD_PER_WEEK"));
		rateofSale.setTwelveWeekTrendUnit(rs.getString("TWELVE_WEEK_TREND_UNITS") == null ? "" : rs.getString("TWELVE_WEEK_TREND_UNITS"));
		rateofSale.setAvgPrice(rs.getString("AVG_PRICE") == null ? "" : rs.getString("AVG_PRICE"));
		rateofSale.setTaxRate(rs.getString("TAX_RATE") == null ? "" : rs.getString("TAX_RATE"));
		rateofSale.setMonthOne(rs.getString("MONTH_ONE") == null ? "" : rs.getString("MONTH_ONE"));
		rateofSale.setMonthTwo(rs.getString("MONTH_TWO") == null ? "" : rs.getString("MONTH_TWO"));
		rateofSale.setMonthThree(rs.getString("MONTH_THREE") == null ? "" : rs.getString("MONTH_THREE"));
		rateofSale.setMonthFour(rs.getString("MONTH_FOUR") == null ? "" : rs.getString("MONTH_FOUR"));
		rateofSale.setMonthFive(rs.getString("MONTH_FIVE") == null ? "" : rs.getString("MONTH_FIVE"));
		rateofSale.setMonthSix(rs.getString("MONTH_SIX") == null ? "" : rs.getString("MONTH_SIX"));
		rateofSale.setMonthSeven(rs.getString("MONTH_SEVEN") == null ? "" : rs.getString("MONTH_SEVEN"));
		rateofSale.setMonthEight(rs.getString("MONTH_EIGHT") == null ? "" : rs.getString("MONTH_EIGHT"));
		rateofSale.setMonthNine(rs.getString("MONTH_NINE") == null ? "" : rs.getString("MONTH_NINE"));
		rateofSale.setMonthTen(rs.getString("MONTH_TEN") == null ? "" : rs.getString("MONTH_TEN"));
		rateofSale.setMonthEleven(rs.getString("MONTH_ELEVEN") == null ? "" : rs.getString("MONTH_ELEVEN"));
		rateofSale.setMonthTwelve(rs.getString("MONTH_TWELVE") == null ? "" : rs.getString("MONTH_TWELVE"));
		return rateofSale;
	}

}
