package com.bns.utility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateUtility {
	
	 static final SimpleDateFormat simpleDateformatter = new SimpleDateFormat("dd/MM/yyyy");
	 static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
	
	public  String firstDatOfYear(int year) {
		
		Calendar calendarStart=Calendar.getInstance();
	    calendarStart.set(Calendar.YEAR,year);
	    calendarStart.set(Calendar.MONTH,0);
	    calendarStart.set(Calendar.DAY_OF_MONTH,1);
	    Date startDate=calendarStart.getTime();
	    String strDate= simpleDateformatter.format(startDate);
	    
	    System.out.println("strDate is :"+strDate);
	    
		return strDate;
	}
	
	public  String lastDatOfYear(int year) {
		Calendar calendarStart=Calendar.getInstance();
	    calendarStart.set(Calendar.YEAR,year);
	    calendarStart.set(Calendar.MONTH,11);
	    calendarStart.set(Calendar.DAY_OF_MONTH,31);
	    Date endDate=calendarStart.getTime();
	    String endDatestr= simpleDateformatter.format(endDate);
	    
	    System.out.println("endDatestr is :"+endDatestr);
	    
		return endDatestr;
	}
	
	public String getFirstDate(int year , int month) {
		YearMonth  yearMonth = YearMonth.of( year, month);  
		LocalDate firstOfMonth = yearMonth.atDay( 1 );
		return dateTimeFormatter.format(firstOfMonth); 
	}
		
	public String getLastDate(int year , int month) {
		YearMonth  yearMonth = YearMonth.of( year, month);  
		LocalDate last = yearMonth.atEndOfMonth();
		return dateTimeFormatter.format(last);
	}
	
	public java.sql.Date getFirstDateInSQLFormate(int year , int month) {
		YearMonth  yearMonth = YearMonth.of( year, month);  
		LocalDate firstOfMonth = yearMonth.atDay( 1 );
		return java.sql.Date.valueOf( firstOfMonth );
	}
	public java.sql.Date getLastDateInSQLFormate(int year , int month) {
		YearMonth  yearMonth = YearMonth.of( year, month);  
		LocalDate last = yearMonth.atEndOfMonth();
		
		return java.sql.Date.valueOf( last);
	}

	
}
