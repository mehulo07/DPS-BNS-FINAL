package com.bns.service;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.dto.RateOfSaleRequest;
import com.bns.dto.StockCalculationRequest;
import com.bns.model.ProductCategoryAction;
import com.bns.model.RateofSale;
import com.bns.repository.RateOfSaleRepository;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Service
public class RateOfSaleService {
	
	@Autowired
	private RateOfSaleRepository rateOfSaleRepository;
	
	public List<RateofSale> getRateOfSaleListByCategoryIDWithPagination(String categoryId,String startIndex, String endIndex) {
		
		 return rateOfSaleRepository.getAllRateOfSaleByCategoryIDWithPagination(categoryId,startIndex,endIndex);
	 }
	
	public List<RateofSale> getRateOfSaleListByCategoryID(String categoryId) {
		
		 return rateOfSaleRepository.getAllRateOfSaleByCategoryID(categoryId);
	 }
	
	
	public List<RateofSale> getRateOfSaleListByCategoryIDAndProductName(String categoryId,String productName) {
		
		 return rateOfSaleRepository.getAllRateOfSaleByCategoryIDAndProductName(categoryId,productName);
	 }
	
	public ByteArrayInputStream customersToExcel(List<RateofSale> rateofSaleList,
			String sectionSelection) throws IOException  {
		
		sectionSelection = "STOCK,IN TRANSIT STOCK,LEAD TIME,CURRENT PURCHASE,PREVIOUS PURCHASE,RATE OF SALE,12-MONTH USAGE";
	    
		/*
		 * String[] COLUMNs = { "STOCK", "IN TRANSIT STOCK", "LEAD TIME",
		 * "CURRENT PURCHASE", "PREVIOUS PURCHASE", "RATE OF SALE", "12-MONTH USAGE"};
		 */
	    try(Workbook workbook = new XSSFWorkbook();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ){
	      CreationHelper createHelper = workbook.getCreationHelper();
	   
	      Sheet sheet = workbook.createSheet("Report");
	      Row headerRow = sheet.createRow(0);
	      Row subHeaderRow = sheet.createRow(1);
	      sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
	      Cell cell = headerRow.createCell(0);
	      Font headerFont = workbook.createFont();
	      headerFont.setBold(true);
	      headerFont.setColor(IndexedColors.BLACK.getIndex());
	      CellStyle headerCellStyle = workbook.createCellStyle();
	      cell.setCellStyle(headerCellStyle);
	      cell.setCellValue("STOCK");
	      headerCellStyle.setFont(headerFont);
	      
	      
	      Cell subCell = subHeaderRow.createCell(0);
	      subCell.setCellValue("PRODUCT CATEGORY");
	      subCell = subHeaderRow.createCell(1);
	      subCell.setCellValue("LAX PART NUMBER");
	      
	      subCell = subHeaderRow.createCell(2);
	      subCell.setCellValue("PRODUCT NAME");
	      
	      subCell = subHeaderRow.createCell(3);
	      subCell.setCellValue("CURRENT STOCK (NO. OF UNITS)");
	      subCell = subHeaderRow.createCell(4);
	      subCell.setCellValue("WEEKS OF COVER");
	      
	      subCell = subHeaderRow.createCell(5);
	      subCell.setCellValue("NO. OF PALLETS");
	      
	      
	      
	      
	      
			/*
			 * if(StringUtils.containsIgnoreCase(sectionSelection, "STOCK")){
			 * sheet.addMergedRegion(new CellRangeAddress(0,0,6,9));
			 * cell.setCellStyle(headerCellStyle); Cell inTransitStockCell =
			 * headerRow.createCell(1); inTransitStockCell.setCellValue("IN TRANSIT STOCK");
			 * }
			 */
	      if(StringUtils.containsIgnoreCase(sectionSelection, "IN TRANSIT STOCK")){
	    	  sheet.addMergedRegion(new CellRangeAddress(0,0,6,9));
	    	  cell = headerRow.createCell(1);
	    	  cell.setCellStyle(headerCellStyle);
	    	  cell.setCellValue("IN TRANSIT STOCK");
	    	  
	    	  subCell = subHeaderRow.createCell(6);
	 	      subCell.setCellValue("QUANTITY ORDERED");  
	 	      subCell = subHeaderRow.createCell(7);
	 	      subCell.setCellValue("WEEKS OF COVER");
	 	      subCell = subHeaderRow.createCell(8);
	 	      subCell.setCellValue("NO. OF PALLETS");
	 	      subCell = subHeaderRow.createCell(9);
	 	      subCell.setCellValue("DELIVERY DATE");
	 	      
	 	      
	    	  
	      }
	      
	      if(StringUtils.containsIgnoreCase(sectionSelection, "LEAD TIME")){
	    	  cell = headerRow.createCell(2);
	    	  cell.setCellStyle(headerCellStyle);
	    	  cell.setCellValue("LEAD TIME");
	    	  subCell = subHeaderRow.createCell(10);
	 	      subCell.setCellValue("LEAD TIME (IN WEEKS)");  
	 	      
	 	      
	      }    
	   
	      if(StringUtils.containsIgnoreCase(sectionSelection, "CURRENT PURCHASE")){
	    	  sheet.addMergedRegion(new CellRangeAddress(0,0,11,13));
	    	  cell = headerRow.createCell(3);
	    	  cell.setCellStyle(headerCellStyle);
	    	  cell.setCellValue("CURRENT PURCHASE");
	    	  
	    	  subCell = subHeaderRow.createCell(11);
	 	      subCell.setCellValue("PURCHASE PRICE £");  
	 	      subCell = subHeaderRow.createCell(12);
	 	      subCell.setCellValue("SUPPLIER NAME");
	 	      subCell = subHeaderRow.createCell(13);
	 	      subCell.setCellValue("COUNTRY");
	      }   
	      
	      if(StringUtils.containsIgnoreCase(sectionSelection, "PREVIOUS  PURCHASE")){
	    	  sheet.addMergedRegion(new CellRangeAddress(0,0,14,16));
	    	  cell = headerRow.createCell(4);
	    	  cell.setCellStyle(headerCellStyle);
	    	  cell.setCellValue("PREVIOUS  PURCHASE");
	    	  
	    	  subCell = subHeaderRow.createCell(14);
	 	      subCell.setCellValue("PURCHASE PRICE £");  
	 	      subCell = subHeaderRow.createCell(15);
	 	      subCell.setCellValue("SUPPLIER NAME");
	 	      subCell = subHeaderRow.createCell(16);
	 	      subCell.setCellValue("COUNTRY");
	      }  
	      
	      if(StringUtils.containsIgnoreCase(sectionSelection, "RATE OF SALE")){
	    	  sheet.addMergedRegion(new CellRangeAddress(0,0,17,21));
	    	  cell = headerRow.createCell(5);
	    	  cell.setCellStyle(headerCellStyle);
	    	  cell.setCellValue("RATE OF SALE");
	    	  
	    	  
	    	  subCell = subHeaderRow.createCell(17);
	 	      subCell.setCellValue("UNITS SOLD PER DAY");  
	 	      
	 	      subCell = subHeaderRow.createCell(18);
	 	      subCell.setCellValue("UNITS SOLD PER WEEK");
	 	      
	 	      subCell = subHeaderRow.createCell(19);
	 	      subCell.setCellValue(" 12-WEEK TREND (IN UNITS)");
	 	      
	 	      subCell = subHeaderRow.createCell(20);
	 	      subCell.setCellValue("AVERAGE PRICE");
	 	      
	 	      subCell = subHeaderRow.createCell(21);
	 	      subCell.setCellValue("TAX RATE");
	 	      
	 	      
	      }  
	      
	      if(StringUtils.containsIgnoreCase(sectionSelection, "12-MONTH USAGE")){
	    	  sheet.addMergedRegion(new CellRangeAddress(0,0,22,33));
	    	  cell = headerRow.createCell(6);
	    	  cell.setCellStyle(headerCellStyle);
	    	  cell.setCellValue("12-MONTH USAGE");
	    	  
	    	  
	    	  subCell = subHeaderRow.createCell(22);
	 	      subCell.setCellValue("MAY-20");  
	 	      
	 	      subCell = subHeaderRow.createCell(23);
	 	      subCell.setCellValue("APR-20");
	 	      
	 	      subCell = subHeaderRow.createCell(24);
	 	      subCell.setCellValue("MAR-20");
	 	      
	 	      
	 	      subCell = subHeaderRow.createCell(25);
	 	      subCell.setCellValue("FEB-20");
	 	      
	 	      subCell = subHeaderRow.createCell(26);
	 	      subCell.setCellValue("JAN-20");
	 	      
	 	      
	 	      subCell = subHeaderRow.createCell(27);
	 	      subCell.setCellValue("DEC-20");
	 	      
	 	      
	 	     subCell = subHeaderRow.createCell(28);
	 	      subCell.setCellValue("NOV-20");
	 	      
	 	      
	 	      subCell = subHeaderRow.createCell(29);
	 	      subCell.setCellValue("OCT-20");
	 	      
	 	      
	 	      subCell = subHeaderRow.createCell(30);
	 	      subCell.setCellValue("SEP-20");
	 	      
	 	      
	 	      subCell = subHeaderRow.createCell(31);
	 	      subCell.setCellValue("AUG-20");
	 	      
	 	      
	 	     subCell = subHeaderRow.createCell(32);
	 	      subCell.setCellValue("JUL-20");
	 	      
	 	      
	 	      subCell = subHeaderRow.createCell(33);
	 	      subCell.setCellValue("JUN-20");
	 	      
	 	      }  
	     	
	   
	     
				/*
				 * // CellStyle for Age CellStyle ageCellStyle = workbook.createCellStyle();
				 * ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
				 */
	   
	      int rowIdx = 2;
	      for (RateofSale rateofSale : rateofSaleList) {
	        Row row = sheet.createRow(rowIdx++);
	        row.createCell(0).setCellValue(rateofSale.getProductCategoryName());
	        row.createCell(1).setCellValue(rateofSale.getLaxPartNumber());
	        row.createCell(2).setCellValue(rateofSale.getProductName());
	        row.createCell(3).setCellValue(rateofSale.getStockCurrentStock());
	        row.createCell(4).setCellValue(rateofSale.getWeekOfCover());
	        row.createCell(5).setCellValue(rateofSale.getStockPalletes());
	        row.createCell(6).setCellValue(rateofSale.getInTransitStockQtyOrdered());
	        row.createCell(7).setCellValue(rateofSale.getInTransitWeekOfCover());
	        row.createCell(8).setCellValue(rateofSale.getInTransitStockPallets());
	        row.createCell(9).setCellValue(rateofSale.getInTransitStockDeliveryDate());
	        row.createCell(10).setCellValue(rateofSale.getLeadTime());
	        row.createCell(11).setCellValue(rateofSale.getCurrentMonthPurchasedPrice());	        
	        row.createCell(12).setCellValue(rateofSale.getCurrentMonthSupplierName());
	        row.createCell(13).setCellValue(rateofSale.getCurrentMonthCountry());
	        row.createCell(14).setCellValue(rateofSale.getPrevMonthPurchasedPrice());	        
	        row.createCell(15).setCellValue(rateofSale.getPrevMonthSupplierName());
	        row.createCell(16).setCellValue(rateofSale.getPrevMonthCountry());
	        row.createCell(17).setCellValue(rateofSale.getUnitSoldPerDay());
	        row.createCell(18).setCellValue(rateofSale.getUnitSoldPerWeek());
	        row.createCell(19).setCellValue(rateofSale.getTwelveWeekTrendUnit());
	        row.createCell(20).setCellValue(rateofSale.getAvgPrice());
	        row.createCell(21).setCellValue(rateofSale.getTaxRate());
	        row.createCell(22).setCellValue(rateofSale.getMonthOne());
	        row.createCell(23).setCellValue(rateofSale.getMonthTwo());
	        row.createCell(24).setCellValue(rateofSale.getMonthThree());
	        row.createCell(25).setCellValue(rateofSale.getMonthFour());
	        row.createCell(26).setCellValue(rateofSale.getMonthFive());
	        row.createCell(27).setCellValue(rateofSale.getMonthSix());
	        row.createCell(28).setCellValue(rateofSale.getMonthSeven());
	        row.createCell(29).setCellValue(rateofSale.getMonthEight());
	        row.createCell(30).setCellValue(rateofSale.getMonthNine());
	        row.createCell(31).setCellValue(rateofSale.getMonthTen());
	        row.createCell(32).setCellValue(rateofSale.getMonthEleven());
	        row.createCell(33).setCellValue(rateofSale.getMonthTwelve());
	   }
	   
	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    }
	  }
	}